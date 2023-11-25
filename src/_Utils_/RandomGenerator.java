package _Utils_;

import java.util.Random;

public class RandomGenerator {

    public RandomGenerator() {
        System.out.println("IT HAS BEEN CREATED " + this.getClass());
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
