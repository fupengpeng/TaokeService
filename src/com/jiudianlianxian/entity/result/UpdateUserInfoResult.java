package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.UpdateUserInfoData;


/**
 * 
 * Title: UpdateUserInfoResult
 * Description: 修改用户信息返回实体
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月19日 上午11:10:51
 *
 */
public class UpdateUserInfoResult extends BaseResult {
	
	
	private UpdateUserInfoData updateUserInfoData;

	public UpdateUserInfoData getUpdateUserInfoData() {
		return updateUserInfoData;
	}

	public void setUpdateUserInfoData(UpdateUserInfoData updateUserInfoData) {
		this.updateUserInfoData = updateUserInfoData;
	}
	
	

}
