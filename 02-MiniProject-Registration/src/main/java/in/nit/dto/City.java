package in.nit.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class City implements Serializable{
	private Integer cityId;
	private String cityName;
	private Integer stateId;
	
	

}
