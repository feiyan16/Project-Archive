//
//  BackButton.swift
//  WU YI
//
//  Created by Feiyan on 9/8/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI

struct BackButton: View {
    @Binding var show : Bool
    @State var color: Color
    
    var body: some View {
        Button(action: {
            self.show = false;
        }) {
            VStack(spacing: 8) {
                Text("Go Back")
                    .fontWeight(.medium)
                    .font(.system(.title, design: .default))
                    .foregroundColor(color)
                RoundedRectangle(cornerRadius: 1.5, style: .continuous)
                    .fill(colorTheme)
                    .frame(width: 100, height: 3)
            }
        }
    }
}

struct BackButton_Previews: PreviewProvider {
    static var previews: some View {
        BackButton(show: .constant(false), color: Color(#colorLiteral(red: 1.0, green: 1.0, blue: 1.0, alpha: 1.0)))
    }
}
