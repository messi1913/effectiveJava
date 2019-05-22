package study.effectivejava.item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class EqualsCollectoins{
    public static void main(String[] args) {
        HashSet<BigDecimal> b = new HashSet<>();
        b.add(new BigDecimal("1.0"));
        b.add(new BigDecimal("1.00"));

        System.out.println(b.size()); // 2

        TreeSet<BigDecimal> tree = new TreeSet<>();
        tree.add(new BigDecimal("1.0"));
        tree.add(new BigDecimal("1.00"));

        System.out.println(tree.size()); // 1
    }
}