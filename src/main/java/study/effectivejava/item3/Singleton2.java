package study.effectivejava.item3;

import java.io.Serializable;

public class Singleton2 implements Serializable {

    private static final transient Singleton2 instance = new Singleton2();
    private Singleton2(){

    }

    public static Singleton2 getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

}
