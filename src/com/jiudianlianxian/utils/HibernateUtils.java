package com.jiudianlianxian.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * 
 * Title: HibernateUtils
 * Description: hibernate工具类
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: hibernate_day01
 * @author fupengpeng
 * @date 2017年8月7日 下午3:11:17
 */
public class HibernateUtils {

	
	/**
	 * 用于生产SessionFactory对象
	 *     SessionFactory对象产生耗资源，故只生产一个SessionFactory对象
	 */
	private static final Configuration configuration;
	private static final SessionFactory sessionFactory;
	
	static {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	//提供方法返回与本地线程绑定的session对象的方法
	public static Session getSessionObject(){
		return sessionFactory.getCurrentSession();  
	}
	
	//提供方法返回SessionFactory对象
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		
	}
	
}
