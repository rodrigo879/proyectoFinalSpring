package edu.curso.java.spring.proyectospring.mvc;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		model.addAttribute(session);
		return "/index";
	}
}
