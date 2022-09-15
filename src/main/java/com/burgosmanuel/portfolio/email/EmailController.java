package com.burgosmanuel.portfolio.email;

import io.swagger.v3.oas.annotations.Operation;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://burgosmanuel.ar")
@RestController
public class EmailController {
    @Autowired
    EmailServiceImpl mailService;
    
     // Ocultamos en la documentación por ahora.
    @Operation(hidden = true)
    @PostMapping("/api/enviar")
    public void sendEmail(@RequestBody Email email) throws MessagingException, UnsupportedEncodingException {
        mailService.sendEmail(email.getReceptor_id(), email.getNombre(), email.getMensaje(), email.getEmisor());
    }
}
