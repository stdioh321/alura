package br.com.stdioh.javadb.utils;

import br.com.stdioh.javadb.model.Produto;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class Utils {
    private static final Utils instance = new Utils();

    // Private constructor prevents instantiation from other classes
    private Utils() {
    }

    public static Utils getInstance() {
        return instance;
    }

    public String getRandomString() {
        return getRandomString(5);
    }
    public String getRandomString(Integer length) {
        if (length == null) length = 5;
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS)
                        .build();


        return randomStringGenerator.generate(length);
    }
}
