package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Versions
 * @Description: 版本表
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午3:49:12
 *
 */
public class Versions {
	
	private Integer versions_id;
	private String versions_sid;
	private String versions_name;
	
	private Set<Subject> versions_setSubjects = new HashSet<Subject>() ;

}
