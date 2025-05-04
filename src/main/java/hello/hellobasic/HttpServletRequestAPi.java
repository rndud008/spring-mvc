package hello.hellobasic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet(name = "requestInfoServlet", urlPatterns = "/requestApi")
public class HttpServletRequestAPi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();

        printLine(out, "");
        printLine(out, "==== [ HttpServletRequest API 테스트 ] ====");
        printLine(out, "");


        // -------------------------------------------------------
        // 1) Header 관련 API
        // -------------------------------------------------------
        printLine(out, "[1] Header 관련 ----------------------");
        Collections.list(request.getHeaderNames())
                .forEach(headerName -> {
                    printLine(out, " - " + headerName);
                });


        printLine(out, "특정 헤더 'User-Agent': " + request.getHeader("User-Agent"));

        // 다중 값이 있을 수 있는 헤더 예시
        String cookieHeader = "Cookie";
        if (request.getHeader(cookieHeader) != null) {

            printLine(out, "쿠키 헤더의 모든 값:");

            Collections.list(request.getHeaders(cookieHeader))
                    .forEach(value -> {
                        printLine(out, " - " + value);
                    });
        }
        printLine(out, "");

        // -------------------------------------------------------
        // 2) 요청 메서드 및 경로 관련
        // -------------------------------------------------------
        printLine(out, "[2] 요청 메서드 및 경로 --------------");
        printLine(out, "request.getMethod(): " + request.getMethod());
        printLine(out, "request.getRequestURI(): " + request.getRequestURI());
        printLine(out, "request.getRequestURL(): " + request.getRequestURL());
        printLine(out, "request.getContextPath(): " + request.getContextPath());
        printLine(out, "request.getServletPath(): " + request.getServletPath());
        printLine(out, "request.getPathInfo(): " + request.getPathInfo());
        printLine(out, "");


        // -------------------------------------------------------
        // 3) 세션 관련
        // -------------------------------------------------------
        printLine(out, "[3] 세션 관련 ------------------------");
        HttpSession session = request.getSession(true);

        if (session == null) {
            printLine(out, "세션이 없습니다. (session == null)");

        } else {
            printLine(out, "세션 ID: " + session.getId());
            printLine(out, "요청된 세션 ID: " + request.getRequestedSessionId());

            // 세션 속성 조회
            printLine(out, "세션 속성 목록:");
            Collections.list(session.getAttributeNames())
                    .forEach(attrName -> {
                        Object val = session.getAttribute(attrName);
                        printLine(out, " - " + attrName + " : " + val);
                    });
        }
        printLine(out, "");

        // -------------------------------------------------------
        // 4) 속성 관련
        // -------------------------------------------------------
        printLine(out, "[4] request 속성 관련 ----------------");
        printLine(out, "현재 request attribute 목록:");
        printLine(out, "");

        Collections.list(request.getAttributeNames())
                .forEach(attrName -> {
                    Object val = request.getAttribute(attrName);
                    printLine(out, " - " + attrName + " : " + val);
                });

        // 예시) 속성 추가
        request.setAttribute("customAttr", "customValue");
        printLine(out, "customAttr 속성 추가 후 확인:");
        printLine(out, "customAttr = " + request.getAttribute("customAttr"));

        // 속성 제거
        request.removeAttribute("customAttr");
        printLine(out, "customAttr 제거 후 값: " + request.getAttribute("customAttr"));
        printLine(out, "");

        // -------------------------------------------------------
        // 5) 원격 및 로컬 정보
        // -------------------------------------------------------
        printLine(out, "[5] 원격 및 로컬 정보 -----------------");
        printLine(out, "request.getRemoteAddr(): " + request.getRemoteAddr());
        printLine(out, "request.getRemoteHost(): " + request.getRemoteHost());
        printLine(out, "request.getRemotePort(): " + request.getRemotePort());
        printLine(out, "request.getLocalAddr(): " + request.getLocalAddr());
        printLine(out, "request.getLocalName(): " + request.getLocalName());
        printLine(out, "request.getLocalPort(): " + request.getLocalPort());
        printLine(out, "");

        // -------------------------------------------------------
        // 6) 기타 메타데이터
        // -------------------------------------------------------
        printLine(out, "[6] 기타 메타데이터 --------------------");
        printLine(out, "request.getContentType(): " + request.getContentType());
        printLine(out, "request.getContentLength(): " + request.getContentLength());
        printLine(out, "request.getProtocol(): " + request.getProtocol());
        printLine(out, "request.getScheme(): " + request.getScheme());
        printLine(out, "request.getServerName(): " + request.getServerName());
        printLine(out, "request.getServerPort(): " + request.getServerPort());
        printLine(out, "");

        printLine(out, "==== [ API 테스트 종료 ] ====");
    }

    private void printLine(PrintWriter out, String message) {
        // 콘솔 출력
        System.out.println(message);
        // 브라우저(응답)에 출력
        out.println(message);
    }

}
