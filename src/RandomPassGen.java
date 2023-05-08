import java.security.SecureRandom;
import java.util.Random;

public class RandomPassGen {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBERS = "0123456789";
    private static final String OTHER_CHARS = "!@#$%&*()_+-=[]?";
    private static final String CHAR_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBERS + OTHER_CHARS;
    private static final Random random = new SecureRandom();
    private static final int passwordLength = 12;


    public static String CreatePass() {

        if (passwordLength < 1) {
            throw new IllegalArgumentException("Şifre uzunluğu en az 1 olmalı.");
        }

        StringBuilder sb = new StringBuilder(passwordLength);

        //Generate the first Character
        int RandomIndex = random.nextInt(CHAR_LOWER.length());
        char randomChar = CHAR_LOWER.charAt(RandomIndex);
        sb.append(randomChar);

        //Generate the second Character
        RandomIndex = random.nextInt(CHAR_UPPER.length());
        randomChar = CHAR_UPPER.charAt(RandomIndex);
        sb.append(randomChar);

        //Generate the Third Character
        RandomIndex = random.nextInt(NUMBERS.length());
        randomChar = NUMBERS.charAt(RandomIndex);
        sb.append(randomChar);

        for (int i = 3; i < passwordLength; i++) {

            RandomIndex = random.nextInt(CHAR_ALLOW_BASE.length());
            randomChar = CHAR_ALLOW_BASE.charAt(RandomIndex);
            sb.append(randomChar);

        }

        return sb.toString();
    }
}
