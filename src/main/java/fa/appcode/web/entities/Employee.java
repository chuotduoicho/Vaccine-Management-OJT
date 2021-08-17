package fa.appcode.web.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE", schema = "VACCINE")
public class Employee {
	
	@Id
	@Column(name = "EMPLOYEE_ID", columnDefinition = "VARCHAR(12)")
	private String id;
	
	@Column(name = "EMPLOYEE_NAME", columnDefinition = "NVARCHAR(100)")
	private String name;
	
	@Column(name = "GENDER", columnDefinition = "BIT")
	private boolean gender;
	
	@Column(name = "DATE_OF_BIRTH", columnDefinition = "DATE")
	private LocalDate dob;
	
	@Column(name = "PHONE", columnDefinition = "VARCHAR(50)")
	private String phone;
	
	@Column(name = "[ADDRESS]", columnDefinition = "NVARCHAR(100)")
	private String address;
	
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(100)")
	private String email;
	
	@Column(name = "WORKING_PLACE", columnDefinition = "NVARCHAR(100)")
	private String workingPlace;
	
	@Column(name = "POSITION", columnDefinition = "NVARCHAR(50)")
	private String position;
	
	@Column(name = "[IMAGE]", columnDefinition = "VARBINARY(MAX)")
	private byte [] image;
	
	private String base64imageFile;

	@Column(name = "USERNAME", columnDefinition = "VARCHAR(50)")
	private String username;
	
	@Column(name = "[PASSWORD]", columnDefinition = "VARCHAR(50)")
	private String password;
	
	public Employee() {
	}

	public Employee(String id, String name, boolean gender, LocalDate dob, String phone, String address, String email,
			String workingPlace, String position, byte [] image) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.workingPlace = workingPlace;
		this.position = position;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWorkingPlace() {
		return workingPlace;
	}

	public void setWorkingPlace(String workingPlace) {
		this.workingPlace = workingPlace;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public byte [] getImage() {
		return image;
	}

	public void setImage(byte [] image) {
		this.image = image;
	}

	public String getBase64imageFile() {
		return base64imageFile;
	}

	public void setBase64imageFile(String base64imageFile) {
		this.base64imageFile = base64imageFile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + gender + "\t" + dob + "\t" + phone + "\t" + address + "\t" + email + "\t"
				+ workingPlace + "\t" + position + "\t" + image + "\t" + username + "\t" + password;
	}

}
