package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.domain.PaymentInfo;

public interface PaymentDAO {
public void addPayment(PaymentInfo pay, LoginInfo login);
public void updatePayment(PaymentInfo pay);
public void deletePayment(PaymentInfo pay);
public void findPaymentDetails(PaymentInfo pay);
}
