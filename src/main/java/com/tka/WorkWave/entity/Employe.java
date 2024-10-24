package com.tka.WorkWave.entity;

import java.util.Date;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String mobileno;
	private String emailid;
	private String gender;
	private double salary;
	private String department;
	private String status;

	private String createdby;
	private Date ceratedDate;
	private String updatedby;
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Country country;


}
