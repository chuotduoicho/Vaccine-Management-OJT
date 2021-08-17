package fa.appcode.common.valueobjects;

public class VaccineVo {
	
	private String vaccineId;
	
	private String vaccineName;
	
	private int numberOfInjection;
	
	private String origin;
	
	private boolean status;
	
	private String vaccineTypeName;

	public VaccineVo(String vaccineId, String vaccineName, int numberOfInjection, String origin, boolean status, String vaccineTypeName) {
		super();
		this.vaccineId = vaccineId;
		this.vaccineName = vaccineName;
		this.numberOfInjection = numberOfInjection;
		this.origin = origin;
		this.status = status;
		this.vaccineTypeName = vaccineTypeName;
	}

	public VaccineVo() {
		super();
	}

	public String getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public int getNumberOfInjection() {
		return numberOfInjection;
	}

	public void setNumberOfInjection(int numberOfInjection) {
		this.numberOfInjection = numberOfInjection;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getVaccineTypeName() {
		return vaccineTypeName;
	}

	public void setVaccineTypeName(String vaccineTypeName) {
		this.vaccineTypeName = vaccineTypeName;
	}
	
	
}
