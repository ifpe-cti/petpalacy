/*
MIT License

Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package br.edu.ifpe.petpalacy.util;

import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
public class JavaMail {

    private static JavaMail instance;

    public static JavaMail getInstance() {
        if (instance == null) {
            instance = new JavaMail();
        }
        return instance;
    }

    public void enviarEmail(Agendamento agende, int n) {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("petpalacy@gmail.com", "2018palacy");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("petpalacy@gmail.com")); //Remetente

            if (n == 1) {
                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(agende.getServico().getEmpresa().getEmail());

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Solicitação de Agendamento");//Assunto
                message.setText("O clinte " + agende.getCliente().getNome() + " solicitou o agendamento"
                        + " do serviço " + agende.getServico().getNome() + " para a data " + agende.getData()
                        + " e hora " + agende.getHora() + "!!!");
            }
            if (n == 2) {
                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(agende.getCliente().getEmail());

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Resposta a Pedido de Agendamento");//Assunto
                message.setText("A sua solicitação de Agendamento foi " + agende.getStatusAgen() + "!!!");
            }

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
