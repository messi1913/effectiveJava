package study.effectivejava.item5.spring;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@Component
public class SpellChecker {

    private Lexicon dictionary;

    public SpellChecker(Lexicon lexicon) {
        this.dictionary = Objects.requireNonNull(lexicon);
    }

    public boolean isValid(String woro) {
        dictionary.print();
        return true;
    }

    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }


}
