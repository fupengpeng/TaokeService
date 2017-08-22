package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.CreateOrderData;



/**
 * 
 * @Title: CreateOrderResult
 * @Description: 创建订单返回信息实体
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月19日 下午5:02:41
 *
 */
public class CreateOrderResult extends BaseResult {
	
	private CreateOrderData createOrderData = new CreateOrderData();

	public CreateOrderData getCreateOrderData() {
		return createOrderData;
	}

	public void setCreateOrderData(CreateOrderData createOrderData) {
		this.createOrderData = createOrderData;
	}
	
	
	
	

}
