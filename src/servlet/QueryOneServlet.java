package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import beans.Doctor;
import service.DoctorServiceImpl;
import service.IDoctorService;

/**
 * Servlet implementation class QueryOneServlet
 */
@WebServlet("/QueryOneServlet")
public class QueryOneServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//
		String id = request.getParameter("id");
		//调用业务逻辑层
		IDoctorService service = new DoctorServiceImpl();
		Doctor d = service.queryOneServ(Integer.parseInt(id));
		//
		String json = JSON.toJSONString(d);
		System.out.println(json);
		//
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
