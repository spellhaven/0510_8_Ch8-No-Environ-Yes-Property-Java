package com.spellhaven.spring0510_8;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		// applicationCTX.xml 않 쓰고 ApplicationConfig.java 쓰려니까 어렵다;;
		// 하지만 외부 데이터를 크롤링해 올 경우에는 이래야 할 수도 있대. (공포)
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		AdminConnection connection = ctx.getBean("adminconfig", AdminConnection.class);
		
		System.out.println(connection.getAdminId());
		System.out.println(connection.getAdminPw());
		System.out.println(connection.getSub_adminId());
		System.out.println(connection.getSub_adminPw());
		
	}

}
