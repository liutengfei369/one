package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DoctorServiceImpl;
import service.IDoctorService;
import beans.Doctor;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//接收要修改的数据
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String hobbystr = "";
		//把数组中的多个爱好，用逗号拼接成一个字符串
		for(String one : hobby){
			hobbystr += one+",";
		}
		hobbystr = hobbystr.substring(0, hobbystr.length()-1);//把最后一个逗号截掉
		
		String id = request.getParameter("id");
		Doctor d = new Doctor(Integer.parseInt(id), name, sex, birth, hobbystr);
		
		IDoctorService service = new DoctorServiceImpl();
		int i = service.updateServ(d);
		//
		PrintWriter out = response.getWriter();
		out.print(i);
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
}
