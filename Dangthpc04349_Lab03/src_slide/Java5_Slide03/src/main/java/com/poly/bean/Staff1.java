package com.poly.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff1 {
	private String manv;
	private String tennv;
	private String position;
	private String hobbies[];
	private Country country;
}
