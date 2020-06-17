package servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import beans.Doctor;
import service.DoctorServiceImpl;
import service.IDoctorService;
import util.JdbcUtil;

/**
 * Servlet implementation class QueryAllServlet
 */
@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDoctorService service = new DoctorServiceImpl();
		//1.查询医生表中的所有信息，得到一个List集合
		List<Doctor> list = service.queryAllServ();

		//2.转发到list.jsp，把集合数据带到页面中去
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
