package zjc.edu.interceptors;

import java.util.Map;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor{
	private String number;  
	
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("using method checkLogin");
		System.out.println("key is "+number); 
		
        Map<String, Object> session = invocation.getInvocationContext().getSession();       //��ȡSession             
        if (session.containsKey(number)){ 
        	System.out.println("���ѵ�¼");
            return invocation.invoke();  //ִ����һ����������Action�ı����ط���           
        }else{  
        	System.out.println("δ��¼�����ȵ�¼");
        	if(number.equals("managerName")){
        		return "managerLogin";
        	}else{
        		return "login";
        	}
        }           	
	}	
		
	public void setNumber(String number) {	//��struts.xml ���������� ����
		this.number = number;
	}

}
