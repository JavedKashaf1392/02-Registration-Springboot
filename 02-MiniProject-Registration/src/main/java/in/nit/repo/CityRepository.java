package in.nit.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.EntityCity;

public interface CityRepository extends JpaRepository<EntityCity,Integer>{

	List<EntityCity> findAllByStateId(Integer stateId);

	/*List<EntityCity> findAllByStateId(Integer stateId);*/

}
