package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.UpdateUserInfoData;


/**
 * 
 * Title: UpdateUserInfoResult
 * Description: �޸��û���Ϣ����ʵ��
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��19�� ����11:10:51
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
