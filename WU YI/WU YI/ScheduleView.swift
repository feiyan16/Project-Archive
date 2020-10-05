//
//  ScheduleView.swift
//  WU YI
//
//  Created by Feiyan on 9/9/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI

struct ScheduleView: View {
    
    @Binding var show : Bool
    @State var showKF = false
    @State var showTC = false
    
    var body: some View {
        GeometryReader { g in
            ZStack {
                ZStack {
                    Image(uiImage: #imageLiteral(resourceName: "SchBackground"))
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                    Rectangle()
                        .fill(Color(#colorLiteral(red: 0, green: 0, blue: 0, alpha: 1)))
                        .opacity(0.4)
                }
                .edgesIgnoringSafeArea(.all)
                
                VStack(spacing: 40) {
                    Button(action: {
                        self.showKF = true
                    }) {
                        Text("KUNG FU")
                            .fontWeight(.medium)
                            .padding(.horizontal, 22)
                            .padding(.vertical, 8)
                            .overlay(
                                RoundedRectangle(cornerRadius: 10, style: .continuous)
                                .stroke(lineWidth: 4)
                            )
                    }
                    .shadow(radius: 4)
                    
                    Button(action: {
                        self.showTC = true
                    }) {
                        Text("TAI CHI")
                            .fontWeight(.medium)
                            .padding(.horizontal, 38)
                            .padding(.vertical, 8)
                            .overlay(
                                RoundedRectangle(cornerRadius: 10, style: .continuous)
                                    .stroke(lineWidth: 4)
                            )
                    }
                    .shadow(radius: 4)
                }
                .foregroundColor(Color.white)
                .font(.largeTitle)
                
                BackButton(show: self.$show, color: Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
                    .offset(y: g.size.height / 2.5)
                
                if self.showKF {
                    kf()
                        .frame(width: g.size.width - 40, height: g.size.height - 80, alignment: .center)
                        .onTapGesture {
                            self.showKF = false
                        }
                }
                
                if self.showTC {
                    tc()
                        .frame(width: g.size.width - 40, height: g.size.height - 80, alignment: .center)
                        .onTapGesture {
                            self.showTC = false
                        }
                }
            }
        }
    }
}

struct kf: View {
    var body: some View {
        ZStack {
            BlurView(style: .systemUltraThinMaterialDark)
                .cornerRadius(18)
            VStack {
                Spacer()
                VStack {
                    Text("BEGINNERS")
                        .fontWeight(.medium)
                    Text("Mondays & Wednesdays")
                    Text("5:30pm - 6:30pm")
                    .font(.largeTitle)
                }
                Spacer()
                VStack {
                    Text("INTERMEDIATE")
                    .fontWeight(.medium)
                    Text("Tuesdays & Thursdays")
                    Text("6:30pm - 7:30pm")
                    .font(.largeTitle)
                }
                Spacer()
                VStack {
                    HStack {
                        Text("OPEN")
                        .fontWeight(.medium)
                        Text("(ALL CATEGORIES & AGES)").font(.footnote)
                    }
                    Text("Saturdays")
                    Text("11:00am - 12:00pm")
                    .font(.largeTitle)
                }
                Spacer()
            }
            .foregroundColor(Color.white)
            .font(.title)
        }
    }
}

struct tc: View {
    var body: some View {
        ZStack {
            BlurView(style: .systemUltraThinMaterialDark)
                .cornerRadius(18)
            VStack {
                Spacer()
                VStack {
                    Text("BEGINNERS")
                        .fontWeight(.medium)
                    Text("Tuesdays & Fridays")
                    Text("7:30pm - 9:00pm")
                    .font(.largeTitle)
                }
                Spacer()
                VStack {
                    Text("INTERMEDIATE")
                    .fontWeight(.medium)
                    Text("Thursdays")
                    Text("7:30pm - 9:00pm")
                    .font(.largeTitle)
                }
                Spacer()
                VStack {
                    Text("ADVANCED")
                    .fontWeight(.medium)
                    Text("Wednesdays")
                    Text("7:30pm - 9:00pm")
                    .font(.largeTitle)
                }
                Spacer()
                VStack {
                    HStack {
                        Text("OPEN")
                        .fontWeight(.medium)
                        Text("(ALL CATEGORIES & AGES)").font(.footnote)
                    }
                    Text("Saturdays")
                    Text("10:00am - 11:00am")
                    .font(.largeTitle)
                }
                Spacer()
            }
            .foregroundColor(Color.white)
            .font(.title)
        }
    }
}

struct ScheduleView_Previews: PreviewProvider {
    static var previews: some View {
        ScheduleView(show: .constant(false))
    }
}
