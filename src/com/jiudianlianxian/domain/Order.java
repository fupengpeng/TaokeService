package com.jiudianlianxian.domain;

import java.util.Date;





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
	
	private Integer order_id = 0;
	private String order_oid = null;
	private String order_signString = null;
	
	private String order_state = null;
	private Date order_date = new Date();
	private Double order_price = null;
	
	
	private User user 
	
//	= new User()
	
	;


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


	public String getOrder_state() {
		return order_state;
	}


	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public Double getOrder_price() {
		return order_price;
	}


	public void setOrder_price(Double order_price) {
		this.order_price = order_price;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	



}
