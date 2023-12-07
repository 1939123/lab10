package edu.kau.fcit.cpit252.receiptStrategy;

import edu.kau.fcit.cpit252.shopping.Product;
import edu.kau.fcit.cpit252.utils.EmailTemplate;
import edu.kau.fcit.cpit252.utils.SendEmail;
import java.util.List;

public class EmailReceipt extends Receipt{
    private String subject;
    private String recipient;

    public EmailReceipt(String subject, String recipient, List<Product> products) {
        super(products);
        this.subject = subject;
        this.recipient = recipient;
    }


    @Override
    public void generate() {
        EmailTemplate template = new EmailTemplate();

        String message =  template.getEmailTemplate("Our Neighborhood Bakery", this.getId(), this.getIssueDate(),
                this.getProducts());
        try {
            SendEmail.send(this.subject, message, this.recipient);
        }
        catch(Exception e){
            System.err.println("Failed to email the receipt: Reason: " + e.getMessage());
        }

    }
}
