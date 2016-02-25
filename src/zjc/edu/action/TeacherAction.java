package zjc.edu.action;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import zjc.edu.pojo.Teacher_apply;
import zjc.edu.pojo.Teacher_info;
import zjc.edu.service.Teacher_applyService;
import zjc.edu.service.Teacher_infoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport; 

public class TeacherAction extends ActionSupport{
	private Teacher_info teacher_info;								//自动装配表单数据
	private Teacher_apply teacher_apply;
	private Integer teacher_number=-1;
	private Teacher_infoService teacher_infoService;
	private Teacher_applyService teacher_applyService;
	private String teach_time1=null,teach_time2=null,birth_date=null;
	public Integer getTeacher_number() {
		return teacher_number;
	}
	public void setTeacher_number(Integer teacher_number) {
		this.teacher_number = teacher_number;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getTeach_time2() {
		return teach_time2;
	}
	public void setTeach_time2(String teach_time2) {
		this.teach_time2 = teach_time2;
	}
	public Teacher_info getTeacher_info() {
		return teacher_info;
	}
	public void setTeacher_info(Teacher_info teacher_info) {
		this.teacher_info = teacher_info;
	}
	public String getTeach_time1() {
		return teach_time1;
	}
	public void setTeach_time1(String teach_time1) {
		this.teach_time1 = teach_time1;
	}
	public Teacher_apply getTeacher_apply() {
		return teacher_apply;
	}
	public void setTeacher_apply(Teacher_apply teacher_apply) {
		this.teacher_apply = teacher_apply;
	}
	public Teacher_infoService getTeacher_infoService() {
		return teacher_infoService;
	}
	public void setTeacher_infoService(Teacher_infoService teacher_infoService) {
		this.teacher_infoService = teacher_infoService;
	}
	public Teacher_applyService getTeacher_applyService() {
		return teacher_applyService;
	}
	public void setTeacher_applyService(Teacher_applyService teacher_applyService) {
		this.teacher_applyService = teacher_applyService;
	}
	
	public String register() throws Exception{
		System.out.println("using method register.");
		System.out.println(teacher_info.getEmail());
		teacher_info.setRegister_date(new Date());                  	//注册日期
		teacher_number=teacher_infoService.insertTeacher_info(teacher_info);
		if(teacher_number==-1){
			return ERROR;
		}else{
			System.out.println("teacher injected，number is "+teacher_number);
			/*Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("teacherNumber",teacher_number.toString());	*/
			return SUCCESS;
		}
	}
	public String login() throws Exception{
		System.out.println("using method login.");
		if(teacher_infoService.findTeacher_info(teacher_info)){			
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("teacherNumber",teacher_info.getNumber());
			System.out.println(session.containsKey("teacherNumber"));
			try{
			List tinfo=teacher_infoService.queryTeacher_info(teacher_info);
			teacher_info=(Teacher_info)tinfo.get(0);				//its enough!!	
			System.out.println(teacher_info.getNickname());
			}catch(Exception ex){
				System.out.println(ex);
			}
			
			System.out.println("Login succeed");
			return SUCCESS;
		}else{
			return "fail";
		}
	}
	
	public String logout() throws Exception{
		System.out.println("using method logout");
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("teacherNubmer");
		System.out.println("Logout succeed");
		return "success";
							
	}
	
	public String submitApplication() throws Exception{
		System.out.println("using method submitApp");
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		teacher_number=(Integer) session.get("teacherNumber");
		teacher_info.setNumber(teacher_number);
		teacher_apply.setNumber(teacher_number);
		
		teacher_apply.setApply_date(new Date());		//系统当前时间,使用hibernate save方法，会自动转换Date类型
		System.out.println("teacher_apply.number:"+teacher_apply.getNumber());
		
		teacher_apply.getSubject().replace(" ","");	
		System.out.println("teacher_apply.subject:"+teacher_apply.getSubject());
				
		/*String time1=ServletActionContext.getRequest().getParameter("teacher_time1"); 没办法的事，非逼着用自动装配，否则就抛异常
		String time2=ServletActionContext.getRequest().getParameter("teacher_time2");	*/
		teacher_apply.setTeach_time(teach_time1+"—"+teach_time2);
		System.out.println(teacher_apply.getTeach_time());
		
		/*teacher_info.setBirth_date(birth_date);
		
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");
		String datestr=sdft.format(teacher_info.getBirth_date());		*/
		String hql="update Teacher_info set name='"+teacher_info.getName()+"',gender='"+teacher_info.getGender()+"',birth_date='"+birth_date+"',id_number='"+teacher_info.getId_number()+"',school='"+teacher_info.getSchool()+"',background='"+teacher_info.getBackground()+"',major='"+teacher_info.getMajor()+"',address='"+teacher_info.getAddress()+"',identity='"+teacher_info.getIdentity()+"',phone='"+teacher_info.getPhone()+"',email='"+teacher_info.getEmail()+"',qq='"+teacher_info.getQq()+"' where number="+teacher_info.getNumber();
		
		if(teacher_applyService.insertTeacher_apply(teacher_apply)&&teacher_infoService.updateTeacher_info(hql)){
			System.out.println("submit teacher_application succeed");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String editPersonalData() throws Exception{
		System.out.println("use method edit");
		Map<String,Object> session=ActionContext.getContext().getSession();
		Integer number=(Integer)session.get("teacherNumber");
		if(number==null)	return ERROR;// login
		String hql="update Teacher_info set nickname='"+teacher_info.getNickname()+"',gender='"+teacher_info.getGender()+"',birth_date='"+birth_date+"',identity='"+teacher_info.getIdentity()+"',school='"+teacher_info.getSchool()+"',major='"+teacher_info.getMajor()+"',background='"+teacher_info.getBackground()+"',address='"+teacher_info.getAddress()+"',phone='"+teacher_info.getPhone()+"',email='"+teacher_info.getEmail()+"',qq='"+teacher_info.getQq()+"' where number="+number;
		if(teacher_infoService.updateTeacher_info(hql)){		//update方法应该这样update(sql)
			System.out.println("编辑个人信息成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String modifyPassword() throws Exception{
		System.out.println("use method modifyPassword");
		Map<String,Object> session=ActionContext.getContext().getSession();
		Integer number=(Integer)session.get("teacherNumber");
		if(number==null)	return ERROR;// login
		String hql="update Teacher_info set password='"+teacher_info.getPassword()+"' where number="+number;
		if(teacher_infoService.updateTeacher_info(hql)){		//update方法应该这样update(sql)
			System.out.println("修改密码成功");
			session.remove("teacherNumber");
			return "relogin";
		}else{
			return ERROR;
		}
	}
		
	public String execute() throws Exception{	
		System.out.println("using method execute");
		Map<String,Object> session=ActionContext.getContext().getSession();
		if(session.containsKey("teacherNumber")){
			teacher_info=new Teacher_info();			//avoid null pointer
			teacher_info.setNumber((Integer)session.get("teacherNumber"));
			try{
				List tinfo=teacher_infoService.queryTeacher_info(teacher_info);
				teacher_info=(Teacher_info)tinfo.get(0);				//its enough!!	
				System.out.println(teacher_info.getNickname());
				return "execute";
				}catch(Exception ex){
					System.out.println(ex);
					return ERROR;
				}
		}else{
			return "login";
		}		
	}
	
}
