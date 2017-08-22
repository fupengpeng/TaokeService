package com.jiudianlianxian.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiudianlianxian.domain.Order;
import com.jiudianlianxian.domain.User;
import com.jiudianlianxian.entity.data.CreateOrderData;
import com.jiudianlianxian.entity.data.GetPayResultData;
import com.jiudianlianxian.entity.data.GetUserInfoByUidData;
import com.jiudianlianxian.entity.data.LoginData;
import com.jiudianlianxian.entity.data.UpdatePasswordData;
import com.jiudianlianxian.entity.data.UpdateUserInfoData;
import com.jiudianlianxian.entity.result.CreateOrderResult;
import com.jiudianlianxian.entity.result.GetPayResultResult;
import com.jiudianlianxian.entity.result.GetUserInfoByUidResult;
import com.jiudianlianxian.entity.result.LoginResult;
import com.jiudianlianxian.entity.result.UpdatePasswordResult;
import com.jiudianlianxian.entity.result.UpdateUserInfoResult;
import com.jiudianlianxian.util.SqlHelper;
import com.jiudianlianxian.utils.HibernateUtils;

/**
 * 
 * @Title: UsersService
 * @Description: ������һ������
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��19�� ����11:17:20
 *
 */
public class UsersService {
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	
	
	/**
	 * 
	 * @Description: ��ȡ����״̬
	 * @param order_oid
	 * @return
	 */
	public GetPayResultResult getPayResult (String order_oid){
		GetPayResultResult getPayResultResult = new GetPayResultResult();
		GetPayResultData getPayResultData = new GetPayResultData();
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			System.out.println("order_oid  == " + order_oid);
			
			Query query = session.createQuery("from Order where order_oid="+order_oid);
			List<Order> list = query.list();
			if (list.size() != 0) {
				for (Order order : list) {
					getPayResultResult.setCode(SUCCESS);
					//��ѯ������֧���ɹ��Ժ��޸��û����Կα�����ֵ
					if (order.getOrder_state().equals(0)) {
						getPayResultResult.setInfo(order.getOrder_state());
					}else {
						getPayResultResult.setInfo(order.getOrder_state());
					}
					
					
				}
			} else {
				getPayResultResult.setCode(ERROR);
				getPayResultResult.setInfo("���ö������ڣ����������붩��id��");
			}
			
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		getPayResultResult.setGetPayResultData(getPayResultData);
		return getPayResultResult;
	}
	
	
	
	
	/**
	 * 
	 * @Description: ������ֵ����
	 * @param user_uid
	 * @param type
	 * @param increase
	 * @return
	 */
	public CreateOrderResult createOrder (String user_uid,String type,String increase){
		CreateOrderResult createOrderResult = new CreateOrderResult();
		CreateOrderData createOrderData = new CreateOrderData();
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			System.out.println("type  == " + type);
			//ǰ�᣺�жϴ������ز����Ƿ���Ϲ���Ƿ�Ϊ��
			//1.���ҵ���ǰuid���û�
			//2.���ݴ�������ݴ���һ�������������ú�������Ե�ֵ
			//3.������������uid�û�������
			//4.����uid�û�
			
			System.out.println("user_uid  == " + user_uid + "    type  == " + type + "    increase == " + increase);
			Query query = session.createQuery("from User where user_uid="+user_uid);
			List<User> list = query.list();
			Order order = null;
			for (User user : list) {
				System.out.println("---------" + type);
				
				order = new Order();
				int i = 1 ;
				//�����ţ�����ƣ����Զ���
				order.setOrder_oid("1001000" + type + "00"+String.valueOf(i++));
				
				System.out.println("order.getOrder_oid() == " + order.getOrder_oid());
				order.setOrder_signString(increase);
				
				user.getUser_setOrders().add(order);
				
				//03.�������ݵ����ݿ�
				int result = (int) session.save(user);
				System.out.println("result == " + result);
				if (result == user.getUser_id()) {
					createOrderResult.setCode(SUCCESS);
					createOrderResult.setInfo("���������ɹ�");
					createOrderData.setOrderId(order.getOrder_oid());
					createOrderData.setSignString(order.getOrder_signString());

				} else {
					createOrderResult.setCode(ERROR);
					createOrderResult.setInfo("��������ʧ��");
				}
			
				
				
			}
			

			
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		createOrderResult.setCreateOrderData(createOrderData);
		return createOrderResult;
	}
	
	
	
	/**
	 * 
	 * @Description: �޸�����
	 * @param user_uid
	 * @return
	 */
	public UpdatePasswordResult updatePassword (String user_uid,String oldPassword,String newPassword){
		UpdatePasswordResult updatePasswordResult = new UpdatePasswordResult();
		UpdatePasswordData updatePasswordData = new UpdatePasswordData();
		updatePasswordResult.setUpdatePasswordData(updatePasswordData);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			System.out.println("oldPassword  == " + oldPassword);
			
			Query query = session.createQuery("from User where user_uid="+user_uid);
			List<User> list = query.list();
			for (User user : list) {
				System.out.println("---------" + oldPassword);
				if(oldPassword == null || oldPassword.isEmpty()){
					updatePasswordResult.setCode(ERROR);
					updatePasswordResult.setInfo("ԭ����Ϊ�գ����������룡");
					return updatePasswordResult;
				}
				if(newPassword == null || newPassword.isEmpty()){
					updatePasswordResult.setCode(ERROR);
					updatePasswordResult.setInfo("�����������룡");
					return updatePasswordResult;
				}
				if (!(oldPassword.equals(user.getUser_password()))) {
					System.out.println("----oldPassword-----" + user.getUser_password());
					updatePasswordResult.setCode(ERROR);
					updatePasswordResult.setInfo("ԭ���벻��ȷ�����������룡");
					return updatePasswordResult;
				}
				
			}
			System.out.println("sssssssss  = " + newPassword);
			String hql="update User set "
					+ "user_password='"+newPassword+"' where user_uid="+user_uid;
			
			System.out.println(hql);
			query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("result = " + result);
			if (result == 1) {
				
				updatePasswordResult.setCode(SUCCESS);
				updatePasswordResult.setInfo("�޸ĳɹ�");
				
			} else {
				updatePasswordResult.setCode(ERROR);
				updatePasswordResult.setInfo("�޸�ʧ��");
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
		return updatePasswordResult;
	}
	
	
	

	/**
	 * 
	 * @Description: �޸��û���Ϣ
	 * @param user_uid
	 * @return
	 */
	public UpdateUserInfoResult updateUserInfo (String user_uid,
			String user_head_image,String user_filename,
			String user_nickname,String user_realname,
			String user_sex,String user_banji){
		UpdateUserInfoResult updateUserInfoResult = new UpdateUserInfoResult();
		UpdateUserInfoData updateUserInfoData = new UpdateUserInfoData();
		updateUserInfoResult.setUpdateUserInfoData(updateUserInfoData);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			System.out.println("sassa  == " + user_head_image);
			
			Query query = session.createQuery("from User where user_uid="+user_uid);
			List<User> list = query.list();
			for (User user : list) {
				System.out.println("---------" + user_head_image);
				if(user_head_image == null || user_head_image.isEmpty()){
					System.out.println("//////////" + user_head_image);
					user_head_image = user.getUser_head_image();
					System.out.println("----user_head_image-----" + user.getUser_head_image());
				}
				if(user_filename == null || user_filename.isEmpty()){
					user_filename = user.getUser_filename();
					System.out.println("----user_filename-----" + user.getUser_filename());
				}
				if(user_nickname == null || user_nickname.isEmpty()){
					user_nickname = user.getUser_nickname();
					System.out.println("----user_nickname-----" + user.getUser_nickname());
				}
				if(user_realname == null || user_realname.isEmpty()){
					user_realname = user.getUser_realname();
					System.out.println("----user_realname-----" + user.getUser_realname());
				}
				if(user_sex == null || user_sex.isEmpty()){
					user_sex = user.getUser_sex();
					System.out.println("----user_sex-----" + user.getUser_sex());
				}
				if(user_banji == null || user_banji.isEmpty()){
					user_banji = user.getUser_banji();
					System.out.println("----user_banji-----" + user.getUser_banji());
				}
			}
			System.out.println("sssssssss  = " + user_head_image);
			String hql="update User set "
					+ "user_head_image='"+user_head_image+"',"
					+ "user_filename='"+user_filename+"',"
					+ "user_nickname='"+user_nickname+"',"
					+ "user_realname='"+user_realname+"',"
					+ "user_sex='"+user_sex+"',"
					+ "user_banji='"+user_banji+"' where user_uid="+user_uid;
			
			System.out.println(hql);
			query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("result = " + result);
			if (result == 1) {
				
				updateUserInfoResult.setCode(SUCCESS);
				updateUserInfoResult.setInfo("�޸ĳɹ�");
				
			} else {
				updateUserInfoResult.setCode(ERROR);
				updateUserInfoResult.setInfo("�޸�ʧ��");
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		
		return updateUserInfoResult;
	}

	/**
	 * 
	 * Description: �����û�uid��ѯ�û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public GetUserInfoByUidResult getUserInfoByUid(String user_uid) {
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
					getUserInfoByUidResult.setInfo("��ѯ�ɹ�");

					// private String user_nickname;
					// private String user_realname;
					// private String user_banji;
					// private String user_cash;
					// private String user_reg_type;
					// private String user_stop_time;
					// private String user_sex;
					// private String user_head_image;

					getUserInfoByUidData.setUser_nickname(user
							.getUser_nickname());
					getUserInfoByUidData.setUser_realname(user
							.getUser_realname());
					getUserInfoByUidData.setUser_banji(user.getUser_banji());
					getUserInfoByUidData.setUser_cash(user.getUser_cash());
					getUserInfoByUidData.setUser_reg_type(user
							.getUser_reg_type());
					getUserInfoByUidData.setUser_stop_time(user
							.getUser_stop_time());
					getUserInfoByUidData.setUser_sex(user.getUser_sex());
					getUserInfoByUidData.setUser_head_image(user
							.getUser_head_image());
				}
			} else {
				getUserInfoByUidResult.setCode(ERROR);
				getUserInfoByUidResult.setInfo("���û������ڣ������������û�uid��");
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		getUserInfoByUidResult.setGetUserInfoByUidData(getUserInfoByUidData);
		return getUserInfoByUidResult;
	}

	/**
	 * 
	 * Description: ��¼
	 * 
	 * @param user
	 * @return
	 */
	public LoginResult login(User user) {
		LoginResult loginResult = new LoginResult();
		LoginData loginData = new LoginData();
		loginResult.setLoginData(loginData);
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtils.getSessionObject();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("from User where user_phonenumber=?");
			query.setParameter(0, user.getUser_phonenumber());
			List<User> list = query.list();
			if (list.size() != 0) {
				for (User user2 : list) {
					if (user2.getUser_password()
							.equals(user.getUser_password())) {
						loginResult.setInfo(user2.getUser_uid());
						loginResult.setCode(SUCCESS);
					} else {
						loginResult.setCode(ERROR);
						loginResult.setInfo("����������������룡");
					}
				}
			} else {
				loginResult.setCode(ERROR);
				loginResult.setInfo("���û������ڣ��������������ǰ��ע�����ע�ᣡ");
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
	 * Description: ע��
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(User user) {
		boolean b = true;
		String sql = "INSERT INTO t_user (user_phonenumber, user_password) VALUES ("
				+ user.getUser_phonenumber()
				+ ", "
				+ user.getUser_password()
				+ ");";
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
	 * Description: ��ȡ��֤��
	 * 
	 * @param phonenumber
	 * @return
	 */
	public boolean getVerificationCode(String user_phonenumber) {
		boolean b = true;
		String sql = "select * from t_user where user_phonenumber='"
				+ user_phonenumber + "'";
		System.out.println("sql = " + sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// ��ѯ���ݿ�,��ȡ����uid��Ӧ������
			while (rs.next()) {
				System.out.println(rs.getString(5));

				if (rs.getString(5) != null) {
					b = false;
					System.out.println("��ȡ����ѯ���ݿ��ֵ");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("001");
			e.printStackTrace();
		} finally {
			System.out.println("002");
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}
		System.out.println("b = " + b);
		return b;

	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * 
	 * Description: ���ݸ�����sex��ѯ���ݿ�����
	 * 
	 * @param uid
	 * @return
	 */
	public ArrayList<User> getUserBySex(String sex) {
		ArrayList<User> users = new ArrayList<User>();

		String sql = "select * from t_user where sex='" + sex + "'";
		System.out.println("sql = " + sql);
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// ��ѯ���ݿ�,��ȡ����uid��Ӧ������
			while (rs.next()) {
				User user = new User();
				user.setUser_uid(rs.getString(2));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}

		return users;

	}

	/**
	 * 
	 * Description: ����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) {
		boolean b = true;
		String sql = "INSERT INTO t_user(" + "id,uid,username,sex,phonenumber,"
				+ "location,detailedaddress,postcode,birthday,wechat,"
				+ "growthvalue,account,password,integral,isdefaultaddress) "
				+ "VALUES(" + "," + user.getUser_uid();

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
	 * Description: �޸��û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		boolean b = true;
		String sql = "UPDATE t_user SET " + "WHERE uid='" + user.getUser_uid()
				+ "';";
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
	 * Description: ���ݸ�����uid��ѯ���ݿ�����
	 * 
	 * @param uid
	 * @return
	 */
	public User getUserByUid(String uid) {

		User user = new User();
		String sql = "select * from t_user where uid='" + uid + "'";
		ResultSet rs = SqlHelper.executeQuery(sql);
		try {
			// ��ѯ���ݿ�,��ȡ����uid��Ӧ������
			while (rs.next()) {

				user.setUser_uid(rs.getString(2));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getConnection());
		}

		return user;

	}

	/**
	 * 
	 * Description: ���ݸ�����uid�h���Ñ�
	 * 
	 * @param uid
	 * @return
	 */
	public boolean delUser(String uid) {
		boolean b = true;
		String sql = "delete from t_user where uid = '" + uid + "'";

		try {
			System.out.println("uid---" + uid);
			SqlHelper.executeUpdate(sql);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}

		return b;
	}

	/**
	 * 
	 * Description: ��ȡpageCount
	 * 
	 * @param pageSize
	 * @return
	 */
	public int getPageCount(int pageSize) {
		int rowCount = 0;
		ResultSet rs = null;
		String sql = "SELECT * from t_user";

		try {
			rs = SqlHelper.executeQuery(sql);

			// ��ѯ���ݿ�,�������ݹ��ж���ҳ
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
	 * @return Description: ���շ�ҳ����ȡ�û�
	 * @param pageNow
	 *            ��ǰҳ
	 * @param pageSize
	 *            ��ǰҳ��ʾ��������
	 * @return �û����ݶ��󼯺�
	 */
	public ArrayList<User> getUsersByPage(int pageNow, int pageSize) {
		ArrayList<User> al = new ArrayList<User>();

		String sql = "SELECT * from t_user WHERE id<=" + pageSize * pageNow
				+ " and id>=" + (pageSize * (pageNow - 1) + 1) + "; ";

		ResultSet rs = SqlHelper.executeQuery(sql);
		// ���η�װ����ResultSet---->User����---->ArrayList����
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
