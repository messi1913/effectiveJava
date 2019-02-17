package study.effectivejava.item5;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierTest {

    private static String getMyName(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sangmessi";
    }

    private static void printMyName(int index , String name){
        if(index >= 0) {
            System.out.println("The Value is " + name);
        } else {
            System.out.println("Invalid name");
        }
    }

    private static void printMyNameBySupplier(int index , Supplier<String> nameSupplier){
        if(index >= 0) {
            System.out.println("The Value is " + nameSupplier.get());
        } else {
            System.out.println("Invalid name");
        }
    }

    public static void main(String[] args) {
        //Case 1. 일반 케이스
        StopWatch stopWatch = new StopWatch("CASE1");
        stopWatch.start();
        printMyName(0, getMyName());
        printMyName(-1, getMyName());
        printMyName(-2, getMyName());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        //Case 2. Supplier 호출
        StopWatch stopWatch2 = new StopWatch("CASE2");
        stopWatch2.start();
        printMyNameBySupplier(0, () -> getMyName());
        printMyNameBySupplier(-1, () -> getMyName());
        printMyNameBySupplier(-2, () -> getMyName());
        stopWatch2.stop();
        System.out.println(stopWatch2.prettyPrint());
    }



}
