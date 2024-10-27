package annotation.basic;

import io.util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {

    String value();
    int count() default 0;
    String[] tags() default {};

    // 커스텀 타입은 적용 불가. 다만 클래스 정보는 가능
    Class<? extends MyLogger> annoData() default MyLogger.class;
}
