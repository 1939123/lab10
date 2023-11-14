package edu.kau.fcit.cpit252.receiptStrategy;

import edu.kau.fcit.cpit252.shopping.Product;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Receipt {
    private String id;
    private List<Product> products;
    private Date issueDate;

    public Receipt(List<Product> products) {
        this.id = UUID.randomUUID().toString();
        this.products = products;
        this.issueDate = new Date();
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void generate();
}
