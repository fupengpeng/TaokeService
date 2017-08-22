package com.jiudianlianxian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jiudianlianxian.entity.result.GetUserInfoByUidResult;
import com.jiudianlianxian.entity.result.UpdateUserInfoResult;
import com.jiudianlianxian.service.UsersService;



/**
 * 
 * Title: UpdateUserInfoServlet
 * Description: 修改用户信息
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月19日 上午11:01:14
 *
 */
public class UpdateUserInfoServlet extends HttpServlet {
	
	
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;

	/**
	 * Constructor of the object.
	 */
	public UpdateUserInfoServlet() {
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
		String user_head_image = request.getParameter("user_head_image");
		String user_filename = request.getParameter("user_filename");
		String user_nickname = request.getParameter("user_nickname");
		String user_realname = request.getParameter("user_realname");
		String user_sex = request.getParameter("user_sex");
		String user_banji = request.getParameter("user_banji");
		System.out.println("user_head_image  == " + user_head_image);
		UsersService usersService = new UsersService();
		
		UpdateUserInfoResult updateUserInfoResult = usersService.updateUserInfo(user_uid, 
				user_head_image,user_filename, user_nickname, user_realname, user_sex, user_banji);
				
		String jsonObject;
		
		
		System.out.println();
		try {
			if (updateUserInfoResult.getCode() == SUCCESS) {
				
				jsonObject = JSONObject.toJSONString(updateUserInfoResult);
				
			} else {
				
				jsonObject = JSONObject.toJSONString(updateUserInfoResult);

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
