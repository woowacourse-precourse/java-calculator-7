package calculator;

public class Tokenizer {

    public static String[] tokenize(char[] separators, String str) {
        for (char separator: separators) {
            str = str.replace(separator, separators[0]);
        }
        return str.split(String.valueOf(separators[0]));
    }
}
