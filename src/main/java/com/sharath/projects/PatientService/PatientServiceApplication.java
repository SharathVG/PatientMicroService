package com.sharath.projects.PatientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class PatientServiceApplication {
	
	@Autowired
	private ConfigClientAppConfiguration properties;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	@Value("${service.instance.name}")	
	private String serviceName;
	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String myMethod() {
		return "My Patient service "+ serviceName;
	}
	@RequestMapping("/properties")
	public String myProperties() {
		StringBuilder sb = new StringBuilder();
		return sb.append(properties.getProperty()).append(" || ").append(someOtherProperty).toString();
		
	}
	

	
	@RequestMapping("/employees")
	public Map<String, String> getEmployee() {
		List<String> strList = new ArrayList<String>();
		strList.add("one");
		strList.add("two");
		strList.add("three");	
		Map<String, String> mapValue = new HashMap<String, String>();
		mapValue.put("1", "one");
		mapValue.put("2", "two");
		mapValue.put("3", "three");
		return mapValue;
	}
	
	
	
	
}
