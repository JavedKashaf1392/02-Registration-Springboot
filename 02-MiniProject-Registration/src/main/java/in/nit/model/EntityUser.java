package in.nit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Entity
@Data
@Table(name="User_table")
public class EntityUser implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="userId")
	private Integer userId;
	
	@Column(name="ACC_STATUS")
	private String accStatus;
	
	@Column(name="USER_PWD")
	private String userPwd;
	
	@Column(name="CITY_ID")
	private String cityId;
	
	@Column(name="COUNTRY_ID")
	private String countryId;
	@Column(name="STATE_ID")
	private String stateId;
	
    @Column(name="lname")
	private String firstName;
    @Column(name="fname")
	private String lastName;
    
    @Column(name="email",unique = true)
	private String userEmail;
    @Column(name="phon")
	private long phonNumber;
    @Column(name="dob")
	private Date DateOfBirth;
    
    @Column(name="gender")
    private String Gender;
    
    @CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
    
    @UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updatedDate;

}
