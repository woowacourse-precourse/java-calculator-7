package calculator.service;

import calculator.exception.Exceptions;
import calculator.model.InputString;
import calculator.model.ResultNumbers;

import java.util.Arrays;
import java.util.List;

public class MainService {

    Exceptions exceptions = new Exceptions();
    private InputString inputString;
    private ResultNumbers resultNumbers;

    public String getCustomDelimiter(InputString inputString) {

        String input = inputString.getInputString();

        exceptions.validateCustomDelimiterSize(inputString.getCustomDelimiter().size());

        if (input.startsWith("//")) { //
            int customLastMark = input.indexOf("\\n"); // //로 시작하지만 \n가 없다면 -1 출력 있다면 해당 인덱스값 반환
            if (customLastMark != -1) {

                String customDelimiter = input.substring(2, customLastMark); // 자르기
                inputString.addCustomDelimiter(customDelimiter);

                String refiendString = input.substring(customLastMark + 2);
                inputString.setInputString(refiendString);

                return getCustomDelimiter(inputString);

            }
        }
        return input;
    }

    public void extractSlashFromString(InputString inputString) {
        if (inputString.getInputString().startsWith("/")) {
            String refinedString = inputString.getInputString().replaceFirst("^/+", "");
            inputString.setInputString(refinedString);
        }
    }

    public void extractNumbersFromString(InputString input, ResultNumbers resultNumbers) {

        List<String> customDelimiter = input.getCustomDelimiter();

        StringBuilder defaultRegex = new StringBuilder("[,|:]");

        if (!customDelimiter.isEmpty()) {
            for (String delimiter : customDelimiter) {
                defaultRegex.append("|").append(delimiter);
            }
        }

        String[] numberList = input.getInputString().split(defaultRegex.toString());

        // 문자열 예외처리는 여기에 추가해야할듯?

        for(String num : numberList) {
            resultNumbers.addNumberList(Integer.parseInt(num));
        }

    }


}
