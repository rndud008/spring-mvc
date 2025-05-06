package hello.hellobasic.core;

public class ReflectionExecutor {

    private final ReflectionFieldManager fieldManager;
    private final ReflectionMethodManager methodManager;

    public ReflectionExecutor(Class<?> clazz) {
        this.fieldManager = new ReflectionFieldManager(clazz);
        this.methodManager = new ReflectionMethodManager(clazz);
    }

    public ReflectionFieldManager getFieldManager() {
        return fieldManager;
    }

    public ReflectionMethodManager getMethodManager() {
        return methodManager;
    }
}
