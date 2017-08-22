package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;



/**
 * 
 * @Title: StudyStage
 * @Description: 学段表
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午3:47:07
 *
 */
public class StudyStage {
	
	
	private Integer studyStage_id;
	private String studyStage_sid;
	private String studyStage_name;
	
	private Set<Grade> studyStage_setGrades = new HashSet<Grade>();
	
	
	

}
