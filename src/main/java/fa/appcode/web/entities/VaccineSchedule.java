package fa.appcode.web.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INJECTION_SCHEDULE", schema = "VACCINE")
public class VaccineSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INJECTION_SCHEDULE_ID", columnDefinition = "INT")
	private int id;

	@ManyToOne
	@JoinColumn(columnDefinition = "VACCINE_ID", referencedColumnName = "VACCINE_ID")
	private Vaccine vaccine;

	@Column(name = "TIME_BEGIN", columnDefinition = "DATE")
	private LocalDate timeBegin;

	@Column(name = "TIME_END", columnDefinition = "DATE")
	private LocalDate timeEnd;

	@Column(name = "PLACE", columnDefinition = "NVARCHAR(200)")
	private String place;

	@Column(name = "NOTE", columnDefinition = "TEXT")
	private String note;

	public VaccineSchedule() {
	}

	public VaccineSchedule(int id, Vaccine vaccine, LocalDate timeBegin, LocalDate timeEnd, String place,
			String note) {
		this.id = id;
		this.vaccine = vaccine;
		this.timeBegin = timeBegin;
		this.timeEnd = timeEnd;
		this.place = place;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return id + "\t" + vaccine + "\t" + timeBegin + "\t" + timeEnd + "\t" + place + "\t" + note;
	}

	public String getDateFrom() {
		String formattedDate = this.timeBegin.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return formattedDate;
	}
	public String getDateTo() {
		String formattedDate = this.timeEnd.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return formattedDate;
	}
}
