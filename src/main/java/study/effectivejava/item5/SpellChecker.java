package study.effectivejava.item5;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpellChecker {

    private final Lexicon dictionary;

    public SpellChecker(Lexicon lexicon) {
        this.dictionary = Objects.requireNonNull(lexicon);
    }

    public SpellChecker(Supplier<Lexicon> lexiconSupplier) {
        this.dictionary = Objects.requireNonNull(lexiconSupplier.get());
    }

    public boolean isValid(String woro) {
       dictionary.print();
       return true;
    }

    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Lexicon lexicon = new KoreanDictionary();
        SpellChecker spellChecker = new SpellChecker(lexicon);
        spellChecker.isValid("valid test");

        Lexicon testDictionary = new TestDictionary();
        SpellChecker spellCheckerSupplier = new SpellChecker(() -> testDictionary);
        spellCheckerSupplier.isValid("valid test");
    }

}
