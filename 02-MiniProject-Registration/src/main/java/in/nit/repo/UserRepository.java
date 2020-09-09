package in.nit.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.EntityUser;

public interface UserRepository extends JpaRepository<EntityUser,Integer>{
	
	public EntityUser findByUserPwdAndUserEmail(String tempPwd,String email);
	
	 public EntityUser findByUserEmailAndUserPwd(String userEmail,String userPwd);
	 public EntityUser findByUserEmail(String userEmail);
	

}
