package zjc.edu.pojo;

import java.util.Date;

public class TeacherAppTable extends Teacher_info{
	private String subject;
	private String grade;
	private String teach_time;
	private String self_introduction;
	private String apply_date;
	private String state;
	private Integer count;
			
	public TeacherAppTable(){
		super();		
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
	public String getApply_date() {
		return apply_date;
	}
	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
