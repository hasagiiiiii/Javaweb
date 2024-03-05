package Entity;
// Generated Mar 5, 2024, 10:59:42 PM by Hibernate Tools 5.6.15.Final

import java.util.Date;

/**
 * Timekeeper generated by hbm2java
 */
public class Timekeeper implements java.io.Serializable {

	private String timekeeperId;
	private Employee employee;
	private Date dateTime;
	private char inOut;

	public Timekeeper() {
	}

	public Timekeeper(String timekeeperId, Employee employee, Date dateTime, char inOut) {
		this.timekeeperId = timekeeperId;
		this.employee = employee;
		this.dateTime = dateTime;
		this.inOut = inOut;
	}

	public String getTimekeeperId() {
		return this.timekeeperId;
	}

	public void setTimekeeperId(String timekeeperId) {
		this.timekeeperId = timekeeperId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public char getInOut() {
		return this.inOut;
	}

	public void setInOut(char inOut) {
		this.inOut = inOut;
	}

}