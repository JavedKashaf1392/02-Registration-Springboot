package in.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.dto.User;
import in.nit.model.EntityUser;

public interface EmailRepository extends JpaRepository<EntityUser, Integer>{
	public EntityUser findByUserEmail(String email);

}
