package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "goals")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "goalTotal")
	private double goalTotal;
	@Column(name = "contribute")
	private double contribute;
	@Column(name = "years")
	private String years;
	@Column(name = "image")
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getGoalTotal() {
		return goalTotal;
	}

	public void setGoalTotal(double goalTotal) {
		this.goalTotal = goalTotal;
	}

	public double getContribute() {
		return contribute;
	}

	public void setContribute(double contribute) {
		this.contribute = contribute;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}