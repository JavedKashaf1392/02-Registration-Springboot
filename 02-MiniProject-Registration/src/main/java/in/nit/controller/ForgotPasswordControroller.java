package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.dto.ForgotPassword;
import in.nit.dto.User;
import in.nit.service.UserService;

@Controller
public class ForgotPasswordControroller {
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/forgotPageForm")
	public String LoadForgotPassword(Model model) {
		ForgotPassword forgot=new ForgotPassword();
		model.addAttribute("forgot",forgot);
		return "forgotPage";
	}
	
	@PostMapping("/userForgotPage")
	public String forgotButton(@ModelAttribute("forgot")ForgotPassword forgot,Model model ) {
		User user=uService.getUserByUserEmail(forgot.getEmail());
		
		return null;
		
	}

}
