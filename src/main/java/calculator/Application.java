package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";
    public static final String outputMessage = "결과 : ";

    public static void main(String[] args) {
        System.out.println(inputMessage);

        String input = readLine().trim();
        int sum = 0;

        if(!input.isEmpty()) {
            DividersAndNumberSequence dividersAndNumberSequence = getDividersAndNumberSequence(input);
            dividersAndNumberSequence.updateNumberSequence();
            List<Integer> numberList = getNumberList(dividersAndNumberSequence.getNumberSequence());
            sum = sumNumber(numberList);
        }

        System.out.println(outputMessage + sum);
    }

    public static DividersAndNumberSequence getDividersAndNumberSequence(String input) {
        String[] inputByEndSign = input.split(SignAndDivider.endSign);
        int customSignLength = inputByEndSign.length - 1;

        String numberSequence = "0";
        List<String> dividers = addDefaultDivider();

        for (int i = 0; i <= customSignLength; i++) {
            String token = inputByEndSign[i];

            // 커스텀 구분자는 설정하고 숫자는 안 작성했을 경우를 대비
            if(i == customSignLength && Character.isDigit(token.charAt(0))) {
                numberSequence = token;
                break;
            }

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
        if (token.length() < 2) {
            throw new IllegalArgumentException();
        }

        String tokenWithoutStartSign = token.substring(2);
        boolean isValid = token.startsWith("//") && !tokenWithoutStartSign.contains(SignAndDivider.startSign)
                && tokenWithoutStartSign.matches("[^0-9]*");

        if (!isValid) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static List<Integer> getNumberList (String numberSequence) {
        String[] numberByDefaultDivider1 = numberSequence.split(SignAndDivider.defaultDivider1);
        List<Integer> numberList = new ArrayList<>();

        for (String token : numberByDefaultDivider1) {
            if (isValidFormatNumber(token)) {
                numberList.add(Integer.parseInt(token));
            }
        }

        return numberList;
    }

    public static boolean isValidFormatNumber(String token) {
        boolean isValid = token.matches("\\d+") && !token.startsWith("-");

        if (isValid) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    public static int sumNumber(List<Integer> numberList) {
        int sum = 0;

        for (int number : numberList) {
            sum += number;
        }

        return sum;
    }
}

