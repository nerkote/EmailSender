
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<String> emailList = new ArrayList<>();
        emailList = readingEmails();
        String from = "Enter Your email";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", "Monitoring96");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("Your email", "Your email password");

            }

        });

        session.setDebug(true);

        try {
            for (int i = 0; i < emailList.size(); i++) {

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailList.get(i)));
                message.setSubject("Enter Subject");
                message.setText("Enter your message");

                Transport.send(message);
                System.out.println("Message sent successfully to " + emailList.get(i));
            }
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static ArrayList<String> readingEmails () throws Exception {

        //Enter Path of file where emails are
        CleaningTex cleaningTex = new CleaningTex("C:\\...\\...\\...\\emails.txt", "C:\\...\\...\\...\\newtextfile.txt");
        ArrayList<String> lista = new ArrayList<>();
        try {
            File myObj = new File(cleaningTex.cleaningText());
            Scanner myReader = new Scanner(myObj);
            lista.add(myReader.nextLine());
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                data.split(" ");
                lista.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lista;
    }


}


