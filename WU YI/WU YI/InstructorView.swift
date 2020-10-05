//
//  InstructorView.swift
//  WU YI
//
//  Created by Feiyan on 9/10/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI

struct InstructorView: View {
    
    @Binding var show: Bool
    @State var showHead = false
    @State var showSenior = false
    
    var body: some View {
        GeometryReader { g in
            ZStack {
                ZStack {
                    Rectangle()
                        .fill(Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)))
                    Image(uiImage: #imageLiteral(resourceName: "InstrucorsBackground"))
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                }
                .edgesIgnoringSafeArea(.all)
                
                VStack(spacing: 40) {
                    Button(action: {
                        self.showHead = true
                    }) {
                        Text("HEAD INSTRUCTORS")
                            .fontWeight(.medium)
                            .padding(.horizontal, 22)
                            .padding(.vertical, 8)
                            .background(
                                RoundedRectangle(cornerRadius: 10, style: .continuous)
                                .stroke(lineWidth: 3)
                                .background(Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
                            )
                    }
                    
                    Button(action: {
                        self.showSenior = true
                    }) {
                        Text("SENIOR STUDENTS")
                            .fontWeight(.medium)
                            .padding(.horizontal, 32)
                            .padding(.vertical, 8)
                            .background(
                                RoundedRectangle(cornerRadius: 10, style: .continuous)
                                .stroke(lineWidth: 3)
                                .background(Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
                            )
                    }
                }
                .foregroundColor(Color(#colorLiteral(red: 0.1294117647, green: 0.1294117647, blue: 0.1294117647, alpha: 1)))
                .font(.title)
                
                BackButton(show: self.$show, color: Color(#colorLiteral(red: 0.1294117647, green: 0.1294117647, blue: 0.1294117647, alpha: 1)))
                    .offset(y: g.size.height / 2.5)
                
                if self.showHead {
                    Head(show: self.$showHead)
                }
                
                if self.showSenior {
                    Senior(show: self.$showSenior)
                }
            }
        }
    }
}

struct Senior: View {
    
    @State var showAllison = false
    @State var showShirley = false
    @State var showMike = false
    @Binding var show: Bool
    
    var body: some View {
        ZStack {
            LinearGradient(gradient: Gradient(colors: [Color(#colorLiteral(red: 0.8039215803, green: 0.8039215803, blue: 0.8039215803, alpha: 1)), Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1))]), startPoint: .top, endPoint: .bottom)
                .edgesIgnoringSafeArea(.all)
            VStack {
                Spacer()
                Button(action: {
                    self.showAllison = true
                }) {
                    card(image: #imageLiteral(resourceName: "Allison"), name: "ALLISON CAMPOLO")
                }.sheet(isPresented: $showAllison, onDismiss: {self.showAllison = false}) {
                    info(image: #imageLiteral(resourceName: "Allison"), name: "ALLISON CAMPOLO", information: information[3])
                        .frame(width: UIScreen.screenWidth)
                }
                Spacer()
                Button(action: {
                    self.showShirley = true
                }) {
                    card(image: #imageLiteral(resourceName: "Feiyan"), name: "SHIRLEY THOMPSON")
                }.sheet(isPresented: $showShirley, onDismiss: {self.showShirley = false}) {
                    info(image: #imageLiteral(resourceName: "Feiyan"), name: "SHIRLEY THOMPSON", information: information[4])
                }
                Spacer()
                Button(action: {
                    self.showMike = true
                }) {
                    card(image: #imageLiteral(resourceName: "Curtis"), name: "MIKE MCGREW")
                }.sheet(isPresented: $showMike, onDismiss: {self.showMike = false}) {
                    info(image: #imageLiteral(resourceName: "Curtis"), name: "MIKE MCGREW", information: information[5])
                }
                Spacer()
                BackButton(show: self.$show, color: Color(#colorLiteral(red: 0.1294117647, green: 0.1294117647, blue: 0.1294117647, alpha: 1)))
            }
            .shadow(radius: 10)
            .buttonStyle(PlainButtonStyle())
        }
    }
}

struct Head: View {
    
    @State var showHenry = false
    @State var showJohn = false
    @State var showAlex = false
    @Binding var show: Bool

    var body: some View {
        ZStack {
            LinearGradient(gradient: Gradient(colors: [Color(#colorLiteral(red: 0.8039215803, green: 0.8039215803, blue: 0.8039215803, alpha: 1)), Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1))]), startPoint: .top, endPoint: .bottom)
                .edgesIgnoringSafeArea(.all)
            VStack {
                Spacer()
                Button(action: {
                    self.showHenry = true
                }) {
                    card(image: #imageLiteral(resourceName: "Jarrett"), name: "HENRY SU")
                }.sheet(isPresented: $showHenry, onDismiss: {self.showHenry = false}) {
                    info(image: #imageLiteral(resourceName: "Jarrett"), name: "HENRY SU", information: information[0])
                        .frame(width: UIScreen.screenWidth)
                }
                Spacer()
                Button(action: {
                    self.showJohn = true
                }) {
                    card(image: #imageLiteral(resourceName: "Lucy"), name: "JOHN SU")
                }.sheet(isPresented: $showJohn, onDismiss: {self.showJohn = false}) {
                    info(image: #imageLiteral(resourceName: "Lucy"), name: "JOHN SU", information: information[1])
                }
                Spacer()
                Button(action: {
                    self.showAlex = true
                }) {
                    card(image: #imageLiteral(resourceName: "Alex"), name: "ALEX CAMPOLO")
                }.sheet(isPresented: $showAlex, onDismiss: {self.showAlex = false}) {
                    info(image: #imageLiteral(resourceName: "Alex"), name: "ALEX CAMPOLO", information: information[2])
                }
                Spacer()
                BackButton(show: self.$show, color: Color(#colorLiteral(red: 0.1294117647, green: 0.1294117647, blue: 0.1294117647, alpha: 1)))
            }
            .shadow(radius: 10)
            .buttonStyle(PlainButtonStyle())
        }
    }
}

struct InstructorView_Previews: PreviewProvider {
    static var previews: some View {
        InstructorView(show: .constant(false))
    }
}

struct card: View {
    
    @State var image: UIImage
    @State var name: String
    
    var body: some View {
        ZStack {
            Image(uiImage: image)
                .renderingMode(.original)
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: UIScreen.screenWidth - 40, height: UIScreen.screenHeight / 4)
            .mask(
                RoundedRectangle(cornerRadius: 20, style: .continuous)
            )
            RoundedRectangle(cornerRadius: 20, style: .continuous)
                .fill(Color(#colorLiteral(red: 0, green: 0, blue: 0, alpha: 1)))
                .frame(width: UIScreen.screenWidth - 40, height: UIScreen.screenHeight / 4)
                .opacity(0.2)
            Text(name)
                .font(.title)
                .fontWeight(.medium)
                .foregroundColor(Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
                .shadow(radius: 4)
        }
    }
}

struct info: View {
    
    @State var image: UIImage
    @State var name: String
    @State var information: String
    
    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            Text(name)
                .fontWeight(.medium)
                .font(.largeTitle)
            Text(information)
                .font(.subheadline)
        }
        .padding(.all)
        .frame(width: UIScreen.screenWidth, height: UIScreen.screenHeight)
        .foregroundColor(Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
        .shadow(radius: 4)
        .background(
            Image(uiImage: image).resizable().aspectRatio(contentMode: .fill)
            .overlay(BlurView(style: .systemUltraThinMaterialDark))
        )
    }
}

extension UIScreen{
   static let screenWidth = UIScreen.main.bounds.size.width
   static let screenHeight = UIScreen.main.bounds.size.height
   static let screenSize = UIScreen.main.bounds.size
}

let information = [
    "Dr. Henry Su was first introduced to My Jhong Law Horn Kung Fu by Grandmaster Lee and has been a student since 1985. Hooked after his first lesson, he has continued to study My Jhong Law Horn, Wu Style Tai Chi Chuan and Dragon Style Pa Kua Chang under Grandmaster Lee.  Dr. Su has won several national titles in both Kung Fu and Tai Chi and has performed in numerous events in different parts of the country. In addition to martial arts Dr. Su was a Research Scientist and is currently, Professor of Microbiology at North Lake College in Irving, Texas. He also enjoys playing his bass guitar at jam sessions.",
    "Sifu John Su began his training in the martial arts at the age of four. He was introduced to My Jhong Law Horn Kung Fu by Sifu Henry and Grandmaster Lee. Sifu John achieved the ranking of 3rd degree black belt from Grandmaster Lee. A distinguished competitor, he is an 8-Time World Champion and is featured on ESPN. In October, 2006 Sifu John won a gold in the Second World Traditional Wushu Championships in Zhengzhou, China for Lou Han Chuen (bare-hand routine) and bronze in double flexible weapons with his chain whip routine. In addition to martial arts accomplishments, he earned his bachelors degree in Management Information Systems from UT-Dallas and MBA from UT-Austin. ",
    "Alex Campolo started Tai Chi and Kung Fu with Sifu Henry at North Lake College in the Spring of 2003. He enrolled in the Wu Yi school to continue his study. He was there at Wu Yi's first belt test and went on to become the Wu Yi school's first black belt in 2012. Alex is one of the Kung Fu school's primary instructors, a demo team coordinator, and a major competitor on the ICMAC circuit. He has many local and regional titles in addition to being a three time world champion in the men's forms divisions. He received his Masters in Business Administration at the University of North Texas and spends his time outside of Kung Fu as a financial analyst and real estate manager.",
    "Allison Campolo started Kung Fu with Sifu Henry (and her mom, Shirley Thompson) at North Lake College and Master Lee's Richardson school in the Spring of 2003.  She was thrilled to be asked to be on the team to help open and teach classes at the Wu Yi School in Coppell in February 2004. She has earned many regional and national titles on the ICMAC circuit in both forms and light contact sparring. Allison is also three time world champion in the women's heavy weight sparring division. She earned her black belt in December of 2013.",
    "Shirley Thompson, math department chairperson at North Lake College, has been studying Wu Style Tai Chi over ten years.   She's been coaching and teaching a variety of other sports for more than 40 years.  A student of Dr. Henry Su since 2000, she also studies Tai Chi under Dr. Su's  instructor Grandmaster Johnny Lee. Shirley earned her black belt in 2016. In her off hours you will usually find her enjoying her family,  good restaurants, her animals, travel and small building projects. ",
    "Sihing Mike has had a deep love of martial arts that started as a teenager while watching Blackbelt Theater on Saturday mornings.  Sihing Mike has studied various styles of martial arts which includes Kung Fu, Wushu, Aikido and Shaolin Kempo Karate. Mike has won numerous state and national martial arts tournaments. He earned his black belt in 2018.  In addition to his martial arts studies, Mike is a Network Engineer and is married with two kids."
]
