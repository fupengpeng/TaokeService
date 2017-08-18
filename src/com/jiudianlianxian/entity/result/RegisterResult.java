package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.RegisterData;


/**
 * 
 * Title: RegisterResult
 * Description: 注册返回信息
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月11日 下午4:33:39
 *
 */
public class RegisterResult extends BaseResult {
	
	private RegisterData registerData;
	

	public RegisterData getRegisterData() {
		return registerData;
	}

	public void setRegisterData(RegisterData registerData) {
		this.registerData = registerData;
	}
	
	

}
