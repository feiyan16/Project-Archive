import java.io.FileWriter;
import java.io.IOException;

public class Steps {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
	         System.out.println(
	               "Supply n (> 0) and a filename as program arguments.\n");
	         System.exit(1);
	    }

		int n = 0;
	      try {
	         n = Integer.valueOf(args[0]).intValue();

	         if (n <= 0)
	            throw new NumberFormatException();
	      } catch (NumberFormatException e) {
	         System.out.println("n must be an integer > 0");
	         System.exit(1);
	      }
	      
	      new StepObj(n, args[1]);
	}
}

class Point3D {
	   float x, y, z;
	   Point3D(double x, double y, double z) {
	      this.x = (float) x; this.y = (float) y; this.z = (float) z;
	   }
	}

class StepObj {
	
	FileWriter fw;
	
	StepObj(int n, String filename) throws IOException {
		fw = new FileWriter(filename);
		
		int u = 10;
		int w = 25;
		
		Point3D[] p = new Point3D[8];
		p[0] = new Point3D(u, 0, 0);
		p[1] = new Point3D(u, w, 0);
		p[2] = new Point3D(0, w, 0);
		p[3] = new Point3D(0, 0, 0);
		
		for(int i = 0; i < 4; i++) {
			fw.write(i + 1 + " " + (int)p[i].x * n + " " + (int)p[i].y + " " + (int)p[i].z + "\n");
		}
		
		int A = 5;
		int x = n;
		
		for(int i = 1; i <= n; i++) {
			int count = 0;
			for(int j = 0; j < 4; j++) {
				int X = (int) (p[j].x * x);
				int Y = (int) p[j].y;
				int Z = (int) (p[j].z + u * i);
				if (count >= 2) {
					X = x * u - 10;
				}
				fw.write(A + " " + X + " " + Y + " " + Z + "\n");
				A++;
				count++;
			}
			x--;
		}

		fw.write("Faces:\n");
		fw.write("1 4 3 2.\n");
		fw.write("1 2 6 5.\n");
		fw.write("4 3 " + (A - 2) + " " + (A - 1) + ".\n");
		int a = 1, b = 2, c = 3, d = 4;
		for(int i = 0; i < n; i++) {
			fw.write((a += 4) + " " + (b += 4) + " " + (c += 4) + " " + (d += 4) + ".\n");
		}
		int e = 4, f = 3, g = 6, h = 5;
		for(int i = 0; i < n - 1; i++) {
			fw.write((e += 4) + " " + (f += 4) + " " + (g += 4) + " " + (h += 4) + ".\n");
		}
		int f1 = A + 2;
		int f2 = f1 - 1;
		String str1 = "2 3 ";
		for(int i = 0; i < n; i++) {
			str1 += (f1 -= 4) + " " + (f2 -= 4) + " ";
		}
		fw.write(str1.trim() + ".\n");
		
		int f3 = A + 3;
		int f4 = f3 - 3;
		String str2 = "1 4 ";
		for(int i = 0; i < n; i++) {
			str2 += (f3 -= 4) + " " + (f4 -= 4) + " ";
		}
		fw.write(str2.trim() + ".\n");
		
		fw.close();
	}
}
