package com.poly.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student3 {
	private String name;
	private String email;
	private double marks;
	private boolean gender;
	private String faculty;
	
	private List<String> hobbies;
}
