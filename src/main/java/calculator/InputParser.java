package calculator;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputParser {

    public static ArrayList<Integer> parseInput(String input) {
        StringTokenizer st = new StringTokenizer(input, ",:");
        ArrayList<Integer> parsedInput = new ArrayList<>();

        while(st.hasMoreTokens()) {
            parsedInput.add(Integer.parseInt(st.nextToken()));
        }

        return parsedInput;

    }

}
