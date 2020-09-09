package in.nit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nit.dto.User;
import in.nit.model.EntityUser;
import in.nit.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		User u= new User();
		model.addAttribute("user",u);
		Map<Integer,String> countryMap=uService.getAllCountries();
		model.addAttribute("countryMap", countryMap);
		return "AccountRegSucces";
	}
	
	
	@PostMapping(value= "/userRegSave")
	public String handleSubmitBtn(@ModelAttribute("user") User u,Model model) {
		boolean isSaved = uService.SaveUser(u);
		if(isSaved) {
			model.addAttribute("succMsg","Contact Saved");
		}else {
			model.addAttribute("errMsg", "Failed to Save Contact");
		}
		return "AccountRegSucces";
		
	}
	
	@RequestMapping("/getStates")
	@ResponseBody
	public Map<Integer,String> getCititesById(@RequestParam("cid")Integer countryId){
		return uService.getStatesByCountryId(countryId);
		
	}
		
	
	@RequestMapping("/getCities")
	@ResponseBody
	public Map<Integer,String> getCitiesByStateId(@RequestParam("sid") Integer stateId) {
		return uService.getCitiesByStateId(stateId);
	}
	 
	
	@RequestMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("email") String email) {
		String emailStatus=uService.findByEmail(email);
		return emailStatus;
	}
}
