package study.effectivejava.item5.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpellCheckerClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class);
        spellChecker.isValid("Test");
    }
}
