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
import com.jiudianlianxian.domain.User;
import com.jiudianlianxian.entity.data.RegisterData;
import com.jiudianlianxian.entity.data.VerificationCodeData;
import com.jiudianlianxian.entity.result.RegisterResult;
import com.jiudianlianxian.entity.result.VerificationCodeResult;
import com.jiudianlianxian.service.UsersService;


/**
 * 
 * Title: RegisterServlet
 * Description: 注册
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月8日 下午5:52:50
 *
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
		String user_phonenumber = request.getParameter("user_phonenumber");
		String user_password = request.getParameter("user_password");
		
		User user = new User();
		user.setUser_phonenumber(user_phonenumber);
		user.setUser_password(user_password);
		UsersService usersService = new UsersService();
		
		RegisterResult registerResult = new RegisterResult();
		String jsonObject;
		
		try {
			if (usersService.register(user)) {
				
				registerResult.setCode(SUCCESS);
				registerResult.setInfo("注册成功");
				registerResult.setRegisterData(new RegisterData());
				jsonObject = JSONObject.toJSONString(registerResult);
				
			} else {
				
				registerResult.setCode(ERROR);
				registerResult.setInfo("注册失败");
				registerResult.setRegisterData(new RegisterData());
				jsonObject = JSONObject.toJSONString(registerResult);

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
