package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetUserInfoByUidData;


/**
 * 
 * Title: GetUserInfoByUidResult
 * Description: ����uid��ȡ�û���Ϣ������ʵ��
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��18�� ����4:29:44
 *
 */
public class GetUserInfoByUidResult extends BaseResult {
	
	
	private GetUserInfoByUidData getUserInfoByUidData = new GetUserInfoByUidData();

	public GetUserInfoByUidData getGetUserInfoByUidData() {
		return getUserInfoByUidData;
	}

	public void setGetUserInfoByUidData(GetUserInfoByUidData getUserInfoByUidData) {
		this.getUserInfoByUidData = getUserInfoByUidData;
	}

	
	
	

}
