package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;



/**
 * 
 * @Title: StudyStage
 * @Description: ѧ�α�
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����3:47:07
 *
 */
public class StudyStage {
	
	
	private Integer studyStage_id;
	private String studyStage_sid;
	private String studyStage_name;
	
	private Set<Grade> studyStage_setGrades = new HashSet<Grade>();
	
	
	

}
