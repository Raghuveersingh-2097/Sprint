package com.cg.healthyfy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DietPlanInfo {
@Id
 int id;
private String slots;
private String typeOfFood;
private double proteinRatio;
private double ratioOfFat;
private double ratioOfcarbs;
private double total;

}
