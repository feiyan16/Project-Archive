//
//  ViewController.swift
//  News
//
//  Created by Feiyan Su on 6/14/20.
//  Copyright © 2020 Feiyan Su. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var searchTextField: UITextField!
    @IBOutlet weak var searchButton: UIButton!
    @IBOutlet weak var menuPageView: UIView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        searchTextField.layer.borderColor = UIColor.white.cgColor
        searchTextField.layer.borderWidth = 2
        searchTextField.layer.cornerRadius = 22
        searchButton.layer.borderColor = UIColor.white.cgColor
        searchButton.layer.borderWidth = 2
        searchButton.layer.cornerRadius = 10
        menuPageView.layer.cornerRadius = 50
        menuPageView.layer.maskedCorners = [.layerMinXMinYCorner]
    }


}

