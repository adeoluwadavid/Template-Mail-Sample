/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.FreeMarkerMail2.user.controller;

import com.example.FreeMarkerMail2.service.EmailService;
import com.example.FreeMarkerMail2.user.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/sendMail")
    public String sendEmail(@RequestBody User user){
        Map<String,Object> model = new HashMap<>();
        model.put("Name", user.getFirstName() + user.getLastName());
        model.put("Location","Ibadan, Nigeria");
        emailService.sendEmail(user, model);
        return "Email Sent Successfully";
    }
}
