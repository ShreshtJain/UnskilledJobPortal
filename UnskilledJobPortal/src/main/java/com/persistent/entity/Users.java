package com.persistent.entity;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Users")
public class Users {
	
	@Column(name = "USER_ID" , columnDefinition = "NUMBER", nullable = false)
    private int userId;
	
	
	@NotBlank(message="Aadhar No. is required.")
	@Size(min=12,message="At most 12 number can be allowed.")
	@Id
	@Column(name = "AADHAR_NO" , columnDefinition = "VARCHAR2 (12)")
	private String aadhar;	
	
	@Column(name="FIRST_NAME" , columnDefinition = "VARCHAR2 (30)")
	@NotBlank(message="First Name is required.")
	private String firstName;
	
	@Column(name="LAST_NAME" , columnDefinition = "VARCHAR2 (30)")
	@NotBlank(message="Last Name is required.")
	private String lastName;
	
	@Column(name="GENDER" , columnDefinition = "VARCHAR2 (1) CHECK (GENDER IN ('F','M'))")
	@NotBlank(message=" Gender is required.")
	@Size(min=1, max=5,message="eg. Male or Female")
	private String gender;
	
	@Column(name="PASSWORD" , columnDefinition = "VARCHAR2 (100)" , nullable = false)
	@NotBlank(message="Password is required.")
	private String password;
	
	@Column(name="CONTACT" , columnDefinition = "VARCHAR2 (10)" , nullable = false)
	@NotBlank(message="Mobile No. is required.")
	@Size(min=10, max=10,message="must be of 10 digits")
	private String contact;
	
	@Column(name="ADDRESS" , columnDefinition = "VARCHAR2 (50)")
	@NotBlank(message="Address is required.")
	private String address;
	
	@Column(name="ROLES" , columnDefinition = "VARCHAR2(15)  DEFAULT 'ROLE_USER'")
	private String roles;

	public Users() {
		super();
	}

	public Users(int userId,  String aadhar, String firstName, String lastName, String gender, String password,
			String contact, String address, String roles) {
		super();
		this.userId = userId;
		this.aadhar = aadhar;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.password = password;
		this.contact = contact;
		this.address = address;
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", aadhar=" + aadhar + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", password=" + password + ", contact=" + contact
				+ ", address=" + address + ", roles=" + roles + "]";
	}
	
	
}
