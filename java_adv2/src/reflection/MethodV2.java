package reflection;

import reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BasicData basicData = new BasicData();
        basicData.call();

        // 동적 메서드 호출 - 리플렉션 사용
        Method helloMethod = basicData.getClass().getDeclaredMethod("hello", String.class); // hello 메소드의 인자 타입 String
        
        // 메서드에 인스턴스 전달해서 특정 인스턴스의 메서드 지정하고 hello 메서드의 인자로 "hi" 전달
        Object returnValue = helloMethod.invoke(basicData, "hi");
        System.out.println("returnValue = " + returnValue);
    }
}
