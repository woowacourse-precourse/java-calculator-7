package calculator;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputParser {

    public static ArrayList<Integer> parseInput(String input) {
        String delimiters = ",;";

        if(input.contains("//")) {
            int endIndex = input.indexOf("\\n");
            delimiters = input.substring(2,endIndex);
            input = input.replace("//"+delimiters+"\\n", "");
        }

        StringTokenizer st = new StringTokenizer(input, delimiters);
        ArrayList<Integer> parsedInput = new ArrayList<>();

        while(st.hasMoreTokens()) {
            parsedInput.add(Integer.parseInt(st.nextToken()));
        }

        return parsedInput;
    }

}
