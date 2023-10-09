package org.example.controller;

import org.example.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/emails")
    public String getEmails(Model model) {
        model.addAttribute("emailList", emailService.getEmailAddresses());
        return "emailPage";
    }

    @PostMapping("/addEmail")
    public String addEmail(@RequestParam String newEmail) {
        emailService.addEmailAddress(newEmail);
        return "redirect:/emails";
    }

    @GetMapping("/editEmail")
    public String editEmail(@RequestParam String email, Model model) {
        model.addAttribute("emailToEdit", email);
        return "editEmailPage";
    }

    @PostMapping("/saveEmail")
    public String saveEmail(@RequestParam String emailToEdit, @RequestParam String editedEmail) {
        emailService.updateEmailAddress(emailToEdit, editedEmail);
        return "redirect:/emails";
    }

    @GetMapping("/deleteEmail")
    public String deleteEmail(@RequestParam String email) {
        emailService.deleteEmailAddress(email);
        return "redirect:/emails";
    }
}

