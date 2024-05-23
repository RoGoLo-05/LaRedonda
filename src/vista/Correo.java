package vista;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Correo {

    public static void enviarCorreo(String destinatario, String nombre, String apellidos, int telefono, String nombreUsuario, String contraseñaUsuario) {

        // El correo y contraseña desde donde se enviará el correo
        final String remitente = "laredondainformacion@gmail.com";
        final String contraseña = "drjubsrtmplgrdjd";

        // El host de correo
        String host = "smtp.gmail.com";

        // Propiedades de la sesión
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Inicio de sesión
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, contraseña);
            }
        });

        // Creación del mensaje
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject("Bienvenido a LaRedonda");
            message.setText("¡Gracias por registrarte en LaRedonda! Esperamos que disfrutes de nuestra plataforma.\n\n" +
                    "Información del registro:\n" +
                    "- Nombre: " + nombre + "\n" +
                    "- Apellidos: " + apellidos + "\n" +
                    "- Teléfono: " + telefono + "\n" +
                    "- Correo electrónico: " + destinatario + "\n\n" +
                    "Datos del usuario:\n" +
                    "- Nombre de usuario: " + nombreUsuario + "\n" +
                    "- Contraseña de usuario: " + contraseñaUsuario);
            
            // Envío del mensaje
            Transport.send(message);
            System.out.println("Mensaje enviado correctamente.");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}