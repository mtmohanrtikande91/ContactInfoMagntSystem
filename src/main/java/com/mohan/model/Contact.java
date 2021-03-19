package com.mohan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="contact_info")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contactId;
	
	@Column(name="firstName",nullable = false,length = 33)
	private String firstName;
	
	@Column(name="lastName",nullable = false,length = 33)
	private String lastName;
	
	@Column(name="email",nullable = false,length = 256)
	private String email;
	
	@Column(name="mobNo",nullable = false,length = 13)
	private String mobNo;
	
	@Column(name="status",nullable = false,length = 10)
	private String status;
	
}
