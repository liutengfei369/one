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
		//1.��ѯҽ�����е�������Ϣ���õ�һ��List����
		List<Doctor> list = service.queryAllServ();

		//2.ת����list.jsp���Ѽ������ݴ���ҳ����ȥ
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
