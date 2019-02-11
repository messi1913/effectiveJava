package study.effectivejava.item3;

import org.springframework.expression.spel.ast.Elvis;

public class Singleton1 {

    public static final Singleton1 singleton1 = new Singleton1();

    private Singleton1(){

    }

}
