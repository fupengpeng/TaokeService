package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.UpdatePasswordData;



/**
 * 
 * @Title: UpdatePasswordResult
 * @Description: �޸����뷵����Ϣʵ��
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��19�� ����4:09:22
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
