package in.nit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.dto.UnlockAccount;
import in.nit.dto.User;
import in.nit.model.EntityUser;
import in.nit.repo.UserRepository;
import in.nit.service.UserService;
import in.nit.util.AppConstants;

@Controller
public class AccountUnlockController {
	
	private static final Logger logger=LoggerFactory.getLogger(AccountUnlockController.class);
	
	@Autowired
	private  UserService uService;
	
	@RequestMapping("/unlockAcc")
	public String displayUnlockForm(@RequestParam("email")String email,Model model) {
		logger.debug("Unlock Load form method started");
		/*model.addAttribute("email", email);*/
		UnlockAccount unlockAcc=new UnlockAccount();
		unlockAcc.setEmail(email);
		model.addAttribute("unlockAcc",unlockAcc);
		logger.info("Unlock Load form method executed Successefully");
		return "unlockAccountForm";
	}
	@PostMapping("/unlockUserAcc")
	public String unLockUserAcc(@ModelAttribute("unlockAcc")UnlockAccount acc,Model model) {
		logger.debug(AppConstants.UNLOCK_ACCOUNT_CLASS_STARTED);
		
		try {
			User userAcct=uService.getUserByTempPassword(acc.getTempPwd(),acc.getEmail());
            if(userAcct!=null) {
         	   //update password and Acct Status $ Displyay Successe Message
         	   userAcct.setAccStatus("Un-Locked");
         	   userAcct.setUserPwd(acc.getNewPwd());
         	   boolean isUpdate=uService.UpdateUser(userAcct);
         	   if(isUpdate) {
         		   logger.info(AppConstants.UNLOCK_ACCOUNT_CLASS_STARTED);
         	   return "unlockAcctStatus";
            }
            }
			
		} catch (Exception e) {
			logger.error(AppConstants.UNLOCK_ACCOUNT_CLASS_ERROR+e.getMessage());
		}
                   //display error Message
            	   model.addAttribute("errMsg","Please enter Correct Temporary Password");
            	   logger.info(AppConstants.UNLOCK_ACCOUNT_CLASS_SUCCESSEFULLY);
		return "unlockAccountForm";	
	}
}
