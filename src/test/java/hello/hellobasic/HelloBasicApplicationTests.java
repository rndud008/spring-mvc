package hello.hellobasic;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void testInvalidUser() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.util.ArrayList");
        //Class<?> clazz = ArrayList.class
        //Class<?> clazz = new ArrayList().getClass();

        System.out.println("클래스명: " + clazz.getName());
        System.out.println("부모 클래스: " + clazz.getSuperclass());

        System.out.println("인터페이스");
        for (Class<?> inf : clazz.getInterfaces()) {
            System.out.println("  " + inf.getName());
        }
    }

    @Test
    void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = User.class;

        // 생성자 호출
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object[] args = new Object[]{"springmvc",10};
        User user = (User) constructor.newInstance(args);

        System.out.println("Created User: " + user);

    }

    @Test
    void testField() throws IllegalAccessException, NoSuchFieldException {
        User user = new User();
        Class<?> clazz = user.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // private 필드 접근 허용
            System.out.println("필드명: " + field.getName());
            System.out.println("필드값: " + field.get(user));

            if (field.getType() == String.class) {
                field.set(user, "springmvc");
            }
        }
        Field usernameField = clazz.getDeclaredField("username");
        usernameField.setAccessible(true);
        System.out.println("수정된 username: " + usernameField.get(user));
    }

    @Test
    void testMethod() throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("hello.hellobasic.User");
        Object userInstance = clazz.getDeclaredConstructor().newInstance();
        System.out.println("Before user: " + userInstance);

        // setName 메서드 호출
        Method setName = clazz.getDeclaredMethod("setUsername", String.class);
        setName.invoke(userInstance, "springmvc");

        // setAge 메서드 호출
        Method setAge = clazz.getDeclaredMethod("setAge", int.class);
        setAge.invoke(userInstance, 25);

        // getName 메서드 호출
        Method getName = clazz.getDeclaredMethod("getUsername");
        getName.invoke(userInstance);

        // getAge 메서드 호출
        Method getAge = clazz.getDeclaredMethod("getAge");
        getAge.invoke(userInstance);

        System.out.println("After user: " + userInstance);
    }







}
