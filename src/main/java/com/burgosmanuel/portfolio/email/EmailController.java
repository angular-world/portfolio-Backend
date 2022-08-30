package com.burgosmanuel.portfolio.email;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EmailController {
    @Autowired
    EmailServiceImpl mailService;
    
    @PostMapping("/api/enviar")
    public void sendEmail(@RequestBody Email email) throws MessagingException, UnsupportedEncodingException {
        mailService.sendEmail(email.getReceptor(), email.getNombre(), email.getMensaje(), email.getEmisor());
    }
}
