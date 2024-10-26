package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Field;

public class FieldV1 {

    public static void main(String[] args) {
        Class<BasicData> basicDataClass = BasicData.class;

        // 해당 클래스와 상위 클래스에서 상속된 모든 public 필드 반환
        System.out.println("=== fields() ===");
        Field[] fields = basicDataClass.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }


        // 해당 클래스에서 선언된 모든 필드 반환 (접근제어자 상관 없음)
        System.out.println("=== declaredFields() ===");
        Field[] declaredFields = basicDataClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }
    }
}
