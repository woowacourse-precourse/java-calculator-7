package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public static void main(String[] args) {
        System.out.println(inputMessage);

        String input = readLine();

        DividersAndNumberSequence dividersAndNumberSequence = getDividersAndNumberSequence(input);
    }

    public static DividersAndNumberSequence getDividersAndNumberSequence(String input) {
        String[] inputByEndSign = input.split(SignAndDivider.endSign);
        int customSignLength = inputByEndSign.length - 1;

        String numberSequence = inputByEndSign[customSignLength];
        List<String> dividers = addDefaultDivider();

        for (int i = 0; i < customSignLength; i++) {
            String token = inputByEndSign[i];

            if (isValidCustomDivider(token)) {
                dividers.add(token.substring(2));
            }
        }

        return new DividersAndNumberSequence(dividers, numberSequence);
    }

    public static List<String> addDefaultDivider() {
        List<String> dividers = new ArrayList<>();

        dividers.add(SignAndDivider.defaultDivider1);
        dividers.add(SignAndDivider.defaultDivider2);

        return dividers;
    }

    public static boolean isValidCustomDivider(String token) {
        String tokenWithoutStartSign = token.substring(2);
        boolean isValid = token.startsWith("//") && !tokenWithoutStartSign.contains(SignAndDivider.startSign)
                && !tokenWithoutStartSign.matches("[0-9]");

        if (!isValid) {
            throw new IllegalArgumentException();
        }

        return true;
    }

}

