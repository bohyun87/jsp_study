package ch08;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rcontrol")
public class RegistController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    RegistService service;
    
	@Override
    public void init(ServletConfig config) throws ServletException {
   	 super.init(config);
   	 service = new RegistService(); //서블릿이 초기화 될때 ProductService객체를 생성
    }
    
	//클라이언트에서 request가 오면 service가 실행된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 String action = request.getParameter("action"); //action 파라메터의 값을 얻어온다.
   	 System.out.println("1:" + action);
   	 String view = "";
   	 
   	 if(action == null) {
   		 getServletContext().getRequestDispatcher("/rcontrol?action=list").forward(request, response);
   		 System.out.println("2:" + action);
   	 } else {
   		 switch(action) {
   		 case "list": view = list(request, response); break;
   		 case "info": view = info(request, response); break;
   		 }
   		 
   		 getServletContext().getRequestDispatcher("/ch08/" + view).forward(request, response);
   	 }
    }
    
    private String info(HttpServletRequest request, HttpServletResponse response) {
   	 //한가지 상품만 가져온다.
   	 Regist prod = service.find(request.getParameter("id"));
   	 request.setAttribute("p", prod);
   	 return "registInfo.jsp";
    }
    
    private String list(HttpServletRequest request, HttpServletResponse response) {
   	 //모든 상품을 가져온다.
   	 List<Regist> plist = service.findAll();
   	 request.setAttribute("register", plist);
   	 return "registList.jsp";
    }

}