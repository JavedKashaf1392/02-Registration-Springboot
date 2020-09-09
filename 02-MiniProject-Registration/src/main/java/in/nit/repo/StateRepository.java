package in.nit.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.EntityCity;
import in.nit.model.EntityCountry;
import in.nit.model.EntityState;

public interface StateRepository extends JpaRepository<EntityState,Integer>{

	List<EntityState> findAllByCountryId(Integer countryId);

}
