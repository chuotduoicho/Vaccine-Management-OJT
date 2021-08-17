package fa.appcode.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VACCINE_TYPE", schema = "VACCINE")
public class VaccineType {

	@Id
	@Column(name = "VACCINE_TYPE_ID", columnDefinition = "VARCHAR(50)")
	private String id;

	@Column(name = "VACCINE_TYPE_NAME", columnDefinition = "VARCHAR(50)")
	private String name;

	@Column(name = "ACTIVE", columnDefinition = "BIT")
	private boolean status;

	@Column(name = "[DESCRIPTION]", columnDefinition = "TEXT")
	private String description;

	@Column(name = "[IMAGE]", columnDefinition = "VARBINARY(MAX)")
	private byte[] urlImage;
	
	private String base64imageFile;

	public VaccineType() {
	}

	public VaccineType(String name, boolean status, String description, byte[] urlImage) {
		this.name = name;
		this.status = status;
		this.description = description;
		this.urlImage = urlImage;
	}
	
	public VaccineType(String id, String name, boolean status, String description, byte[] urlImage) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
		this.urlImage = urlImage;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getUrlImage() {
//		return urlImage;
//	}
//
//	public void setUrlImage(String urlImage) {
//		this.urlImage = urlImage;
//	}
	
	public byte[] getUrlImage() {
		return urlImage;
	}

	public String getBase64imageFile() {
		return base64imageFile;
	}

	public void setBase64imageFile(String base64imageFile) {
		this.base64imageFile = base64imageFile;
	}

	public void setUrlImage(byte[] urlImage) {
		this.urlImage = urlImage;
	}
	

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + status + "\t" + description + "\t" + urlImage;
	}

	

}
