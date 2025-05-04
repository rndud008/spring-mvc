package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addCookieServlet", urlPatterns = "/addCookie")
public class AddCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 쿠키 생성
        Cookie cookie = new Cookie("myCookie", "helloCookie");
        cookie.setMaxAge(3600); // 1시간 (초 단위)

        // 쿠키 추가
        response.addCookie(cookie);

        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("myCookie=helloCookie 쿠키를 추가했습니다. (유효기간 1시간)");
    }
}