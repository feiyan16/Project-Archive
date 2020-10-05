//
//  AboutUsView.swift
//  WU YI
//
//  Created by Feiyan on 9/8/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI
import MessageUI
import UIKit

struct AboutUsView: View {
    
    @Binding var show : Bool
    @State var showMail = false
    @State var result: Result<MFMailComposeResult, Error>? = nil
    
    var body: some View {
        ScrollView {
            VStack(spacing: 50) {
                VStack(spacing: 20){
                    Text("About Us")
                        .font(.largeTitle)
                        .fontWeight(.medium)
                    
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                        .font(.system(.body, design: .default))
                        .lineSpacing(10)
                        .multilineTextAlignment(.leading)
                }
                
                VStack(alignment: .center, spacing: 20) {
                    Text("How to Contact Us")
                        .font(.largeTitle)
                        .fontWeight(.medium)
                        
                    VStack {
                        Text("Social Media")
                            .font(.headline)
                            .fontWeight(.medium)
                        Button(action: {
                            let url = URL(string: "https://www.facebook.com/pages/Wu-Yi-Shaolin-Martial-Arts-Center/156997654321499")
                            UIApplication.shared.open(url!)
                        }) {
                            Image(uiImage: #imageLiteral(resourceName: "facebook"))
                                .renderingMode(.original)
                        }
                    }
                    
                    VStack {
                        Text("Address")
                        .font(.headline)
                        .fontWeight(.medium)
                        Button(action: {
                            let url = URL(string: "https://www.google.com/maps/dir//773+S+MacArthur+Blvd,+Coppell,+TX+75019/data=!4m6!4m5!1m1!4e2!1m2!1m1!1s0x864c28de3e1b5e4f:0xe714c20ef275a301?sa=X&ved=2ahUKEwi_m5yWuNrrAhUHjq0KHY1gCzQQwwUwAHoECAsQAw")
                            UIApplication.shared.open(url!)
                        }) {
                            VStack(spacing: 4) {
                                Text("773 S.MacArthur Blvd - Suite 209\nCoppell TX 75019")
                                    .underline(true, color: Color.white)
                                    .frame(height: 50)
                            }
                        }
                    }
                    
                    VStack {
                        Text("Email")
                        .font(.headline)
                        .fontWeight(.medium)
                        Button(action: {
                            if MFMailComposeViewController.canSendMail() {
                                self.showMail = true
                            } else {
                                print ("Error")
                            }
                            
                        }) {
                            Text("wuyikungfu@gmail.com")
                                .underline(true, color: Color.white)
                        }
                    }
                    
                    VStack {
                        Text("Telephone")
                        .font(.headline)
                        .fontWeight(.medium)
                        Button(action: {
                            let url = URL(string:"tel://972-393-9931")
                            UIApplication.shared.open(url!)
                        }) {
                            Text("972-393-9931")
                            .underline(true, color: Color.white)
                        }
                    }
                
                    VStack {
                        Text("Office Hours")
                        .font(.headline)
                        .fontWeight(.medium)
                        VStack(spacing: 0) {
                            Text("Monday - Friday 5:30pm - 8:30pm")
                            Text("Saturday 10:00am - 12:00pm")
                        }
                    }
                }
                
                BackButton(show: $show, color: Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
            }
            .foregroundColor(Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)))
            .padding(20)
            .multilineTextAlignment(.center)
        }
        .background(
            ZStack {
                Image(uiImage: #imageLiteral(resourceName: "AbtBackground"))
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                BlurView(style: .systemUltraThinMaterialDark)
            }
            .edgesIgnoringSafeArea(.all)
        )
        .opacity(self.show ? 1 : 0)
        .sheet(isPresented: $showMail) {
            MailView(result: self.$result, newSubject: "", newMsgBody: "")
        }
    }
}

struct AboutUsView_Previews: PreviewProvider {
    static var previews: some View {
        AboutUsView(show: .constant(true))
    }
}
