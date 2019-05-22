package study.effectivejava.item14;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Lamda{
    public static void main(String[] args) {
        Func add = (int a, int b) -> ( a+ b)  ;
        add.calc(1, 2);//3

        Func sub = (int a, int b) -> a - b;
        Func add2 = (int a, int b) -> { return a + b; };

        int result = add.calc(1,2) + add2.calc(3, 4); // 10

        System.out.println(result);

        Arrays.asList(1,2,3).stream(); // (1)
        Arrays.asList(1,2,3).parallelStream(); // (2)


        //https://jdm.kr/blog/181
        Arrays.asList(1,2,3).stream()
                    .forEach(System.out::println); // 1,2,3
        
        Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4,5),Arrays.asList(6,7,8,9)).stream()
					.flatMap(i -> i.stream())
                    .forEach(System.out::println); // 1,2,3,4,5,6,7,8,9
        Arrays.asList(1,2,3).stream()
					.filter(i-> 2>=i)
					.forEach(System.out::println); // 1,2                       
        Arrays.asList(1,2,3).stream()
					.reduce((a,b)-> a-b)
                    .get(); // -4
                    
        Arrays.asList(1,2,3).stream()
					.collect(Collectors.toList());
        Arrays.asList(1,2,3).stream()
					.iterator();
    }
}


// interface Func {
// 	public int calc(int a, int b);
// }


@FunctionalInterface
interface Func {
	public int calc(int a, int b);
}