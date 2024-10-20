package calculator.service;

import static calculator.util.extractDelimiters.extractDelimiters;
import static calculator.util.extractNumbersPart.extractNumbersPart;

import java.util.List;

public class SumService {

    // 입력 문자열을 받아 합연산을 수행
    public int calculateSum(String input) {
        List<String> delimiters = extractDelimiters(input);
        String numbersPart = extractNumbersPart(input);
        String[] tokens = splitByDelimiters(numbersPart, delimiters);

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                sum += Integer.parseInt(token.trim());
            }
        }

        return sum;
    }

    // 구분자로 문자열을 분리
    private String[] splitByDelimiters(String input, List<String> delimiters) {
        String result = input;
        for (String delimiter : delimiters) {
            result = result.replace(delimiter, ","); // 구분자를 ','로 대체
        }
        return result.split(","); // ','를 기준으로 분리
    }
}