package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //WAS 룰, 외부에서 직접적으로 WEB-INF 디렉토리 밑의 파일을 부를 수 없음
        String viewPath = "/WEB-INF/views/new-form.jsp";
        //컨트롤러 -> 뷰 제어권 넘기기
        //클라이언트로 다시가는 redirect가 아니라 서버 내에서 다른 jsp나 서블릿을 호출
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
