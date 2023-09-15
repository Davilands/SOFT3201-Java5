package poly.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;

	@GetMapping("/home/test")
	public String homeTest() {
		request.setAttribute("message", "Thông điệp gửi qua View");
		return "home/test";
	}
}
