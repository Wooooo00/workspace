package edu.kh.project.email.model.service;

import java.util.Map;

/** 이메일 발송
 * @param htmlName
 * @param email
 * @return result
 * 
 */
public interface EmailService {

	int sendEmail(String htmlName, String email);

	int checkAuthKey(Map<String, Object> paramMap);

}
