package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Subject
 * @Description: ѧ�Ʊ�
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����3:48:39
 *
 */
public class Subject {
	
	
	private Integer subject_id;
	private String subject_sid;
	private String subject_name;
	
	private Set<Grade> subject_setGrades = new HashSet<Grade>() ;
	
	private Set<Versions> subject_setVersionss = new HashSet<Versions>();

}
