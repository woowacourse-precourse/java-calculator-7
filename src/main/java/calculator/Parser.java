package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Parser {

    /**
     * 문자열에서 기본 구분자(쉼표, 콜론) 및 1개 이상의 커스텀 구분자를 사용하여 숫자를 추출합니다.
     *
     * @param customSeparators 커스텀 구분자를 포함한 문자열 (예: "-_'][,:.;").
     * @param inputToExtract 구분자로 분리된 숫자가 포함된 입력 문자열 (예: "1-2,3_4'5").
     * @return 추출된 숫자 리스트를 반환합니다.
     */
    public List<Double> extractNumbersWithSeparator(String customSeparators, String inputToExtract) {
        List<Double> numbers = new ArrayList<>();

        // 각 구분자의 이스케이프 문자 처리
        // Pattern.quote()를 사용하여 메타문자를 안전하게 사용하도록 처리
        String escapedSeparators = Pattern.quote(customSeparators);

        // 기본 구분자 (쉼표, 콜론)와 커스텀 구분자를 정규식에 추가
        // 쉼표, 콜론과 이스케이프된 커스텀 구분자들을 구분자로 처리
        String regex = "[,:" + escapedSeparators + "]";

        // 정규식을 사용하여 입력 문자열을 구분자를 기준으로 분리
        String[] splitInputToExtract = inputToExtract.split(regex);

        // 분리된 각 부분을 순회하며 숫자로 변환하여 리스트에 추가
        for (String part : splitInputToExtract) {
            // 빈 문자열을 처리하지 않고, 숫자 형식으로 변환하여 리스트에 추가
            numbers.add(Double.parseDouble(part));
        }

        // 추출된 숫자 리스트 반환
        return numbers;
    }

    /**
     * 문자열에서 기본 구분자(쉼표, 콜론)를 사용하여 숫자를 추출합니다.
     *
     * @param inputToExtract 구분자로 분리된 숫자가 포함된 입력 문자열 (예: "1:2,3:4:5").
     * @return 추출된 숫자 리스트를 반환합니다.
     */

    public List<Double> extractNumbersWithSeparator(String inputToExtract) {
        List<Double> numbers = new ArrayList<>();

        String regex = "[,:]";

        // 정규식을 사용하여 입력 문자열을 구분자를 기준으로 분리
        String[] splitInputToExtract = inputToExtract.split(regex);

        // 분리된 각 부분을 순회하며 숫자로 변환하여 리스트에 추가
        for (String part : splitInputToExtract) {
            // 빈 문자열을 처리하지 않고, 숫자 형식으로 변환하여 리스트에 추가
            numbers.add(Double.parseDouble(part));
        }

        // 추출된 숫자 리스트 반환
        return numbers;
    }


}

