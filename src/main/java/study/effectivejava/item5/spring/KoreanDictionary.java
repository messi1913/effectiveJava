package study.effectivejava.item5.spring;

import org.springframework.stereotype.Component;

@Component
public class KoreanDictionary implements Lexicon {
    @Override
    public void print() {
        System.out.println("It's Korean Dictionary");
    }
}
