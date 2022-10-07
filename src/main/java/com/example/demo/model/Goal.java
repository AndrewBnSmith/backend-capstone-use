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
	@Column(name = "fromDate")
	private String fromDate;
	@Column(name = "toDate")
	private String toDate;

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

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
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