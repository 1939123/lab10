package edu.kau.fcit.cpit252.utils;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.SendEmailRequest;
import com.resend.services.emails.model.SendEmailResponse;


public class SendEmail {

    public static void send(String subject, String body, String recipient) throws MissingRequiredPropetiesException {
        final String email = System.getenv("email");
        final String apiKey = System.getenv("apiKey");
        System.out.println(apiKey);
        if (email == "" || apiKey == "") {
            throw new MissingRequiredPropetiesException("Missing email and/or apiKey. You need to store two" +
                    " environment variables named: \"email\" and \"apiKey\" for your email account." +
                    " Please refer to the following link for more information on how to set environment variables:" +
                    " https://cpit252.gitlab.io/miscellaneous/#environment-variables");
        }
        Resend resend = new Resend(apiKey);

        SendEmailRequest sendEmailRequest = SendEmailRequest.builder()
                .from(email)
                .to(recipient)
                .subject(subject)
                .html(body)
                .build();
        try {
            SendEmailResponse data = resend.emails().send(sendEmailRequest);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
