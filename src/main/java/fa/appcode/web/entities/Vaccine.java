package fa.appcode.web.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VACCINE", schema = "VACCINE")
public class Vaccine {

	@Id
	@Column(name = "VACCINE_ID", columnDefinition = "VARCHAR(10)")
	private String id;

	@Column(name = "STATUS", columnDefinition = "BIT")
	private boolean status;

	@Column(name = "VACCINE_NAME", columnDefinition = "VARCHAR(50)")
	private String name;

	@ManyToOne
	@JoinColumn(columnDefinition = "VACCINE_TYPE_ID", referencedColumnName = "VACCINE_TYPE_ID")
	private VaccineType type;

	@Column(name = "NUMBER_OF_INJECTION", columnDefinition = "TINYINT")
	private int numberOfInject;

	@Column(name = "USAGE", columnDefinition = "TEXT")
	private String useage;

	@Column(name = "INDICATION", columnDefinition = "TEXT")
	private String indication;

	@Column(name = "CONTRAINDICATION", columnDefinition = "TEXT")
	private String contraindication;

	@Column(name = "TIME_BEGIN", columnDefinition = "DATE")
	private LocalDate timeBegin;

	@Column(name = "TIME_END", columnDefinition = "DATE")
	private LocalDate timeEnd;

	@Column(name = "ORIGIN", columnDefinition = "VARCHAR(50)")
	private String origin;

	public Vaccine() {
	}

	public Vaccine(String id, boolean status, String name, VaccineType type, int numberOfInject, String useage,
			String indication, String contraindication, LocalDate timeBegin, LocalDate timeEnd, String origin) {
		this.id = id;
		this.status = status;
		this.name = name;
		this.type = type;
		this.numberOfInject = numberOfInject;
		this.useage = useage;
		this.indication = indication;
		this.contraindication = contraindication;
		this.timeBegin = timeBegin;
		this.timeEnd = timeEnd;
		this.origin = origin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VaccineType getType() {
		return type;
	}

	public void setType(VaccineType type) {
		this.type = type;
	}

	public int getNumberOfInject() {
		return numberOfInject;
	}

	public void setNumberOfInject(int numberOfInject) {
		this.numberOfInject = numberOfInject;
	}

	public String getUseage() {
		return useage;
	}

	public void setUseage(String useage) {
		this.useage = useage;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getContraindication() {
		return contraindication;
	}

	public void setContraindication(String contraindication) {
		this.contraindication = contraindication;
	}

	public LocalDate getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(LocalDate timeBegin) {
		this.timeBegin = timeBegin;
	}

	public LocalDate getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDate timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return id + "\t" + status + "\t" + name + "\t" + type + "\t" + numberOfInject + "\t" + useage + "\t"
				+ indication + "\t" + contraindication + "\t" + timeBegin + "\t" + timeEnd + "\t" + origin;
	}

}
