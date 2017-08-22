package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.entity.result.CreateOrderResult;
import com.jiudianlianxian.entity.result.UpdatePasswordResult;
import com.jiudianlianxian.service.UsersService;


/**
 * 
 * @Title: CreateOrderServlet
 * @Description: ��������
 * @Company: �����ŵ�������Ϣ�������޹�˾
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017��8��19�� ����4:59:30
 *
 */
public class CreateOrderServlet extends HttpServlet {
	
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;


	/**
	 * Constructor of the object.
	 */
	public CreateOrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// �����û��ύ���û���������
		String user_uid = request.getParameter("user_uid");
		String type = request.getParameter("type");
		String increase = request.getParameter("increase");
		System.out.println("user_uid  == " + user_uid + "    type  == " + type + "    increase" + increase);
		UsersService usersService = new UsersService();
		
		CreateOrderResult createOrderResult = usersService.createOrder(user_uid,type,increase);
				
		String jsonObject;
		
		
		System.out.println();
		try {
			if (createOrderResult.getCode() == SUCCESS) {
				
				jsonObject = JSONObject.toJSONString(createOrderResult);
				
			} else {
				
				jsonObject = JSONObject.toJSONString(createOrderResult);

			}
			PrintWriter printWriter = response.getWriter();
			printWriter.write(jsonObject);
			printWriter.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
