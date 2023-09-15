package poly.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import poly.com.entity.Company;

@Configuration
public class BeanConfig {
	@Bean("bean1")
	@SessionScope
	public Company getCompany1() {
		Company com = new Company();
		com.setName("Công ty từ bean1");
		com.setLogo("ct1.png");
		return com;
	}
	@Bean("bean2")
	public Company getCompany2() {
		Company com =new Company();
		com.setName("Công ty từ bean2");
		com.setLogo("ct2.png");
		return com;
	}
}
