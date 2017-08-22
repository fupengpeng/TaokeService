package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Grade
 * @Description: 年级
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午3:47:59
 *
 */
public class Grade {
	
	
	private Integer grade_id;
	private String grade_sid;
	private String grade_name;
	
	private StudyStage grade_studyStage ;
	
	private Set<Subject> grade_setGrades = new HashSet<Subject>();
	

}
