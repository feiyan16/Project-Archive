package semaphore_threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class DoctorsOffice implements Runnable {
	
	Semaphore patientWaiting, registration, leavesReceptionist, nextPatient, notifyNurse, nurseCall, knockKnock, prescription, officeFree;
	String name;
	int id;
	
	public static int curPatientID;
	public static int curDocID;
	
	public static Queue<Integer> qforRec = new LinkedList<Integer>();
	public static Queue<Integer> qforNur = new LinkedList<Integer>();
	
	// patient constructor
	public DoctorsOffice(Semaphore a, Semaphore b, Semaphore c, Semaphore d, Semaphore e, Semaphore f, Semaphore g, 
			Semaphore h, Semaphore i, String name, int id) {
		patientWaiting = a;
		registration = b;
		leavesReceptionist = c;
		nextPatient = d;
		notifyNurse = e;
		nurseCall = f;
		knockKnock = g;
		prescription = h;
		officeFree = i;
		this.name = name;
		this.id = id;
	}
	
	// receptionist constructor
	public DoctorsOffice(Semaphore a, Semaphore b, Semaphore c, Semaphore d, Semaphore e, String name) {
		patientWaiting = a;
		registration = b;
		leavesReceptionist = c;
		nextPatient = d;
		notifyNurse = e;
		this.name = name;
	}
	
	// nurse constructor
	public DoctorsOffice(Semaphore a, Semaphore b, Semaphore c, String name, int id) {
		notifyNurse = a;
		nurseCall = b;
		officeFree = c;
		this.name = name;
		this.id = id;
	}
	
	// doctor constructor
	public DoctorsOffice(Semaphore a, Semaphore b, String name, int id) {
		knockKnock = a;
		prescription = b;
		this.name = name;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		// patient thread action
		if (this.name.contains("Patient")) {
			
			patient();
			
		}
		
		// receptionist thread actions
		if (this.name.contains("Receptionist")) {
			
			receptionist();
		}
		
		// nurse thread actions
		if (this.name.contains("Nurse")) {
			
			nurse();
		}
		
		// doctor thread actions
		if (this.name.contains("Doctor")) {
			
			doctor();
		}
		
		// exit program if queues are empty
		if (qforRec.isEmpty() && qforNur.isEmpty()) {
			System.exit(0);
		}
		
	}

	private void doctor() {
		
		while(true) {
			
			// wait for patient to enter
			try {
				knockKnock.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(this.name + " " + curDocID + " listens to patient " + curPatientID + "'s symptoms");
			
			// signal to patient that advice is given
			prescription.release();
			
		}
	}

	private void nurse() {
		
		while(true) {
			
			// wait for receptionist notification
			try {
				notifyNurse.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			curPatientID = qforNur.poll();
			
			// wait for office to be free
			try {
				officeFree.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			curDocID = this.id;
			
			System.out.println(this.name + " " + curDocID + " takes patient " + curPatientID + " to doctor " + curDocID + "'s office");
			
			// signal to patient to enter office
			nurseCall.release();
		
		}
	}

	private void receptionist() {
		
		while(true) {
			
			// wait for patient to enter
			try {
				patientWaiting.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Receptionist registers patient " + qforRec.poll());
			
			// signal registration complete
			registration.release();
			
			// wait for patient to leave receptionist
			try {
				leavesReceptionist.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// signal to nurse of patient waiting
			notifyNurse.release();
			
			// signal for next patient to enter
			nextPatient.release();
			
		}
	}

	private void patient() {
		
		// wait for receptionist to call
		try {
			nextPatient.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(this.name + " " + this.id + " enters waiting room, waits for receptionist");
		
		// enter queue for registration
		qforRec.add(this.id);
		
		// signal to receptionist ready for registration
		patientWaiting.release();
		
		// wait for registration to be complete
		try {
			registration.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(this.name + " " + this.id + " leaves receptionist and sits in waiting room");
		
		// signal left receptionist
		leavesReceptionist.release();
		
		// enter queue for doctor's office via nurse
		qforNur.add(this.id);
		
		// wait for a nurse to call
		try {
			nurseCall.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(this.name + " " + this.id + " enters doctor " + curDocID + "'s office");
		
		// signal entering office
		knockKnock.release();
		
		// wait for doctor's advice
		try {
			prescription.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(this.name + " " + this.id + " receives advice from doctor " + curDocID);
		
		System.out.println(this.name + " " + this.id + " leaves");
		
		// signal left office
		officeFree.release();
	}
	
	public static void main(String [] args) throws InterruptedException {
		
		// declare integer variables for number of doctors and patients
		int patient_ct = 30, doctor_ct = 3;
		
		// Validate input
		if (args.length == 0) {
			
			// no doctor and patient input
			System.out.println("Please enter number of doctors and patients");
			System.exit(0);
			
		} else if (args.length == 1) {
			
			// no patient count
			System.out.println("Please enter number of patients");
			System.exit(0);
			
		} else if (args.length == 2) {
			
			// check if doctor count exceeds max
			doctor_ct = Integer.valueOf(args[0]);
			
			if (doctor_ct > 3) {
				System.out.println("There can only be a maximum of 3 doctors");
				System.exit(0);
				
			}
			
			// check if patient count exceeds max
			patient_ct = Integer.valueOf(args[1]);
			
			if (patient_ct > 30) {
				System.out.println("There can only be a maximum of 30 patients");
				System.exit(0);
			}
			
		} else {
			
			// anything else, exit
			System.exit(0);
		}
		
		
		System.out.println("Run with " + patient_ct + " patients, " + doctor_ct + " nurses, " + doctor_ct + " doctors\n");
		
		// total thread counts without receptionist
		int thread_ct = patient_ct + doctor_ct;
		
		// keep track of doctors and nurses created
		int count = 0;
		
		// Create semaphores to pass to threads;
		Semaphore patientWaiting = new Semaphore(0, true);
		Semaphore registration = new Semaphore(0, true);
		Semaphore leavesReceptionist = new Semaphore(0, true);
		Semaphore nextPatient = new Semaphore(1, true);
		Semaphore notifyNurse = new Semaphore(0, true);
		Semaphore nurseCall = new Semaphore(0, true);
		Semaphore knockKnock = new Semaphore(0, true);
		Semaphore prescription = new Semaphore(0, true);
		Semaphore officeFree = new Semaphore(1, true);
		
		// arraylist to hold all the threads
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		// create and start one receptionist thread
		DoctorsOffice receptionist = new DoctorsOffice (
				patientWaiting, 
				registration,
				leavesReceptionist, 
				nextPatient,
				notifyNurse,
				"Receptionist");
		
		Thread receptionistThread = new Thread(receptionist);
//		receptionistThread.setDaemon(true);
		threads.add(receptionistThread);
		receptionistThread.start();
		
		// create patient, nurse, and doctor threads
		for(int i = 0; i < thread_ct; i++) {
			
			// create patient threads patient_ct # of times
			if (i < patient_ct) {
				
				String name = "Patient";
				
				DoctorsOffice patient = new DoctorsOffice (
						patientWaiting, 
						registration,
						leavesReceptionist, 
						nextPatient,
						notifyNurse,
						nurseCall,
						knockKnock,
						prescription,
						officeFree,
						name, i);
				Thread patientThread = new Thread(patient);
//				patientThread.setDaemon(true);	
				
				threads.add(patientThread);
				patientThread.start();
			
				// create nurse and doctor threads for doctor_ct # of times
			} else if (i >= patient_ct && i < thread_ct) {
				
				String nurseName = "Nurse";
				String docName = "Doctor";
				
				DoctorsOffice nurse = new DoctorsOffice (
						notifyNurse,
						nurseCall,
						officeFree,
						nurseName, count);
				
				DoctorsOffice doctor = new DoctorsOffice (
						knockKnock,
						prescription,
						docName, count);
				
				Thread nurseThread = new Thread(nurse);
				Thread docThread = new Thread(doctor);
				
//				nurseThread.setDaemon(true);				
//				docThread.setDaemon(true);
				
				threads.add(nurseThread);
				threads.add(docThread);
				
			
				nurseThread.start();
				docThread.start();
				
				count++;
			}
		}
		
		// join threads
		for (int i = 0; i < thread_ct + doctor_ct; i++) {
			threads.get(i).join();
		}

	}
	
}