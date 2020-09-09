package in.nit.service;

import java.util.Map;

import in.nit.dto.User;
import in.nit.model.EntityUser;
public interface UserService {
	boolean SaveUser(User u);
	public Map<Integer,String> getAllCountries();

	/*public Map<Integer,String> getStatusByCountryId(Integer countryId);*/
	/*Map<Integer, String> getStatesByCountryId(Integer countryId);*/
	Map<Integer, String> getStatesByCountryId(Integer countryId);
	Map<Integer, String> getCitiesByStateId(Integer stateId);
	public String findByEmail(String email);
	public User getUserByTempPassword(String tempPwd,String email);
	boolean UpdateUser(User u);
	//home UserSignIn
	 public User getUserDtlsByUserEmailAndUserPwd(String userEmail,String userPwd);
	 public User getUserByUserEmail(String userEmail);
	

}
