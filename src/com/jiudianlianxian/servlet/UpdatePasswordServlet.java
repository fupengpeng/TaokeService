package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.entity.result.UpdatePasswordResult;
import com.jiudianlianxian.entity.result.UpdateUserInfoResult;
import com.jiudianlianxian.service.UsersService;



/**
 * 
 * @Title: UpdatePasswordServlet
 * @Description: 修改密码
 * @Company: 济宁九点连线信息技术有限公司
 * @ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月19日 下午4:06:38
 *
 */
public class UpdatePasswordServlet extends HttpServlet {
	
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;

	/**
	 * Constructor of the object.
	 */
	public UpdatePasswordServlet() {
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
		String user_uid = request.getParameter("user_uid");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		System.out.println("user_head_image  == " + newPassword);
		UsersService usersService = new UsersService();
		
		UpdatePasswordResult updatePasswordResult = usersService.updatePassword(user_uid,oldPassword,newPassword);
				
		String jsonObject;
		
		
		System.out.println();
		try {
			if (updatePasswordResult.getCode() == SUCCESS) {
				
				jsonObject = JSONObject.toJSONString(updatePasswordResult);
				
			} else {
				
				jsonObject = JSONObject.toJSONString(updatePasswordResult);

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
