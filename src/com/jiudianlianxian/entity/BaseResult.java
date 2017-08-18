package com.jiudianlianxian.entity;

/**
 * 
 * Title: BaseResult
 * Description: 返回信息base类
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: ShoppingMall
 * @author fupengpeng
 * @date 2017年8月3日 下午4:27:28
 *
 */
public class BaseResult {
	
	private int code;
	private String info;
	
	public BaseResult(){}
	
	public BaseResult(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
