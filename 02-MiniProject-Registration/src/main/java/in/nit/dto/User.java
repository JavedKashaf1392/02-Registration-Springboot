package in.nit.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
@Data
public class User implements Serializable{
	private Integer userId;
	private String accStatus;
	private String userPwd;
	private String cityId;
	private String countryId;
	private String stateId;
    private String firstName;
	private String lastName;
	private String userEmail;
    private long phonNumber;
	private Date DateOfBirth;
	private String Gender;
	private Date createdDate;
	private Date updatedDate;

}
