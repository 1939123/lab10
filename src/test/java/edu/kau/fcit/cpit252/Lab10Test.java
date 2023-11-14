package edu.kau.fcit.cpit252;

import edu.kau.fcit.cpit252.paymentsStrategy.CreditCardPayment;
import edu.kau.fcit.cpit252.paymentsStrategy.PayPalPayment;
import edu.kau.fcit.cpit252.paymentsStrategy.Payment;
import edu.kau.fcit.cpit252.receiptStrategy.EmailReceipt;
import edu.kau.fcit.cpit252.receiptStrategy.PdfReceipt;
import edu.kau.fcit.cpit252.receiptStrategy.PrintReceipt;
import edu.kau.fcit.cpit252.receiptStrategy.Receipt;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.*;


public class Lab10Test
{
    /**
     * There should an abstract class called Receipt
     * This abstract class should have methods called getId, getProducts, getIssueDate,
     * and an abstract method called generate. It should have an instance variable called recipient
     */

    @Test
    public void testReceiptAbstractClass() {
        assertTrue(Modifier.isAbstract(Receipt.class.getModifiers()));
        assertEquals(4, Receipt.class.getDeclaredMethods().length);
        Method[] methods = Receipt.class.getDeclaredMethods();
        int abstractMethodCount = 0;
        for (Method m : methods) {
            if (Modifier.isAbstract(m.getModifiers())) {
                abstractMethodCount++;
                assertEquals("generate", m.getName());
            }
        }
        assertEquals(1, abstractMethodCount);
    }

    @Test
    public void testPaymentInterface() {
        assertTrue(Modifier.isInterface(Payment.class.getModifiers()));
        assertEquals(1, Payment.class.getDeclaredMethods().length);
        Method method = Payment.class.getDeclaredMethods()[0];
        assertEquals("pay", method.getName());
        assertEquals(1, method.getParameterCount());
        assertEquals(double.class.getTypeName(), method.getParameterTypes()[0].getName());
    }

    @Test
    public void testCreditCardPayment() {
        Class<?>[] interfaces = CreditCardPayment.class.getInterfaces();
        assertEquals(1, interfaces.length);
        assertTrue(interfaces[0].equals(Payment.class));
    }

    @Test
    public void testPayPalPayment() {
        Class<?>[] interfaces = PayPalPayment.class.getInterfaces();
        assertEquals(1, interfaces.length);
        assertTrue(interfaces[0].equals(Payment.class));
    }


    @Test
    public void testEmailReceipt() {
        Class superClass = EmailReceipt.class.getSuperclass();
        assertEquals(Receipt.class, superClass);
    }

    @Test
    public void testPdfReceipt() {
        Class superClass = PdfReceipt.class.getSuperclass();
        assertEquals(Receipt.class, superClass);
    }

    @Test
    public void testPrintReceipt() {
        Class superClass = PrintReceipt.class.getSuperclass();
        assertEquals(Receipt.class, superClass);
    }
}
