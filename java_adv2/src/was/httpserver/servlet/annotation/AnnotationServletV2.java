package was.httpserver.servlet.annotation;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationServletV2 implements HttpServlet {

    private final List<Object> controllers;

    public AnnotationServletV2(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();
        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Mapping.class)) {
                    String value = method.getAnnotation(Mapping.class).value();
                    if (value.equals(path)) { // 경로 일치 메서드 조건 확인
                        Class<?>[] parameterTypes = method.getParameterTypes(); // 확인 후 메서드에 맞는 인자 전달
                        Object[] args = new Object[parameterTypes.length];

                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (parameterTypes[i] == HttpRequest.class) {
                                args[i] = request;
                            } else if (parameterTypes[i] == HttpResponse.class) {
                                args[i] = response;
                            } else {
                                throw new IllegalArgumentException("Unsupported parameter type: " + parameterTypes[i]); // 실제 스프링mvc는 이렇게 단순하지 않을테니 비교해봐야 할 듯
                            }
                        }

                        // 메서드 인자 포멧 정해지고나서 invoke
                        try {
                            method.invoke(controller, args);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
