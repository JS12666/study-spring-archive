package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //이동할 viewPath
        dispatcher.forward(request, response); //viewPath로 이동(attribute에 있는 데이터들도 같이 옮겨줌)
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        // model(Map(DB))에 저장된 모든 값(키, 밸류)을 Attribute에 옮김
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
