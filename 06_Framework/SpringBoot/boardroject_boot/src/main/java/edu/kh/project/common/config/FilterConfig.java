package edu.kh.project.common.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kh.project.common.filter.AdminFilter;
import edu.kh.project.common.filter.LoginFilter;



@Configuration
public class FilterConfig {
	
	@Bean
	public FilterRegistrationBean<LoginFilter> loginFilter() {
		
		// FilterRegistrationBean : 필터 등록 빈
		
		FilterRegistrationBean<LoginFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new LoginFilter()); // 사용할 필터 객체 추가
		
		String[] filteringUrl = {"/myPage/*", "/editBoard/*"};
		
		// Arrays.asList(배열) : 배열 -> List로 변환
		
		filter.setUrlPatterns(Arrays.asList(filteringUrl)); // 필터링할 주소를 지정
		
		filter.setName("loginFilter"); // 필터 이름 지정
		
		filter.setOrder(1); // 필터 순서
		
		return filter;
		
	} 
	
	@Bean
	public FilterRegistrationBean<AdminFilter> adminFilter() {
		
		FilterRegistrationBean<AdminFilter> filter = new FilterRegistrationBean<>();
		
		filter.setFilter(new AdminFilter());
		
		List<String> filteringUrl = new ArrayList<>();
		
		filteringUrl.add("/admin/*");
		
		filter.setUrlPatterns(filteringUrl);
		
		filter.setName("adminFilter");
		
		filter.setOrder(2);
		
		return filter;
	}
	
	
	
	
	
	
}
