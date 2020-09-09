package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="country")
public class EntityCountry {
	
	@Id
	@GeneratedValue
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;

}
