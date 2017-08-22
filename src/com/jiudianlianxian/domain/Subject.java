package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Subject
 * @Description: 学科表
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午3:48:39
 *
 */
public class Subject {
	
	
	private Integer subject_id;
	private String subject_sid;
	private String subject_name;
	
	private Set<Grade> subject_setGrades = new HashSet<Grade>() ;
	
	private Set<Versions> subject_setVersionss = new HashSet<Versions>();

}
