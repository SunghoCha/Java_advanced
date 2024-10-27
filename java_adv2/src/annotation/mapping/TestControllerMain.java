package annotation.mapping;

import java.lang.reflect.Method;

public class TestControllerMain {

    public static void main(String[] args) {
        TestController testController = new TestController();

        Method[] methods = testController.getClass().getDeclaredMethods();
        for (Method method : methods) {
            SimpleMapping annotation = method.getAnnotation(SimpleMapping.class);
            if (annotation != null) {
                System.out.println("[" + annotation.value() + "] -> " + method);
            }
        }
    }
}
