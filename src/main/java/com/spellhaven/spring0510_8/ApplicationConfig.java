package com.spellhaven.spring0510_8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig {

	// 왜 @Value들을 자꾸 달아야 하냐? private String adminId = "tiger" 라고 여기 쓰여 있는 게 아니라서 바로 세터에 못 넣는다.
	// 세터에 무슨 값을 넣어야 할지... 이건 "외부 properties를 가져와야 하는 거죠".
	@Value("${admin.Id}")
	private String adminId;
	@Value("${admin.Pw}")
	private String adminPw;
	@Value("${sub_admin.Id}")
	private String sub_adminId;
	@Value("${sub_admin.Pw}")
	private String sub_adminPw;
	
	
	@Bean // PropertySourcesPlaceholderConfigurer 이름 뭐임; 🤮
		  // 참고로 이 함수는 꼭 Properties()라고 대문자로 시작해야 한다. 그냥 자바에선 이런 static 함수가 있다고 딱 정해져 있대...
	public static PropertySourcesPlaceholderConfigurer Properties() { 
		
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();	
		
		Resource[] locations = new Resource[2];
		
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		
		configurer.setLocations(locations);
				
		return configurer;
	}
	
	
	@Bean
	public AdminConnection adminconfig() {	
		
		AdminConnection adminconnection = new AdminConnection();
		
		adminconnection.setAdminId(adminId);	
		adminconnection.setAdminPw(adminPw);	
		adminconnection.setSub_adminId(sub_adminId);	
		adminconnection.setSub_adminPw(sub_adminPw);	
		
		return adminconnection;
	}
	
}
