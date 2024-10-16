package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static final Separator separator = new Separator();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;

    static {
        try {
            input = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static ArrayList<Integer> numbers = new ArrayList<>(input.length());

    public static void main(String[] args) throws IOException {


        if (separator.isContainCustomSeparator(input)) {
            String text = separator.findCustomSeparator(input);
            test(text);
        }
        test(input);


    }

    public static void test(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (separator.isContain(input.charAt(i))) {
                int number = Integer.parseInt(String.valueOf(input.charAt(i - 1)));
                numbers.add(number);
                if (i == input.length() - 2) {
                    int test = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                    numbers.add(test);
                }
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }
}
