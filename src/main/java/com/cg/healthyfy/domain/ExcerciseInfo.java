package com.cg.healthyfy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcerciseInfo {
@Id
private int exceriseId;
private String excerciseType;
private String plan;
}
