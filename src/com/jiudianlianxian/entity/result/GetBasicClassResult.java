package com.jiudianlianxian.entity.result;

import java.util.ArrayList;
import java.util.List;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetPayResultData;


/**
 * 
 * @Title: GetBasicClassResult
 * @Description: ��ȡ�������෵����Ϣʵ��
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��21�� ����3:12:40
 *
 */
public class GetBasicClassResult extends BaseResult {
	
	private List<GetPayResultData> getPayResultDatas = new ArrayList<GetPayResultData>();

	public List<GetPayResultData> getGetPayResultDatas() {
		return getPayResultDatas;
	}

	public void setGetPayResultDatas(List<GetPayResultData> getPayResultDatas) {
		this.getPayResultDatas = getPayResultDatas;
	}
	
	
	

}
