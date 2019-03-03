package study.effectivejava.item8;

public class FinalizerExample {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Clean Up");
    }

    public void hello() {
        System.out.println("hi");
    }
}
