package in.nit.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable{
	private Integer countryId;
	private String countryCode;
	private String countryName;

}
