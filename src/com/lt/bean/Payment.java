package com.lt.bean;

public class Payment {
	private String paymentId;
	private double amount;
	//type of payment details of debit card, online credit and check with enum 16 digit card number logic IMP
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
