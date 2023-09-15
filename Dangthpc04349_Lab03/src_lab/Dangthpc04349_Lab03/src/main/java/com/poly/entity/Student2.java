package com.poly.entity;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student2 {
	@NotBlank(message = "Vui lòng nhập họ và tên")
	private String name;
	
	@NotBlank(message = "Vui lòng nhập địa chỉ email")
	@Email(message = "Vui lòng nhập đúng định dạng email")
	private String email;
	
	@Min(value = 1, message = "Điểm phải lớn hơn hoặc bằng 0")
	@Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
	@NotNull(message = "Vui lòng nhập điểm")
	private double marks;
	
	@NotNull(message = "Vui lòng chọn giới tính")
	private boolean gender;
	
	@NotBlank(message = "Vui lòng chọn khoa")
	private String faculty;
	
	@NotEmpty(message = "Vui lòng chọn sở thích")
	List<String> hobbies;
			
}
