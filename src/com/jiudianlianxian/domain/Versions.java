package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Versions
 * @Description: �汾��
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����3:49:12
 *
 */
public class Versions {
	
	private Integer versions_id;
	private String versions_sid;
	private String versions_name;
	
	private Set<Subject> versions_setSubjects = new HashSet<Subject>() ;

}
