package study.effectivejava.item6;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Item6 {

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        // String primitive vs wrapper
        String literal = "loper";
        String object = new String("loper");
        String intern = object.intern();

        System.out.println(literal == object); // false
        System.out.println(literal.equals(object)); // true
        System.out.println(literal == intern); // true
        System.out.println(literal.equals(intern)); // true

        // Pattern
        System.out.println(isRomanNumeral("123123"));

        // Adapter
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Burger", 8);
        menu.put("Pizza", 9);

        Set<String> names1 = menu.keySet();
        Set<String> names2 = menu.keySet();

        names1.remove("Burger");
        System.out.println(names2.size()); // 1
        System.out.println(menu.size()); // 1

        // AutoBoxing
        StopWatch stopWatch = new StopWatch("Auto Boxing");
        stopWatch.start();
        Long sum = 0l;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }
}
