package com.cg.healthyfy.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaloriesLogInfo {
@Id
private int id;
private double caloriesLog;
private LocalDate created_At;
private LocalDate Updated_At;
private LocalTime createTime;
private LocalTime updateTime;
}


