package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "name1", 10);
        System.out.println("기존 이름 = " + user.getName());

        Class<? extends User> aClass = user.getClass();
        Field nameField = aClass.getDeclaredField("name");

        // private 필드에 접근 허용 설정. 메서드도 동일 방식
        nameField.setAccessible(true);
        nameField.set(user, "userB"); // user 인스턴스의 nameField 값 설정
        System.out.println("변경된 이름 = " + user.getName());
    }
}
