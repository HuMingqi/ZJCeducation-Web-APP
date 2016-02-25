package zjc.edu.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import zjc.edu.pojo.*;
import zjc.edu.service.ParentsService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ParentsAction extends ActionSupport{
	private Parents_info parentsInfo;
	private Parents_apply parentsApply;
	private ParentsService parentsService;	
	private Integer parentsNumber;
	private String teach_time1,teach_time2;
	
	public String getTeach_time1() {
		return teach_time1;
	}

	public void setTeach_time1(String teach_time1) {
		this.teach_time1 = teach_time1;
	}
	
	public String getTeach_time2() {
		return teach_time2;
	}

	public void setTeach_time2(String teach_time2) {
		this.teach_time2 = teach_time2;
	}

	public Parents_info getParentsInfo() {
		return parentsInfo;
	}

	public void setParentsInfo(Parents_info parentsInfo) {
		this.parentsInfo = parentsInfo;
	}

	public Parents_apply getParentsApply() {
		return parentsApply;
	}

	public void setParentsApply(Parents_apply parentsApply) {
		this.parentsApply = parentsApply;
	}

	public ParentsService getParentsService() {
		return parentsService;
	}

	public void setParentsService(ParentsService parentsService) {
		this.parentsService = parentsService;
	}
	
	public Integer getParentsNumber() {
		return parentsNumber;
	}

	public void setParentsNumber(Integer parentsNumber) {
		this.parentsNumber = parentsNumber;
	}

	public String register() throws Exception{
		System.out.println("using method parents register.");
		System.out.println(parentsInfo.getEmail());
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");
		String sd=sdft.format(new Date());
		parentsInfo.setRegister_date(sd);                  	//注册日期
		parentsNumber=parentsService.addRecord(parentsInfo);
		if(parentsNumber==-1){
			return "error";
		}else{
			System.out.println("parents injected，number is "+parentsNumber);
			/*Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("teacherNumber",teacher_number.toString());	*/
			return "success";
		}
	}
	public String login() throws Exception{
		System.out.println("using method parents login.");
		String sql="select number from parents_info where number="+parentsInfo.getNumber()+" and password='"+parentsInfo.getPassword()+"'";
		if(parentsService.checkExist(sql)){			
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("parentsNumber",parentsInfo.getNumber());
			System.out.println(session.containsKey("parentsNumber"));				
			System.out.println("parents Login succeed");
			return SUCCESS;
		}else{
			return "fail";
		}
	}
	
	public String logout() throws Exception{
		System.out.println("using method logout");
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("parentsNumber");
		System.out.println("Logout succeed");
		return "success";
							
	}
	
	public String submitApplication() throws Exception{
		System.out.println("using method submitApp");
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		parentsNumber=(Integer) session.get("parentsNumber");
		parentsInfo.setNumber(parentsNumber);
		parentsApply.setNumber(parentsNumber);
		
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");
		String sd=sdft.format(new Date());
		parentsApply.setApply_date(sd);     		
		
		System.out.println("parentsApply.number:"+parentsApply.getNumber());
		
		parentsApply.getSubject().replace(" ","");	
		System.out.println("parentsApply.subject:"+parentsApply.getSubject());
				
		/*String time1=ServletActionContext.getRequest().getParameter("teacher_time1"); 没办法的事，非逼着用自动装配，否则就抛异常
		String time2=ServletActionContext.getRequest().getParameter("teacher_time2");	*/
		parentsApply.setTeach_time(teach_time1+"—"+teach_time2);
		System.out.println(parentsApply.getTeach_time());
		parentsApply.setState(false);
		
		/*parentsInfo.setBirth_date(birth_date);		
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");
		String datestr=sdft.format(parentsInfo.getBirth_date());*/
		String sql="update parents_info set name='"+parentsInfo.getName()+"',gender='"+parentsInfo.getGender()+"',address='"+parentsInfo.getAddress()+"',phone='"+parentsInfo.getPhone()+"',email='"+parentsInfo.getEmail()+"',qq='"+parentsInfo.getQq()+"' where number="+parentsInfo.getNumber();		
		if(parentsService.addApply(parentsApply)==1&&parentsService.editPersonalInfo(sql)){
			System.out.println("submit teacher_application succeed");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String editPersonalData() throws Exception{
		System.out.println("use method edit");
		Map<String,Object> session=ActionContext.getContext().getSession();
		Integer number=(Integer)session.get("parentsNumber");
		if(number==null)	return ERROR;// login
		String sql="update parents_info set nickname='"+parentsInfo.getNickname()+"',gender='"+parentsInfo.getGender()+"',address='"+parentsInfo.getAddress()+"',phone='"+parentsInfo.getPhone()+"',email='"+parentsInfo.getEmail()+"',qq='"+parentsInfo.getQq()+"' where number="+number;
		if(parentsService.editPersonalInfo(sql)){		//update方法应该这样update(sql)
			System.out.println("编辑家长信息成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String modifyPassword() throws Exception{
		System.out.println("use method modifyPassword");
		Map<String,Object> session=ActionContext.getContext().getSession();
		Integer number=(Integer)session.get("parentsNumber");
		if(number==null)	return ERROR;// login
		String sql="update parents_info set password='"+parentsInfo.getPassword()+"' where number="+number;
		if(parentsService.editPersonalInfo(sql)){		//update方法应该这样update(sql)
			System.out.println("修改密码成功");
			session.remove("parentsNumber");
			return "relogin";
		}else{
			return ERROR;
		}
	}

	public String execute() throws Exception{
		System.out.println("use method parents execute");
		Map<String,Object> session=ActionContext.getContext().getSession();
		parentsNumber=(Integer) session.get("parentsNumber");
		try{
			String sql="select number,nickname,name,id_number,gender,address,phone,email,qq,password,register_date from parents_info where number="+parentsNumber;		//完全没问题的sql语句被报语法错误，重写一遍好了！。。。	另外 不支持select *!!!得到结果为空
			parentsInfo=parentsService.getPersonalInfo(sql);
			System.out.println(parentsInfo.getNickname());
			}catch(Exception ex){
				System.out.println(ex);
			}
		return "execute";
	}	
}
