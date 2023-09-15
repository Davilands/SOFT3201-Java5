package poly.com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import poly.com.entity.Company;
import poly.com.service.CookieService;
import poly.com.service.SessionService;
import poly.com.service.UploadService;

@Controller
public class DIController {
	@Autowired
	@Qualifier("bean1")
	Company company;
	@Autowired
	UploadService uService;

	@Autowired
	CookieService cService;
	@Autowired
	SessionService sService;

	@RequestMapping("getcompany")
	public String getCompany(Model m) {
		m.addAttribute("com", company);
	sService.setAttribute("com",company);
		return "company";
	}

	@GetMapping("/upload")
	public String index(Model m) {
		Company com = sService.getAttribute("com");
		m.addAttribute("com", com);
		cService.create("ctest", "1", 1);
		return "upload";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("fileUpload") MultipartFile file, Model m) {
		try {
			Cookie c = cService.get("ctest");
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			uService.save(file, "/upload" + sdf.format(new Date()));
			m.addAttribute("message", "Upload thành công!");
		} catch (RuntimeException re) {
			m.addAttribute("message", re.getMessage());
		}
		return "upload";
	}
}
