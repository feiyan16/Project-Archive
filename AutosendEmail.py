import datetime as dt
import time
import os
import smtplib
import imghdr
from email.message import EmailMessage

def send_email():
    msg = EmailMessage()
    msg['Subject'] = "Testing Phase 1"
    msg['From'] = "feiyan.su16@gmail.com"
    msg['To'] = "allison.campolo@gmail.com, feiyan.su16@gmail.com"
    msg.set_content('testing 123')

    with open('TestMeeting.html', 'rb') as f:
        file_data = f.read()
        file_type = imghdr.what(f.name)
        file_name = f.name

    file_string = file_data.decode(encoding='UTF-8')

    msg.add_alternative(file_string, subtype='html')
    
    with smtplib.SMTP_SSL('smtp.gmail.com', 465) as smtp:
        smtp.login("feiyan.su16@gmail.com", "S9833547@sfy")

        smtp.send_message(msg)
        
        smtp.quit()
    
    print("email sent")


def send_email_at(send_time):
    time.sleep(send_time.timestamp() - time.time())
    send_email()
    print("email sent")

first_email_time = dt.datetime(2020,7,15,11,21,0)
interval = dt.timedelta(days = 1)

send_time = first_email_time

while True:
    send_email_at(send_time)
    send_time = send_time + interval


