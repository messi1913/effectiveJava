package study.effectivejava.item3;

import java.lang.reflect.Constructor;
import java.util.function.Supplier;

public class SingletonTest {

    public static void main(String[] args) {
        try {
            // 예제 1
            //Singleton1 singleton1 = new Singleton1();
            Singleton1 singleton1 = Singleton1.singleton1;
            Singleton1 singleton11 = Singleton1.singleton1;
            System.out.println(""+(singleton1 == singleton11));
            System.out.println(singleton1.hashCode()+":"+singleton11.hashCode());


            Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton1 reflection = constructor.newInstance();
            System.out.println(reflection.hashCode());

            //예제2
            Singleton2 singleton2 = Singleton2.getInstance();
            Singleton2 singleton22 = Singleton2.getInstance();
            System.out.println(""+(singleton2 == singleton22));
            System.out.println(singleton2.hashCode()+":"+singleton22.hashCode());

            Constructor<Singleton2> constructor2 = Singleton2.class.getDeclaredConstructor();
            constructor2.setAccessible(true);
            Singleton2 reflection2 = constructor2.newInstance();
            System.out.println(reflection2.hashCode());

            Supplier<Singleton2> singleton2Supplier = Singleton2::getInstance;
            Singleton2 singleton21 = singleton2Supplier.get();
            
            // 예제3
            String name = Singleton3.INSTANCE.getName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
