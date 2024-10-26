package reflection;

import reflection.data.Calculator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodV3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("호출 메서드: ");
        String methodName = scanner.nextLine();

        Calculator calculator = new Calculator();

        Class<Calculator> calculatorClass = Calculator.class;
        Method method = calculatorClass.getMethod(methodName, int.class, int.class);
        Object resultValue = method.invoke(calculator, 5, 4);

        System.out.println("resultValue = " + resultValue);
    }
}
