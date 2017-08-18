package com.jiudianlianxian.domain;

import java.util.HashSet;
import java.util.Set;




/**
 * 
 * Title: Order
 * Description: 订单列表
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月18日 上午10:47:14
 *
 */
public class Order {
	
	private Integer order_id;
	private String order_oid;
	private String order_signString;
	
	private Set<User> order_setUsers = new HashSet<User>();

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_oid() {
		return order_oid;
	}

	public void setOrder_oid(String order_oid) {
		this.order_oid = order_oid;
	}

	public String getOrder_signString() {
		return order_signString;
	}

	public void setOrder_signString(String order_signString) {
		this.order_signString = order_signString;
	}

	public Set<User> getOrder_setUsers() {
		return order_setUsers;
	}

	public void setOrder_setUsers(Set<User> order_setUsers) {
		this.order_setUsers = order_setUsers;
	}



}
