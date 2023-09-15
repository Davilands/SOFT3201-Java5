package com.poly.bean;

import java.util.List;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class staff3 {
	@NotBlank(message = "Phải nhập mã nhân viên")
	private String id;
	@NotBlank
	private String fullname;
	@NotNull(message = "Phải chọn giới tính")
	private Boolean gender;
	@NotBlank(message = "Phải nhập địa chỉ email")
	@Email
	private String email;
	@NotNull
	@DecimalMin(value = "9.5", message = "Lương tối thiểu là 9.5")
	private Double salary;
	@NotEmpty //()
	private String position;
	@NotEmpty(message = "Chọn ít nhất một sở thích")
	List<String> hobbies;

	@Override
	public String toString() {
		return "Staff3 [id=" + id + ",fullname=" + fullname + ",gender=" + gender + ",email=" + email + ",salary="
				+ salary + ",position=" + position + ",hobbies" + hobbies + "]";
	}
}