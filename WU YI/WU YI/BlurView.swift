//
//  BlurView.swift
//  WU YI
//
//  Created by Feiyan on 9/8/20.
//  Copyright © 2020 Feiyan. All rights reserved.
//

import SwiftUI

struct BlurView: UIViewRepresentable {
    var style : UIBlurEffect.Style = .systemUltraThinMaterialDark
    
    func makeUIView(context: Context) -> UIVisualEffectView {
        return UIVisualEffectView(effect: UIBlurEffect(style: style))
    }
    func updateUIView(_ uiView: UIVisualEffectView, context: Context) {
        uiView.effect = UIBlurEffect(style: style)
    }
}

struct BlurView_Previews: PreviewProvider {
    static var previews: some View {
        BlurView()
    }
}
