package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CalcServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = Integer.parseInt(request.getParameter("n1"));  //getParameter => 리턴타입이 String 이라서 parseInt로 타입 변경
		int n2 = Integer.parseInt(request.getParameter("n2"));
		String op = request.getParameter("op");
		
		/*
		System.out.println(n1);
		System.out.println(n2);
		System.out.println(op);  // 웹페이지에서 값을 찍으면 system.out 순서대로 console 창에 뿌려준다. */
		
		long result = 0;
		
		switch (op) {
		case "+" : result = n1 + n2 ; break; 
		case "-" : result = n1 - n2 ; break; 
		case "*" : result = n1 * n2 ; break; 
		case "/" : result = n1 / n2 ; break; 
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.append("<!doctype html>"
					+ "<html>"
					+ "<head>"
					+ "<title>계산기</title>"
					+ "</head>"
					+ "<body>")
			.append("계산 결과: " + result)
			.append("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
