package org.biswajit.javaeight.ecommerceorderrevenuewithpartialrefunds;

public class Refund {
    private int refund;

    public Refund(int refund) {
        this.refund = refund;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "refund=" + refund +
                '}';
    }
}
