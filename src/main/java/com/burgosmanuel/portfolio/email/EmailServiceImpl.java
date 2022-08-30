package com.burgosmanuel.portfolio.email;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String receptor, String nombre, String mensaje, String emisor) throws MessagingException, UnsupportedEncodingException {
        // Creamos el mensaje a enviar y el helper
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        // Utilizamos etiquetas HTML para el mensaje y bindeamos los datos
        String mailContent = "<h3 style=\"text-align: center; font-weight: normal;\">¡<strong>"+ nombre +"</strong> ha dejado un mensaje en tu portfolio!</h3>"
                + "<table\n"
                + "  style=\"\n"
                + "    font-family: 'Trebuchet MS', Arial, Helvetica, sans-serif;\n"
                + "    border-collapse: collapse;\n"
                + "    width: 100%;\n"
                + "  \"\n"
                + ">\n"
                + "  <thead>\n"
                + "    <tr>\n"
                + "      <th\n"
                + "        style=\"\n"
                + "          border: 1px solid #ddd;\n"
                + "          padding: 12px 8px;\n"
                + "          text-align: left;\n"
                + "          background-color: #354d91;\n"
                + "          color: white;\n"
                + "        \"\n"
                + "      >\n"
                + "        Nombre\n"
                + "      </th>\n"
                + "      <th\n"
                + "        style=\"\n"
                + "          border: 1px solid #ddd;\n"
                + "          padding: 12px 8px;\n"
                + "          text-align: left;\n"
                + "          background-color: #354d91;\n"
                + "          color: white;\n"
                + "        \"\n"
                + "      >\n"
                + "        E-Mail\n"
                + "      </th>\n"
                + "      <th\n"
                + "        style=\"\n"
                + "          border: 1px solid #ddd;\n"
                + "          padding: 12px 8px;\n"
                + "          text-align: left;\n"
                + "          background-color: #354d91;\n"
                + "          color: white;\n"
                + "        \"\n"
                + "      >\n"
                + "        Mensaje\n"
                + "      </th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>\n"
                + "    <tr>\n"
                + "      <td style=\"border: 1px solid #ddd; padding: 8px\">" + nombre + "</td>\n"
                + "      <td style=\"border: 1px solid #ddd; padding: 8px\">" + emisor + "</td>\n"
                + "      <td style=\"border: 1px solid #ddd; padding: 8px\">" + mensaje + "</td>\n"
                + "    </tr>\n"
                + "  </tbody>\n"
                + "</table>";

        // Configuramos el dominio personalizado y el nombre a mostrar en el email enviado.
        helper.setFrom("mensajes@burgosmanuel.ar", "Mensajes Portfolio");
        helper.setTo(receptor);
        helper.setSubject("Portfolio - Mensaje de: " + nombre);
        helper.setText(mailContent, true);

        // Enviamos el mail
        emailSender.send(message);
    }
}
