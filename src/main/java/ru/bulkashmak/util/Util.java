package ru.bulkashmak.util;

import java.util.Random;

public class Util {

    @Deprecated
    public static String generateRandomStringOfLength(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generate(int length) {

        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.appendCodePoint(random.nextInt('z'-'a') + 'a');
        }

        return sb.toString();
    }
}
