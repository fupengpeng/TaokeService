package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetPayResultData;


/**
 * 
 * @Title: GetPayResultResult
 * @Description: 支付结果返回信息实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 上午10:51:38
 *
 */
public class GetPayResultResult extends BaseResult {
	
	
	private GetPayResultData getPayResultData = new GetPayResultData();

	public GetPayResultData getGetPayResultData() {
		return getPayResultData;
	}

	public void setGetPayResultData(GetPayResultData getPayResultData) {
		this.getPayResultData = getPayResultData;
	}
	
	
	

}
