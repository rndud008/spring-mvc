package hello.hellobasic.adapter;


public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void newRequest() {
        // Adaptee의 메서드를 호출하면서 타깃에 맞게 변환
        adaptee.oldRequest();
    }
}