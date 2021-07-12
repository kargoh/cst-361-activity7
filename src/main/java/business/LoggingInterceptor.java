package business;

import java.io.Serializable;

@Named
@ViewScoped
@AroundInvoke 

public class LoggingInterceptor(Serializable a) {
	
	
}


public Object methodInterceptor(InvocationContext ctx) throws Exception 
{ 
System.out.println("******************* Intercepting call to method: " +  
ctx.getTarget().getClass() + "." + ctx.getMethod().getName() + "()"); 
return ctx.proceed(); 
} 
