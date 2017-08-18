package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.LoginData;



/**
 * 
 * Title: LoginResult
 * Description: 登录返回信息
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月11日 下午4:44:18
 *
 */
public class LoginResult extends BaseResult {
	
	private LoginData loginData;

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}
	
	
	

}
