package zjc.edu.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import zjc.edu.pojo.MyDate;
import zjc.edu.pojo.Manager;
import zjc.edu.pojo.ParentsAppTable;
import zjc.edu.pojo.Parents_info;
import zjc.edu.pojo.TeacherAppTable;
import zjc.edu.pojo.Teacher_info;
import zjc.edu.service.ManagerService;
import zjc.edu.service.ParentsService;
import zjc.edu.service.Teacher_applyService;
import zjc.edu.service.Teacher_infoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.crypto.provider.RSACipher;


public class ManagerAction extends ActionSupport{	
	private Manager manager;
	private Integer number;
	private String phone;
	private Teacher_info teacher_info; 
	private Parents_info parents_info;
	private ManagerService managerService;
	private Teacher_infoService teacher_infoService;
	private Teacher_applyService teacher_applyService;
	private ParentsService parentsService;
	private List<TeacherAppTable> RS;					//storage teacher_apply or parents_apply,指明底层类型，传参数保持类型一致，单纯一个list无法访问元素属性
	private List<ParentsAppTable> PRS;
	private MyDate d1,d2;
	private String state;
	private Integer count;	
	
	public Teacher_info getTeacher_info() {
		return teacher_info;
	}

	public void setTeacher_info(Teacher_info teacher_info) {
		this.teacher_info = teacher_info;
	}

	public Parents_info getParents_info() {
		return parents_info;
	}

	public void setParents_info(Parents_info parents_info) {
		this.parents_info = parents_info;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone= phone;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}	

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	public Teacher_applyService getTeacher_applyService() {
		return teacher_applyService;
	}

	public void setTeacher_applyService(Teacher_applyService teacher_applyService) {
		this.teacher_applyService = teacher_applyService;
	}

	public Teacher_infoService getTeacher_infoService() {
		return teacher_infoService;
	}

	public void setTeacher_infoService(Teacher_infoService teacher_infoService) {
		this.teacher_infoService = teacher_infoService;
	}

	public ParentsService getParentsService() {
		return parentsService;
	}

	public void setParentsService(ParentsService parentsService) {
		this.parentsService = parentsService;
	}

	public MyDate getD1() {
		return d1;
	}

	public void setD1(MyDate d1) {
		this.d1 = d1;
	}

	public MyDate getD2() {
		return d2;
	}

	public void setD2(MyDate d2) {
		this.d2 = d2;
	}

	public List<TeacherAppTable> getRS() {
		return RS;
	}

	public void setRS(List<TeacherAppTable> rs) {
		this.RS = rs;
	}

	public List<ParentsAppTable> getPRS() {
		return PRS;
	}

	public void setPRS(List<ParentsAppTable> pRS) {
		PRS = pRS;
	}

	public String login() throws Exception{
		System.out.println("using method login");
		if(managerService.findManager(manager)){
			Map<String,Object> session=ActionContext.getContext().getSession();
			session.put("managerName",manager.getName());
			System.out.println("Login succeed");
			return "success";
		}else{
			return "fail";
		}
	}
	
	public String logout() throws Exception{
		System.out.println("using method logout");
		
		Map<String,Object> session=ActionContext.getContext().getSession();
		session.remove("managerName");
		System.out.println("Logout succeed");
		return "success";
							
	}
	
	public String readTodayTApp() throws Exception{
		System.out.println("using method readTodayTApp");
		Date date=new Date();
		RS=teacher_applyService.readRange(date, date);		
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readWeekTApp() throws Exception{
		System.out.println("using method readWeekTApp");		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -6); 		//六天前
		RS=teacher_applyService.readRange(cal.getTime(),new Date());
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readCurMonthTApp() throws Exception{
		System.out.println("using method readCurMonthTApp");		
		Calendar cal=Calendar.getInstance();	
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		Date d1=cal.getTime();	
		cal.add(Calendar.MONTH,1);//下月一号
		cal.add(Calendar.DATE, -1);//本月末
		Date d2=cal.getTime();		
		RS=teacher_applyService.readRange(d1, d2);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readAllTApp() throws Exception{
		System.out.println("using method readAllTApp");
		Calendar cal=Calendar.getInstance();
		cal.set(2000, 0, 1);			//月份起始0
		Date d1=cal.getTime();
		cal.set(2050, 0, 1);
		Date d2=cal.getTime();
		RS=teacher_applyService.readRange(d1, d2);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readRange() throws Exception{
		System.out.println("using method readRange");
		Calendar cal=Calendar.getInstance();
		cal.set(d1.getYear(), d1.getMonth(), d1.getDay());
		Date d1=cal.getTime();
		cal.set(d2.getYear(), d2.getMonth(), d2.getDay());
		Date d2=cal.getTime();
		RS=teacher_applyService.readRange(d1, d2);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryundoneTApply() throws Exception{
		System.out.println("using method queryundoneTapply");
		String sql="select * from teacher_info natural join (select * from teacher_apply where state=false) applyalias;";
		RS=teacher_applyService.queryTBy(sql);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String querydoneTApply() throws Exception{
		System.out.println("using method querydoneTapply");
		String sql="select * from teacher_info natural join (select * from teacher_apply where state=true) applyalias;";
		RS=teacher_applyService.queryTBy(sql);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryTByNumber() throws Exception{
		System.out.println("use method querybyNumber");
		String sql="select * from teacher_info natural join (select * from teacher_apply where number="+number+") applyalias;";
		RS=teacher_applyService.queryTBy(sql);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryTByPhone() throws Exception{
		System.out.println("use method queryByphone.phone is "+phone);
		String sql="teacher_info natural join teacher_apply on teacher_info.phone='"+phone+"'";//报告语法错误 (select * from teacher_info where phone='xxx') info natural join teacher_apply;同样报语法错误 
		RS=teacher_applyService.queryTBy(sql);
		if(RS==null){
			System.out.println("rs is null");
			return ERROR;
		}else if(RS.isEmpty()){
			System.out.println("rs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryTInfoByNumber() throws Exception{
		System.out.println("use method queryTInfobyNumber");
		teacher_info=new Teacher_info();
		teacher_info.setNumber(number);
		List li=teacher_infoService.queryTeacher_info(teacher_info);		
		if(li.isEmpty()){
			return "none";
		}else{
			teacher_info=(Teacher_info)li.get(0);
			return "success";
		}		
	}
	
	public String queryTInfoByPhone() throws Exception{
		System.out.println("use method queryTInfobyPhone");
		String hql="from Teacher_info tinfo where tinfo.phone='"+phone+"'";
		List li=teacher_infoService.query(hql);		
		if(li.isEmpty()){
			return "none";
		}else{
			teacher_info=(Teacher_info)li.get(0);
			return "success";
		}		
	}
	
	public String setTAppState() throws Exception{
		System.out.println("use method setTAppState");
		System.out.println("count="+count+",state="+state);
		String sql="update teacher_apply set state="+state+" where count="+count;
		if(teacher_applyService.setState(sql)){
			System.out.println("set state success");
			return "success";
		}else{
			System.out.println("set state failed");
			return "fail";
		}
	}
	
	/////////////////////////////////////////////////////////
	
	public String readTodayPApp() throws Exception{
		System.out.println("using method readTodayPApp");
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");		
		String sd1,sd2;
		sd1=sd2=sdft.format(new Date());
		String sql="select * from parents_info natural join (select * from parents_apply where '"+sd1+"'<= apply_date and apply_date<='"+sd2+"') applyalias;";
		PRS=parentsService.queryPBy(sql);		
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("prs exist!");			
			return SUCCESS;
		}
	}
	
	public String readWeekPApp() throws Exception{
		System.out.println("using method readWeekPApp");		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -6); 		//六天前
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");		
		String sd1,sd2;
		sd1=sdft.format(cal.getTime());
		sd2=sdft.format(new Date());
		String sql="select * from parents_info natural join (select * from parents_apply where '"+sd1+"'<= apply_date and apply_date<='"+sd2+"') applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readCurMonthPApp() throws Exception{
		System.out.println("using method readCurMonthPApp");
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");		
		String sd1,sd2;				
		
		Calendar cal=Calendar.getInstance();	
		cal.set(Calendar.DAY_OF_MONTH, 1); 
		sd1=sdft.format(cal.getTime());	
		cal.add(Calendar.MONTH,1);//下月一号
		cal.add(Calendar.DATE, -1);//本月末
		sd2=sdft.format(cal.getTime());
		
		String sql="select * from parents_info natural join (select * from parents_apply where '"+sd1+"'<= apply_date and apply_date<='"+sd2+"') applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String readAllPApp() throws Exception{
		System.out.println("using method readAllPApp");
		SimpleDateFormat sdft=new SimpleDateFormat("yyyy/MM/dd");		
		String sd1,sd2;				
		Calendar cal=Calendar.getInstance();
		cal.set(2000, 0, 1);			//月份起始0
		sd1=sdft.format(cal.getTime());
		cal.set(2050, 0, 1);
		sd2=sdft.format(cal.getTime());
		
		String sql="select * from parents_info natural join (select * from parents_apply where '"+sd1+"'<= apply_date and apply_date<='"+sd2+"') applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryundonePApply() throws Exception{
		System.out.println("using method queryundonePapply");
		String sql="select * from parents_info natural join (select * from parents_apply where state=false) applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String querydonePApply() throws Exception{
		System.out.println("using method querydonePApply");
		String sql="select * from parents_info natural join (select * from parents_apply where state=true) applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryPByNumber() throws Exception{
		System.out.println("use method queryPbyNumber");
		String sql="select * from parents_info natural join (select * from parents_apply where number="+number+") applyalias;";
		PRS=parentsService.queryPBy(sql);
		if(PRS==null){
			System.out.println("prs is null");
			return ERROR;
		}else if(PRS.isEmpty()){
			System.out.println("prs is none");
			return "none";
		}else{
			System.out.println("rs exist!");			
			return SUCCESS;
		}
	}
	
	public String queryPInfoByNumber() throws Exception{
		System.out.println("use method queryPInfobyNumber");
		String sql="select number,nickname,name,id_number,gender,address,phone,email,qq,password,register_date from parents_info where number="+number;		//完全没问题的sql语句被报语法错误，重写一遍好了！。。。	另外 不支持select *!!!得到结果为空
		parents_info=parentsService.getPersonalInfo(sql);
		if(parents_info==null) return "none";
		else return "success";		
	}
	
	public String queryPInfoByPhone() throws Exception{
		System.out.println("use method queryPInfobyPhone");
		String sql="select number,nickname,name,id_number,gender,address,phone,email,qq,password,register_date from parents_info where phone='"+phone+"'";
		parents_info=parentsService.getPersonalInfo(sql);
		if(parents_info==null) return "none";//null is empty in there
		else return "success";		
	}
	
	public String setPAppState() throws Exception{
		System.out.println("use method setPAppState");
		System.out.println("number="+number+",state="+state);
		String sql="update parents_apply set state="+state+" where count="+count;
		if(parentsService.setApplyState(sql)){
			System.out.println("set state success");
			return "success";
		}else{
			System.out.println("set state failed");
			return "fail";
		}
	}
	
	public String execute() throws Exception{
		System.out.println("use method manager execute");
		return "execute";		
	}
}
