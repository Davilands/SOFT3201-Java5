package poly.com.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Company {
	String name = "FPT Polytechnic - Class Company @Component";
	String logo = "fpt.png";
}