package hello.hellobasic;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "lifecycleServlet", urlPatterns = "/lifecycle", loadOnStartup = 1)
public class LifecycleServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("LifecycleServlet init() 호출 (서블릿 초기화)");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet() 메서드 실행 (클라이언트 요청 처리)");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HelloLifecycleServlet: doGet() 응답</h2>");
        out.println("<p>서블릿 생명주기 확인 예제</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost() 메서드 실행 (클라이언트 요청 처리)");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>HelloLifecycleServlet: doPost() 응답</h2>");
        out.println("<p>서블릿 생명주기 확인 예제</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("LifecycleServlet destroy() 호출 (서블릿 종료)");
        super.destroy();
    }
}
