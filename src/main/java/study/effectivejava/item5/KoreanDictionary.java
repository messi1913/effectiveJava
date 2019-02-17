package study.effectivejava.item5;

import org.springframework.stereotype.Component;

public class KoreanDictionary implements Lexicon {
    @Override
    public void print() {
        System.out.println("It's Korean Dictionary");
    }
}
