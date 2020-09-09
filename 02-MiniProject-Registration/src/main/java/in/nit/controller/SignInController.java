package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.nit.dto.User;
import in.nit.dto.SignIn;
import in.nit.service.UserService;

@Controller
public class SignInController {
	private static final Logger logger=LoggerFactory.getLogger(SignInController.class);	

	@Autowired
	private UserService uService;
	@GetMapping(value = { "/", "/home" })
	public String homePage(Model model) {
		SignIn userSign = new SignIn();
		model.addAttribute("userSignIn", userSign);
		return "HomePage";
	}
	
	@PostMapping("/userHomePage")
	public String SignInButton(@ModelAttribute("userSignIn") SignIn SignIn, RedirectAttributes attributes) {
		
		User user = uService.getUserDtlsByUserEmailAndUserPwd(SignIn.getEmail(), SignIn.getPazzword());
		 System.out.println(user);
		try {
			if (user!= null) {
				String accStatus = user.getAccStatus();
				logger.info("My AcctStatus Method is started");
				System.out.println(accStatus);
				
				
				if("UN-LOCKED".equalsIgnoreCase(accStatus)) {
					logger.debug("My AccStatus Unlocked Method is started");
					return "dashboar-page";
				}
				else if("LOCKED".equalsIgnoreCase(accStatus)) {
					logger.info("My Status Locked Method is started");
					attributes.addFlashAttribute("errMsg", " Your Account is Locked,Unlock it First ");
					return "redirect:/home";
				}
			}
		} catch (Exception e) {
			logger.error("Eroor is there in this function"+e.getMessage());
		}
		attributes.addFlashAttribute("msg","Invalid Crdentials,Check your Passowrd");
		return "reditrect:/home";
	}}		