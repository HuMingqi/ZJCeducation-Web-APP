package zjc.edu.interceptors;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor{
	private String number;  
	
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("using method checkLogin");
		System.out.println("key is "+number); 
		
        Map<String, Object> session = invocation.getInvocationContext().getSession();       //读取Session             
        if (session.containsKey(number)){ 
        	System.out.println("您已登录");
            return invocation.invoke();  //执行下一个拦截器或Action的被拦截方法           
        }else{  
        	System.out.println("未登录，请先登录");
        	if(number.equals("managerName")){
        		return "managerLogin";
        	}else{
        		return "login";
        	}
        }           	
	}	
		
	public void setNumber(String number) {	//由struts.xml 拦截器参数 传入
		this.number = number;
	}

}
