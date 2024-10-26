package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> basicDataClass = BasicData.class;

        // 해당 클래스와 상위 클래스에서 상속된 모든 public 메서드 반환
        System.out.println(" ==== methods() === ");
        Method[] methods = basicDataClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // 해당 클래스에서 선언된 모든 메서드 반환 (접근제어자 무관)
        System.out.println(" === declaredMethods() === " );
        Method[] declaredMethods = basicDataClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("declaredMethod = " + method);
        }
    }
}
