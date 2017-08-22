package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.UpdatePasswordData;



/**
 * 
 * @Title: UpdatePasswordResult
 * @Description: 修改密码返回信息实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月19日 下午4:09:22
 *
 */
public class UpdatePasswordResult extends BaseResult {
	
	
	public UpdatePasswordData updatePasswordData = new UpdatePasswordData();

	public UpdatePasswordData getUpdatePasswordData() {
		return updatePasswordData;
	}

	public void setUpdatePasswordData(UpdatePasswordData updatePasswordData) {
		this.updatePasswordData = updatePasswordData;
	}
	
	
	

}
