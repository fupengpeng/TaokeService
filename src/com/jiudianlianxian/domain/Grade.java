package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Grade
 * @Description: �꼶
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����3:47:59
 *
 */
public class Grade {
	
	
	private Integer grade_id;
	private String grade_sid;
	private String grade_name;
	
	private StudyStage grade_studyStage ;
	
	private Set<Subject> grade_setGrades = new HashSet<Subject>();
	

}
