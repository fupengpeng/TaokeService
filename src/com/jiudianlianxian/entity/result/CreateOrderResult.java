package com.jiudianlianxian.entity.result;

import com.jiudianlianxian.entity.BaseResult;
import com.jiudianlianxian.entity.data.CreateOrderData;



/**
 * 
 * @Title: CreateOrderResult
 * @Description: ��������������Ϣʵ��
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��19�� ����5:02:41
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
