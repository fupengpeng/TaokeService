package com.jiudianlianxian.entity.result;

import java.util.ArrayList;
import java.util.List;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.GetPayResultData;


/**
 * 
 * @Title: GetBasicClassResult
 * @Description: 获取基础分类返回信息实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午3:12:40
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
