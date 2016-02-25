package zjc.edu.pojo;

import java.util.Date;

public class Teacher_apply {
	private int count;
	private int number;
	private String subject;
	private String grade;
	private String teach_time;
	private String self_introduction;
	private Date apply_date;
	private boolean state;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Teacher_apply(){
		// TODO Auto-generated constructor stub
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTeach_time() {
		return teach_time;
	}
	public void setTeach_time(String teach_time) {
		this.teach_time = teach_time;
	}
	public String getSelf_introduction() {
		return self_introduction;
	}
	public void setSelf_introduction(String self_introduction) {
		this.self_introduction = self_introduction;
	}
	public Date getApply_date() {
		return apply_date;
	}
	public void setApply_date(Date apply_date) {
		this.apply_date = apply_date;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
		
}
