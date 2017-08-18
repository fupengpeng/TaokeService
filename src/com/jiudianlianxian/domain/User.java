package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Title: User
 * Description: �û�
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��14�� ����3:30:44
 *
 */
public class User {
	private Integer user_id;
	/**
	 * �û�uid
	 */
	private String user_uid;
	/**
	 * �û��ǳ�
	 */
	private String user_nickname;
	/**
	 * �û���ʵ����
	 */
	private String user_realname;
	/**
	 * �û��꼶����
	 */
	private String user_banji;
	/**
	 * �û��Կα�
	 */
	private String user_cash;
	/**
	 * �û�ע�᷽ʽ
	 */
	private String user_reg_type;
	/**
	 * �û��꿨��ֹʱ��
	 */
	private String user_stop_time;
	/**
	 * �û��Ա�
	 */
	private String user_sex;
	/**
	 * �û�ͷ���ַ
	 */
	private String user_head_image;
	/**
	 * �û��û�ͷ���ļ���
	 */
	private String user_filename;
	/**
	 * �û��ֻ���
	 */
	private String user_phonenumber;
	/**
	 * �û�����
	 */
	private String user_password;
	
	
	/**
	 * �û�����
	 */
	private Set<Order> user_setOrders = new HashSet<Order>();

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_uid() {
		return user_uid;
	}

	public void setUser_uid(String user_uid) {
		this.user_uid = user_uid;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public String getUser_banji() {
		return user_banji;
	}

	public void setUser_banji(String user_banji) {
		this.user_banji = user_banji;
	}

	public String getUser_cash() {
		return user_cash;
	}

	public void setUser_cash(String user_cash) {
		this.user_cash = user_cash;
	}

	public String getUser_reg_type() {
		return user_reg_type;
	}

	public void setUser_reg_type(String user_reg_type) {
		this.user_reg_type = user_reg_type;
	}

	public String getUser_stop_time() {
		return user_stop_time;
	}

	public void setUser_stop_time(String user_stop_time) {
		this.user_stop_time = user_stop_time;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_head_image() {
		return user_head_image;
	}

	public void setUser_head_image(String user_head_image) {
		this.user_head_image = user_head_image;
	}

	public String getUser_filename() {
		return user_filename;
	}

	public void setUser_filename(String user_filename) {
		this.user_filename = user_filename;
	}

	public String getUser_phonenumber() {
		return user_phonenumber;
	}

	public void setUser_phonenumber(String user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Set<Order> getUser_setOrders() {
		return user_setOrders;
	}

	public void setUser_setOrders(Set<Order> user_setOrders) {
		this.user_setOrders = user_setOrders;
	}


	
	

}
