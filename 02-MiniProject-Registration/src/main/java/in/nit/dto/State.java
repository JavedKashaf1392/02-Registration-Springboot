package in.nit.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class State implements Serializable{
	private Integer stateId;
	private Integer countryId;
	private String stateName;

}
