package ch05quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String result;
		
		if(id.equals("person") && password.equals("1234")) {
			result = id + "님 반갑습니다.";
		} else {
			result = "로그인 실패" ;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.append("<!doctype html>"
					+ "<html>"
					+ "<head>"
					+ "<title>로그인</title>"
					+ "</head>"
					+ "<body>")
			.append("<h2>로그인 서블릿</h2><hr>")
			.append(result)
			.append("</body></html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
