package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	public LogInterceptador() {
		
	}
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();
		Object o = context.proceed();
		System.out.println("[LOG] " + context.getTarget().getClass().getSimpleName() + "." 
				+ context.getMethod().getName() + " -> tempo gasto: " +
				(System.currentTimeMillis() - millis) + "ms");
		
		return o;
	}
}
