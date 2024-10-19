package calculator.service;

import calculator.dto.DelimiterInputDto;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public String calculateSumFormString(DelimiterInputDto delimiterInputDto) {

        setDelimiter(delimiterInputDto);
        List<String> numbers = parseNumber(delimiterInputDto);

        return delimiterInputDto.getInputString();
    }

    public void setDelimiter(DelimiterInputDto delimiterInputDto) {
        if (isCustomDelimiter(delimiterInputDto.getInputString())) {
            String customDelimiter = parseCustomDelimiter(delimiterInputDto.getInputString());
            validCustomDelimiter(customDelimiter);
            delimiterInputDto.addDelimiter(customDelimiter);
            updateInputString(delimiterInputDto);
        }
    }

    public boolean isCustomDelimiter(String inputString) {
        return inputString.startsWith("//") && inputString.contains("\n");
    }

    public String parseCustomDelimiter(String inputString) {
        return inputString.substring(2, inputString.indexOf("\n"));
    }

    public void updateInputString(DelimiterInputDto delimiterInputDto) {
        String inputString = delimiterInputDto.getInputString();
        delimiterInputDto.setInputString(inputString.substring(inputString.indexOf("\n") + 1));
    }

    public List<String> parseNumber(DelimiterInputDto delimiterInputDto) {
        return Arrays.stream(delimiterInputDto.getInputString()
                .split(formatDelimiters(delimiterInputDto.getDelimiters()))).toList();
    }

    public String formatDelimiters(List<String> delimiters) {
        return "[" + String.join("", delimiters) + "]";
    }

    public void validCustomDelimiter(String delimiter) {
        checkDelimiterLength(delimiter);
        checkDelimiterIsNumber(delimiter);
        checkDelimiterPlusMinus(delimiter);
    }

    public void checkDelimiterLength(String delimiter) {
        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
        }
    }

    public void checkDelimiterIsNumber(String delimiter) {
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("구분자는 숫자일 수 없습니다.");
        }
    }

    public void checkDelimiterPlusMinus(String delimiter) {
        if (delimiter.equals("+") || delimiter.equals("-")) {
            throw new IllegalArgumentException("구분자는 +, - 가 될 수 없습니다.");
        }
    }
}
