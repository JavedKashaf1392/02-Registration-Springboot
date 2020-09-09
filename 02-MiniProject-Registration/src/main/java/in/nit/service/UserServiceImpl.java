package in.nit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import in.nit.dto.Country;
import in.nit.dto.User;
import in.nit.dto.SignIn;
import in.nit.model.EntityCity;
import in.nit.model.EntityCountry;
import in.nit.model.EntityState;
import in.nit.model.EntityUser;
import in.nit.repo.CityRepository;
import in.nit.repo.CountryRepository;
import in.nit.repo.EmailRepository;
import in.nit.repo.StateRepository;
import in.nit.repo.UserRepository;
import in.nit.util.AppConstants;
import in.nit.util.EmailUtils;
import in.nit.util.PazzwordUtil;
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	private static final Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private EmailRepository emlRepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private CityRepository ctyRepo;
	
	@Autowired
	private CountryRepository ctrRepo;
	
	@Autowired
	private StateRepository staRepo;
	
	@Autowired
	private EmailUtils emlUtils;
	
	@Override
	public boolean SaveUser(User u) {
		u.setUserPwd(PazzwordUtil.generateTempPws(AppConstants.TEMP_PAZZWORD_TEMP));
		u.setAccStatus(AppConstants.LOCKED_STR);
		EntityUser user=new EntityUser();
		BeanUtils.copyProperties(u, user);
		EntityUser savedEntity=urepo.save(user);
		if(savedEntity.getUserId()!=null){
			return emlUtils.sendUserAccUnlockEmail(u);
		}
		return false;
		}
	


	@Override
	public Map<Integer, String> getAllCountries() {
		Map<Integer,String> map=new LinkedHashMap<Integer,String>();
		List<EntityCountry> countriesList=ctrRepo.findAll();
		countriesList.forEach(Country->{
			map.put(Country.getCountryId(),Country.getCountryName());
		}
		);
		return map;
	}


	@Override
	public Map<Integer,String> getStatesByCountryId(Integer countryId) {
		Map<Integer,String> statesMap=new LinkedHashMap<>();
		List<EntityState> states=staRepo.findAllByCountryId(countryId);
		states.forEach(state->{
			statesMap.put(state.getStateId(),state.getStateName());
		});
		return statesMap;
	
	}

	/*@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		Map<Integer,String> citiesMap=new LinkedHashMap<>();
		List<EntityCity> entitiesList=ctyRepo.findAllByStateId(stateId);
		entitiesList.forEach(entity->{
			citiesMap.put(entity.getCityId(),entity.getCityName());
		});
		return citiesMap;
	}*/
	
	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		Map<Integer, String> citiesMap = new LinkedHashMap<>();
		List<EntityCity> entitiesList = ctyRepo.findAllByStateId(stateId);
		entitiesList.forEach(entity -> {
			citiesMap.put(entity.getCityId(), entity.getCityName());
		});
		return citiesMap;
	}


	@Override
	public String findByEmail(String email) {
	     EntityUser user=emlRepo.findByUserEmail(email);
		if(null!=user) {
			return "Duplicate";
		}
		return "Unique";
	}



	@Override
	public User getUserByTempPassword(String tempPwd,String email) {
		EntityUser entity=urepo.findByUserPwdAndUserEmail(tempPwd,email);
		User acct=null;
		if(entity!=null) {
			acct=new User();
			BeanUtils.copyProperties(entity, acct);
			
		}
		return acct;
	}

	@Override
	public boolean UpdateUser(User u) {
		EntityUser entity=new EntityUser();
		BeanUtils.copyProperties(u, entity);
		EntityUser savedEntity=urepo.save(entity);
		return savedEntity!=null;
	}



	@Override
	public User getUserDtlsByUserEmailAndUserPwd(String userEmail, String userPwd) {
		logger.info("this is the starting of Signin Service");
		EntityUser entity=urepo.findByUserEmailAndUserPwd(userEmail,userPwd);
		User acct=null;
		if(entity != null) {
			logger.debug("method startted and will execute");
			acct=new User();
			BeanUtils.copyProperties(entity, acct);
			System.out.println(acct);
			logger.info("this SignIn Service method is executed successerully!!");
		}
		return acct;
	}



	@Override
	public User getUserByUserEmail(String userEmail) {
		logger.debug("Forgot Passowrd Method is started");
		EntityUser entity=urepo.findByUserEmail(userEmail);
		User acc=null;
		if(entity!=null) {
			acc=new User();
			BeanUtils.copyProperties(entity, acc);
			logger.info("Forgot Password method is executed Successefully");
		}
		return acc;
	}
}
