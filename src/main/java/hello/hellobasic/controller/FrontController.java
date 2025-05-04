package hello.hellobasic.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontController", urlPatterns = "/front-controller/*")
public class FrontController extends HttpServlet {

    private Map<String , Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        controllerMap.put("/front-controller/members/new-form", new MemberFormContorller());
        controllerMap.put("/front-controller/members/save", new MemberSaveContorller());
        controllerMap.put("/front-controller/members/list", new MemberListContorller());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        Controller controller = controllerMap.get(requestURI);

        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        String viewPath = controller.process(request, response);



        request.getRequestDispatcher(viewPath).forward(request,response);
    }
}
