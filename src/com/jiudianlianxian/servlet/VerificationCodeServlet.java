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
import com.jiudianlianxian.entity.data.VerificationCodeData;
import com.jiudianlianxian.entity.result.VerificationCodeResult;
import com.jiudianlianxian.service.UsersService;

/**
 * 
 * Title: VerificationCodeServlet
 * Description: 注册获取短信验证码
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: Taoke
 * @author fupengpeng
 * @date 2017年8月8日 下午5:06:30
 *
 */
@WebServlet("/VerificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SUCCESS = 1;
	private static final int ERROR = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerificationCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 接收用户提交的用户名和密码
		String user_phonenumber = request.getParameter("user_phonenumber");
		
		UsersService usersService = new UsersService();
		
		VerificationCodeResult verificationCodeResult = new VerificationCodeResult();
		String jsonObject;
		
		try {
			if (usersService.getVerificationCode(user_phonenumber)) {
				
				verificationCodeResult.setCode(SUCCESS);
				verificationCodeResult.setInfo("验证码已发送");
				verificationCodeResult.setVerificationCodeData(new VerificationCodeData());
				jsonObject = JSONObject.toJSONString(verificationCodeResult);
				
			} else {
				
				verificationCodeResult.setCode(ERROR);
				verificationCodeResult.setInfo("该手机号已注册");
				verificationCodeResult.setVerificationCodeData(new VerificationCodeData());
				jsonObject = JSONObject.toJSONString(verificationCodeResult);

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

}
