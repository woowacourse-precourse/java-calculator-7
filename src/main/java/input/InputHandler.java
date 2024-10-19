package input;

import calculator.Calculator;
import camp.nextstep.edu.missionutils.Console;
import error.ErrorHandler;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String inputString;
    private String customSeparator = null;

    private Vector<Integer> extractedNumbers = new Vector<>();


    public void setInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        this.inputString = Console.readLine();
    }

    public void ensureCustomSeparator() {
        String regExp = "^//(.)\\\\n";
        Pattern pattern = Pattern.compile(regExp);

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            String capturedText = matcher.group(1);
            customSeparator = capturedText;
        }

    }


    public void extractNumbers() {
        String target = inputString;
        String regExp = "[" + customSeparator + ",:]+";

        // 커스텀 구분자 추가 하는 부분 제거.
        if (customSeparator != null) {
            String targetToDelete = "^//" + customSeparator + "\\\\n";
            target = target.replaceFirst(targetToDelete, "");
        }

        String[] extractedStrings = target.split(regExp);
        ErrorHandler.validateExtractedNumbers(extractedStrings);

        for (String extractedString : extractedStrings) {
            int extractedNumber = Integer.parseInt(extractedString);
            extractedNumbers.add(extractedNumber);
        }
    }

    public void printResult() {
        Calculator calculator = new Calculator();
        int result = calculator.getSum(extractedNumbers);

        System.out.println("결과 : " + result);
    }

}
