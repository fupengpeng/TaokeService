package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetPayResultData;


/**
 * 
 * @Title: GetPayResultResult
 * @Description: ֧�����������Ϣʵ��
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����10:51:38
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
