package com.poly.validator;

import org.apache.commons.validator.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.poly.entity.Student3;

@Component
public class StudentValidator implements Validator{
	private EmailValidator emailValidator = EmailValidator.getInstance();
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == Student3.class;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		Student3 entity = (Student3) target;
		if(entity.getMarks() <= 0) {
			errors.rejectValue("marks", "Min.student.marks");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotBlank.student.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotBlank.student.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marks", "NotNull.student.marks");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotNull.student.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "faculty", "NotBlank.student.faculty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hobbies", "NotEmpty.student.hobbies");
		
		if(!errors.hasFieldErrors("email")) {
			if(!this.emailValidator.isValid(entity.getEmail())) {
				errors.rejectValue("email", "Email.student.email");
			}
		}
		if(!errors.hasFieldErrors("marks")) {
			if(entity.getMarks() < 0) {
				errors.rejectValue("marks", "Min.student.marks");
			}
			if(entity.getMarks() > 10) {
				errors.rejectValue("marks", "Max.student.marks");
			}
		}
	}
}
