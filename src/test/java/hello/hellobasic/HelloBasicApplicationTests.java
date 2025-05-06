package hello.hellobasic;

import hello.hellobasic.core.ReflectionExecutor;
import hello.hellobasic.core.ReflectionFieldManager;
import hello.hellobasic.core.ReflectionMethodManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Map;

@SpringBootTest
class HelloBasicApplicationTests {

    @Test
    void testReflection() throws Exception {

        Class<?> userClass = Class.forName("hello.hellobasic.User");
        Constructor<?> declaredConstructor = userClass.getDeclaredConstructor(Long.class, String.class, String.class);
        Object user = declaredConstructor.newInstance(1L, "springmvc", "a@a.com");

        ReflectionExecutor reflectionExecutor = new ReflectionExecutor(userClass);
        ReflectionFieldManager fieldManager = reflectionExecutor.getFieldManager();
        fieldManager.setFieldValue(user, "username", "springboot" );

        ReflectionMethodManager methodManager = reflectionExecutor.getMethodManager();
        methodManager.invokeMethod(user, "setEmail", "springmvc@gmail.com");

        Object id = fieldManager.getFieldValue(user, "id");
        Object username = fieldManager.getFieldValue(user, "username");
        Object email = fieldManager.getFieldValue(user, "email");

        System.out.println("id = " + id);
        System.out.println("username = " + username);
        System.out.println("email = " + email);

    }

    @Test
    void testReflection2() throws Exception {

        DomainRepository<User> userRepository = new DomainRepository<>(User.class, "id");
        Map<String, Object> userData = Map.of("id", 1L, "username", "springboot", "email", "springmvc@gmail.com");
        User user = userRepository.save(userData);
        System.out.println("user = " + user);

        userRepository.invoke(1L, "setProfile", user.getId() + ": " + user.getUsername() + ":" + user.getEmail());

        System.out.println("profile = " + userRepository.getExecutor().getFieldManager().getFieldValue(user, "profile"));

        DomainRepository<Item> itemRepository = new DomainRepository<>(Item.class, "id");
        Map<String, Object> itemData = Map.of("code", 1L, "name", "springboot", "price", 10000);
        Item item = itemRepository.save(itemData);
        System.out.println("item = " + item);

        itemRepository.invoke(1L, "disCount", 1000);

        System.out.println("profile = " + itemRepository.getExecutor().getFieldManager().getFieldValue(item, "price"));



    }
}
