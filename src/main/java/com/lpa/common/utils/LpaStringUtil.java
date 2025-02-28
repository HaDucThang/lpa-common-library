package com.lpa.common.utils;

import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

@UtilityClass
@FieldDefaults(makeFinal = true)
public class LpaStringUtil {
    public static String generateString(int length) {
        RandomStringGenerator randomStringGenerator =
                new RandomStringGenerator.Builder()
                        .withinRange('0', 'z')
                        .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS).get();
        return randomStringGenerator.generate(length);
    }

    public static String toSnakeCase(String input) {
        return input
                .replaceAll("([A-Z])(?=[A-Z])", "$1_")
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();
    }
}
