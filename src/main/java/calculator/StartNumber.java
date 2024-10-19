package calculator;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class StartNumber {

    private static final Pattern formatCheck = Pattern.compile("\\d+([,:]\\d+)*");

    public ArrayList<Integer> readNumInput (String input) {

        if (!formatCheck.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> numbers = new ArrayList<>();

        String[] temps = input.split("[,:]");
        for (String temp : temps) {
            numbers.add(Integer.parseInt(temp));
        }

        return numbers;
    }
}
