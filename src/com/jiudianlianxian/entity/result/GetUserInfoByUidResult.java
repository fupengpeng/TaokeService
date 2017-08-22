package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetUserInfoByUidData;


/**
 * 
 * Title: GetUserInfoByUidResult
 * Description: 根据uid获取用户信息，返回实体
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月18日 下午4:29:44
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
