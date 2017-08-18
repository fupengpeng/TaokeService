package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.VerificationCodeData;


/**
 * 
 * Title: VerificationCodeResult
 * Description: 获取验证码返回实体类
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月8日 下午5:12:41
 *
 */
public class VerificationCodeResult extends BaseResult {
	
	private VerificationCodeData verificationCodeData;

	public VerificationCodeData getVerificationCodeData() {
		return verificationCodeData;
	}

	public void setVerificationCodeData(VerificationCodeData verificationCodeData) {
		this.verificationCodeData = verificationCodeData;
	}
	

}
