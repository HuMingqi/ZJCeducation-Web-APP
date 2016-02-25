package zjc.edu.pojo;

public class ParentsAppTable extends Parents_info{
	private String childName;
	private String childGender;	
	private String subject;
	private String grade;
	private String teacherGender;
	private String request;
	private String teach_time;
	private String apply_date;
	private String state;
	private Integer count;
	
	public ParentsAppTable(){
		super();		
	}
			
	public String getChildName() {
		return childName;
	}
	public String getChildGender() {
		return childGender;
	}
	public String getTeacherGender() {
		return teacherGender;
	}
	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}
	public void setChildGender(String childGender) {
		this.childGender = childGender;
	}
	public void setChildName(String childName) {
		this.childName = childName;
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
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
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
