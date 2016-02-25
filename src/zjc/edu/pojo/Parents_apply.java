package zjc.edu.pojo;

public class Parents_apply {
	private Integer number;
	//private String name;
	private String child_name;
	private String child_gender;
	private String child_grade;
	private String subject;	
	private String teacher_gender;
	private String request;
	private String teach_time;
	private String apply_date;
	private boolean state;
	private Integer count;
	
	public Parents_apply(){}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}

	public String getChild_grade() {
		return child_grade;
	}

	public void setChild_grade(String child_grade) {
		this.child_grade = child_grade;
	}

	public String getChild_gender() {
		return child_gender;
	}

	public void setChild_gender(String child_gender) {
		this.child_gender = child_gender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher_gender() {
		return teacher_gender;
	}

	public void setTeacher_gender(String teacher_gender) {
		this.teacher_gender = teacher_gender;
	}	

	public String getTeach_time() {
		return teach_time;
	}

	public void setTeach_time(String teach_time) {
		this.teach_time = teach_time;
	}

	public String getApply_date() {
		return apply_date;
	}

	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
