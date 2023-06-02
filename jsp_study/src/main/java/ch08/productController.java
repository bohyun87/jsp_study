package ch08;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductController", urlPatterns = { "/pcontrol" })
public class productController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);  //서블릿 초기화
		
		//프로그램 실행시 최초로 request가 왔을 때 객체를 딱 한번만 생성한다.
		//=> init() 은 초기화 역할을 하는 메소드이므로 딱한번 실행된다.
		service = new ProductService();
	}

	public productController() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request: 화면단에서 전달해 준 데이터가 들어있다.
		String action = request.getParameter("action");
		String view = "";
		
		//action이 null 이면
		//http://localhost:8081/jsp_study/pcontrol?action=list 주소로 forward
		if(action == null) {
			getServletContext()
			.getRequestDispatcher("/pcontrol?action=list")   //forward => 데이터를 가지고 페이지 이동하지만 주소는 바뀌지 않는다. 
			.forward(request, response);  //forward => 어떤 데이터를 같이 전달해준다.
		} else {
			switch(action) {
				case "list": view = list(request, response); break;  //상품목록
				case "info": view = info(request, response); break;  //상품 상세페이지
			}
			getServletContext()
			.getRequestDispatcher("/ch08/" + view)
			.forward(request, response);
		}
	}
	
	//productService(model) 에게 특정상품을 찾아와달라고 요청 
	//productService의 find 메소드를 실행
	//상품 상세페이지
	private String info(HttpServletRequest request, HttpServletResponse response) {
		Product p = service.find(request.getParameter("id"));
		
		//특벙 id로 찾은 product 객체를 request 객체에 넣어준다.
		request.setAttribute("p", p);		
		return "productInfo.jsp";
	}
	
	//상품목록
	private String list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Product> products = service.findAll();
		request.setAttribute("products", products);
		return "productList.jsp";
	}
  
	
	
}
