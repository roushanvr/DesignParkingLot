package com.ParkingLot.models;

import com.ParkingLot.models.enums.PaymentMode;
import com.ParkingLot.models.enums.PaymentStatus;

public class Payment extends BaseModel{
    private int amount;
    private Bill bill;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }
}
