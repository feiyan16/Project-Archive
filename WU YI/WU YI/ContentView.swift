//
//  ContentView.swift
//  WU YI
//
//  Created by Feiyan on 9/6/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI
import Foundation
import WebKit

let colorTheme = LinearGradient(gradient: Gradient(colors: [Color(#colorLiteral(red: 0.9372549057, green: 0.2556272312, blue: 0.1921568662, alpha: 1)), Color(#colorLiteral(red: 0.9529411793, green: 0.6862745285, blue: 0.1333333403, alpha: 1))]), startPoint: .leading, endPoint: .trailing)

struct ContentView: View {

  @State var showAbout = false
  @State var showSchedule = false
  @State var showInstructors = false
  @State var showReviews = false
  
  @State var abtUs = "About Us"
  @State var sch = "Schedule"
  @State var inst = "Instructors"
  @State var rev = "Reviews"

  var body: some View {
    ZStack {
      ScrollView {
        VStack(spacing: 36) {
          Spacer()
          
          WelcomeView()
          
          Spacer()
          
          /* Menu */
          VStack(spacing: 40) {
            MenuButtons(show: $showAbout, text: $abtUs)
            MenuButtons(show: $showSchedule, text: $sch)
            MenuButtons(show: $showInstructors, text: $inst)
            MenuButtons(show: $showReviews, text: $rev)
          }
        }
      }
      .background(
        ZStack {
          Image(uiImage:#imageLiteral(resourceName: "HomeBackground"))
            .resizable()
            .aspectRatio(contentMode: .fill)
          Rectangle()
            .fill(Color(#colorLiteral(red: 0, green: 0, blue: 0, alpha: 1)))
            .opacity(0.2)
        }
        .edgesIgnoringSafeArea(.all)
      )

      if showAbout == true {
        AboutUsView(show: $showAbout)
      }

      if showSchedule == true {
        ScheduleView(show: $showSchedule)
      }

      if showInstructors == true {
        InstructorView(show: $showInstructors)
      }

      if showReviews == true {
        ReviewsView(show: $showReviews)
      }
    }
  }
}

struct WelcomeView: View {

  var body: some View {
  /* Title */
    VStack {
      Text("WUYI SHAOLIN")
      Text("MARTIAL ARTS")
    }
    .font(.system(size: 48, weight: .semibold, design: .default))
    .foregroundColor(Color.white)
    .shadow(radius: 10)
  }
}

struct ReviewsView: View {

  @Binding var show : Bool

  var body: some View {
    NavigationView {
      Reviews(url: "https://www.google.com/search?sxsrf=ALeKk009w8PkfPax3hvdFLQ9MbgHCjITSA%3A1599795751030&ei=J_JaX4mzAcPwsAWo656IDQ&q=wu+yi+shaolin+martial+arts&oq=wuyishaolinmarti&gs_lcp=CgZwc3ktYWIQAxgAMgcIIxCwAhAnMgcIIxCwAhAnOgQIIxAnOgUIABCRAjoICAAQsQMQgwE6BQgAELEDOgQIABBDOgcIABCxAxBDOgIIADoECAAQCjoECAAQDToICAAQCBANEB46BQghEKsCUOAfWPw1YJ48aAFwAXgAgAF5iAHfDJIBBDEzLjSYAQCgAQGqAQdnd3Mtd2l6wAEB&sclient=psy-ab#lrd=0x864c28de3de2aac1:0x863df59ed87ae4a0,1,,,")
        .navigationBarItems(leading: Button(action: {
          self.show = false
        }) {Text("Back")})
        .navigationBarTitle("Reviews", displayMode: .inline)
    }
  }
}

struct Reviews: UIViewRepresentable {
  
  var url: String
  
  func makeUIView(context: Context) -> WKWebView {
    guard let url = URL(string: self.url) else {
      return WKWebView()
    }
    
    let request = URLRequest(url: url)
    let wkWebView = WKWebView()
    
    wkWebView.load(request)
    
    return wkWebView
  }
  
  func updateUIView(_ uiView: WKWebView, context: UIViewRepresentableContext<Reviews>) {}
  
}

struct ContentView_Previews: PreviewProvider {
  static var previews: some View {
    ContentView()
  }
}
