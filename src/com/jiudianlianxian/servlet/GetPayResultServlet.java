package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.entity.result.CreateOrderResult;
import com.jiudianlianxian.entity.result.GetPayResultResult;
import com.jiudianlianxian.service.UsersService;




/**
 * 
 * @Title: GetPayResultServlet
 * @Description: 获取订单支付结果
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月21日 下午1:51:02
 *
 */
@WebServlet("/GetPayResultServlet")
public class GetPayResultServlet extends HttpServlet {
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;


	/**
	 * Constructor of the object.
	 */
	public GetPayResultServlet() {
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
		// 接收用户提交的用户名和密码
		String order_oid = request.getParameter("order_oid");
		System.out.println("user_uid  == " + order_oid + "    type  == " + order_oid + "    increase == " + order_oid);
		UsersService usersService = new UsersService();
		
		GetPayResultResult getPayResultResult = usersService.getPayResult(order_oid);
				
		String jsonObject;
		
		
		try {
			if (getPayResultResult.getCode() == SUCCESS) {
				
				jsonObject = JSONObject.toJSONString(getPayResultResult);
				
			} else {
				
				jsonObject = JSONObject.toJSONString(getPayResultResult);

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
