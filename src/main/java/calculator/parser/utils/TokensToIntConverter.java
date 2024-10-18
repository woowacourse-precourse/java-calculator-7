package calculator.parser.utils;

import java.math.BigInteger;
import java.util.ArrayList;

public class TokensToIntConverter {

    public ArrayList<Integer> convertToInt(ArrayList<String> tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (token.matches(".*[^\\d].*")) {
                throw new IllegalArgumentException("Token contains invalid characters: " + token);
            }

            if (token.isEmpty()) {
                throw new IllegalArgumentException("Token is empty");
            }
            
            BigInteger bigIntValue = new BigInteger(token);
            if (bigIntValue.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                    bigIntValue.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                throw new IllegalArgumentException("Token is out of range: " + token);
            }

            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

}
