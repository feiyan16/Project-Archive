//
//  MenuButtons.swift
//  WU YI
//
//  Created by Feiyan on 9/7/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI

struct MenuButtons: View {
    
    @Binding var show : Bool
    @Binding var text : String
    
    var body: some View {
        Button(action: {
          self.show = true
        }) {
            VStack(spacing: 8) {
                Text(String(text))
                    .foregroundColor(Color(#colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)))
                    .fontWeight(.medium)
                    .font(.system(.title, design: .default))
                    .shadow(radius: 2)
                RoundedRectangle(cornerRadius: 1.5, style: .continuous)
                    .fill(colorTheme)
                    .frame(width: 100, height: 3)
            }
        }
    }
}

struct MenuButtons_Previews: PreviewProvider {
    static var previews: some View {
        MenuButtons(show: .constant(false), text: .constant(""))
    }
}
