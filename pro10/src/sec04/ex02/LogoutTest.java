package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutTest
 */
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		
		session.invalidate();
		
		if((Integer)context.getAttribute(user_id) == 1) {
			List user_list = (ArrayList)context.getAttribute("user_list");
			user_list.remove(user_id);
			context.removeAttribute("user_list");
			context.removeAttribute(user_id);
			context.setAttribute("user_list", user_list);
		} else {
			Integer cnt = (Integer)context.getAttribute(user_id);
			context.removeAttribute(user_id);
			context.setAttribute(user_id, --cnt);
		}
		out.println("<br />로그아웃 했습니다.");

	}

}
