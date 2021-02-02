package com.cg.healthyfy.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

import  lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo {
	@Id
	private int id;
	private Double payment;
	private Double discount;
	private String planCategory;
	private double payableAmount;
}
