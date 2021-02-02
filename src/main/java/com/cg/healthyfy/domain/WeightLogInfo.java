package com.cg.healthyfy.domain;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeightLogInfo {
@Id
	private int id;
	private double Weight;
	private LocalDate created_At;
	private LocalDate Updated_At;
	private LocalTime createTime;
	private LocalTime updateTime;
}
