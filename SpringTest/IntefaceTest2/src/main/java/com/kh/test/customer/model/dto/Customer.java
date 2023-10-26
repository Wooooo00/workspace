package com.kh.test.customer.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Customer {
	
	private int customerNo;

	private String customerName;

	private String customerTel;

	private String customerAddress;
	
}
