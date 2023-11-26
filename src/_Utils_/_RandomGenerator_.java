package _Utils_;

import java.util.Random;

public class _RandomGenerator_ {
    _Logger_ logger;

    public _RandomGenerator_() {
        logger.logDebug("Created " + getClass());
    }

    public static String generateRandomString() {
        Random random = new Random();

        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            if (random.nextBoolean()) {
                randomChar = Character.toUpperCase(randomChar);
            }
            randomString.append(randomChar);
        }

        for (int i = 0; i < 3; i++) {
            randomString.append(random.nextInt(10));
        }

        return randomString.toString();
    }
}
