package DBLinkQuiz;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("/rcontrol2")
public class RegistController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegistDAO dao;
       
    
    public RegistController2() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	dao = new RegistDAO();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String view = "";
		
		if(action == null) {
			getServletContext().getRequestDispatcher("/rcontrol2?action=list")
			.forward(request, response);
		} else {
			
			switch (action) {
			case "list": view = list(request, response); break;
			case "insert": view = insert(request, response); break;
			}
			
			getServletContext().getRequestDispatcher("/DBLinkQuiz/" + view)
			.forward(request, response);			
		}
		
	}
	
	public String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("regist", dao.getAll());
		return "registInfo.jsp";
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		Regist r = new Regist();
		
		try {
			BeanUtils.populate(r, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dao.insert(r);
		return "registInfo.jsp";
	}


    
    

}
