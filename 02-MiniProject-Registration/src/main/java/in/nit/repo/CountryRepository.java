package in.nit.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.EntityCountry;

public interface CountryRepository extends JpaRepository<EntityCountry,Integer>{

}
