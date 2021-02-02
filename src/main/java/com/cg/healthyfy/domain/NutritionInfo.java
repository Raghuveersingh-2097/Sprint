package com.cg.healthyfy.domain;

import java.time.LocalTime;

import javax.persistence.*;

import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NutritionInfo {
	@Id
	private int id;
	private String  name;
	private String plandescription;
	private LocalTime created_at;
	private int price;

	@Override
	public String toString() {
		return "NutritionInfo [id=" + id + ", name=" + name + ", plandescription=" + plandescription + ", created_at="
				+ created_at + ", price=" + price + "]";
	}
}
