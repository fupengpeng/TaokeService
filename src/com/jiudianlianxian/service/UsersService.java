package com.jiudianlianxian.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.domain.User;
import com.jiudianlianxian.entity.data.GetUserInfoByUidData;
import com.jiudianlianxian.entity.data.LoginData;
import com.jiudianlianxian.entity.result.GetUserInfoByUidResult;
import com.jiudianlianxian.entity.result.LoginResult;
import com.jiudianlianxian.util.SqlHelper;
import com.jiudianlianxian.utils.HibernateUtils;

/**
 * 
 * Title: UsersService
 * Description: 给此类一个描述
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: ShoppingMall
 * @author fupengpeng
 * @date 2017年7月27日 下午3:06:00
 *
 */
public class UsersService {
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	
	

	 
	/**
	 * 
	 * Description: 根据用户uid查询用户信息
	 * @param user
	 * @return
	 */
	public GetUserInfoByUidResult getUserInfoByUid (String user_uid){
		GetUserInfoByUidResult getUserInfoByUidResult = new GetUserInfoByUidResult();
		GetUserInfoByUidData getUserInfoByUidData = new GetUserInfoByUidData();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where user_uid=?");
			query.setParameter(0, user_uid);
			List<User> list = query.list();
			if (list.size() != 0) {
				for (User user : list) {
					getUserInfoByUidResult.setCode(SUCCESS);
					getUserInfoByUidResult.setInfo("查询成功");
					//1、使用JSONObject
			        String jsonUser = JSONObject.toJSONString(user);
			        System.out.println("jsonUser  = " + jsonUser);
					getUserInfoByUidData.setJsonUser(jsonUser);
				}
			}else {
				getUserInfoByUidResult.setCode(ERROR);
				getUserInfoByUidResult.setInfo("该用户不存在，请重新输入用户uid！");
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		getUserInfoByUidResult.setGetUserInfoByUidResult(getUserInfoByUidResult);
		return getUserInfoByUidResult;
	}
	
	/**
	 * 
	 * Description: 登录
	 * @param user
	 * @return
	 */
	public LoginResult login (User user){
		LoginResult loginResult = new LoginResult();
		LoginData loginData = new LoginData();
		loginResult.setLoginData(loginData);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from User where user_phonenumber=?");
			query.setParameter(0, user.getUser_phonenumber());
			List<User> list = query.list();
			if (list.size() != 0) {
				for (User user2 : list) {
					if (user2.getUser_password().equals(user.getUser_password())) {
						loginResult.setInfo(user2.getUser_uid());
						loginResult.setCode(SUCCESS);
					}else {
						loginResult.setCode(ERROR);
						loginResult.setInfo("密码错误，请重新输入！");
					}
				}
			}else {
				loginResult.setCode(ERROR);
				loginResult.setInfo("该用户不存在，请重新输入或者前往注册界面注册！");
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		return loginResult;
	}
	
	
	/**
	 * 
	 * Description: 注册
	 * @param user
	 * @return
	 */
	public boolean register (User user){
		boolean b = true;
		String sql = "INSERT INTO t_user (user_phonenumber, user_password) VALUES ("+user.getUser_phonenumber()+", "+user.getUser_password()+");";
		System.out.println("sql====" + sql);
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
		
	}
	
	/**
	 * 
	 * Description: 根据给定的phonenumber查询数据库数据
	 * @param phonenumber
	 * @return
	 */
	public boolean getVerificationCode (String user_phonenumber){
		boolean b = true;
		String sql = "select * from t_user where user_phonenumber='"+user_phonenumber+"'";
		System.out.println("sql = "+sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				System.out.println(rs.getString(5));
				
				if (rs.getString(5) != null) {
					b = false;
					System.out.println("获取到查询数据库的值");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("001");
			e.printStackTrace();
		}finally{
			System.out.println("002");
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		System.out.println("b = " + b);
		return b;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Description: 根据给定的sex查询数据库数据
	 * @param uid
	 * @return
	 */
	public ArrayList<User>  getUserBySex (String sex){
		ArrayList<User> users = new ArrayList<User>();
		
		String sql = "select * from t_user where sex='"+sex+"'";
		System.out.println("sql = "+sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				User user = new User();
				user.setUser_uid(rs.getString(2));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		
		return users;
		
	}
	
	/**
	 * 
	 * Description: 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		boolean b = true;
		String sql = "INSERT INTO t_user("
				+ "id,uid,username,sex,phonenumber,"
				+ "location,detailedaddress,postcode,birthday,wechat,"
				+ "growthvalue,account,password,integral,isdefaultaddress) "
				+ "VALUES("
				+ ","+user.getUser_uid();
		

		System.out.println("mysql = " + sql);
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * 
	 * Description: 修改用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		boolean b = true;
		String sql = "UPDATE t_user SET "
				+ "WHERE uid='"+user.getUser_uid()+"';";
		try {
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		
		
		return b;
	}
	
	/**
	 * 
	 * Description: 根据给定的uid查询数据库数据
	 * @param uid
	 * @return
	 */
	public User getUserByUid (String uid){
		
		User user = new User();
		String sql = "select * from t_user where uid='"+uid+"'";
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// 查询数据库,获取上述uid对应的数据
			while (rs.next()) {
				
				user.setUser_uid(rs.getString(2));

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		
		return user;
		
	}

	/**
	 * 
	 * Description: 根据给定的uid刪除用戶
	 * @param uid
	 * @return
	 */
	public boolean delUser(String uid){
		boolean b = true;
		String sql = "delete from t_user where uid = '"+uid+"'";
		
		try {
			System.out.println("uid---"+uid);
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		
		return b;
	}
	/**
	 * 
	 * Description: 获取pageCount
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize) {
		int rowCount = 0;
		ResultSet rs = null;
		String sql = "SELECT * from t_user";

		try {
			rs = SqlHelper.executeQuery(sql);

			// 查询数据库,计算数据共有多少页
			while (rs.next()) {
				rowCount = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		return (rowCount - 1) / pageSize + 1;

	}

	/**     
	 * @return 
	 * Description:  按照分页来获取用户
	 * @param pageNow  当前页
	 * @param pageSize  当前页显示的数据数
	 * @return  用户数据对象集合
	 */
	public ArrayList<User> getUsersByPage(int pageNow, int pageSize) {
		ArrayList<User> al = new ArrayList<User>();

		String sql = "SELECT * from t_user WHERE id<=" + pageSize * pageNow
				+ " and id>=" + (pageSize * (pageNow - 1) + 1) + "; ";

		ResultSet rs = SqlHelper.executeQuery(sql);
		// 二次封装，将ResultSet---->User对象---->ArrayList集合
		try {
			while (rs.next()) {
				User user = new User();
				user.setUser_uid(rs.getString(2));

				al.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}

		return al;
	}




}
