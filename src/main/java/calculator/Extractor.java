package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {

    /**
     * 문자열에서 기본 구분자(쉼표, 콜론) 및 1개 이상의 커스텀 구분자를 추출합니다.
     *
     * @param input 사용자가 입력한 모든 문자열
     * @return 추출된 커스텀 구분자를 나타내는 문자열을 반환합니다.
     */
    public String extractOptionField(String input) {

        // 정규식 패턴: "//{문자}\n" 형식으로 시작하는 패턴에서 문자를 추출
        String regex = "^//.*?\\n";

        // Pattern과 Matcher 객체 생성
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // 패턴이 일치할 경우 첫 번째 그룹(구분자)을 반환
        if (matcher.find()) {
            return matcher.group(0);  // 첫 번째 그룹은 정규식에서 (.)로 매칭된 부분
        } else {
            return null;  // 구분자가 없는 경우
        }
    }

    /**
     * 문자열에서 숫자를 추출할 문자열(target)를 추출합니다.
     *
     * @param input 사용자가 입력한 모든 문자열
     * @return 숫자를 추출할 문자열을 반환합니다.
     */
    public String extractTargetField(String input) {
        if (input.startsWith("//")) {
            int firstIndex = input.indexOf("\n");
            if (firstIndex != -1) {
                return input.substring(firstIndex + 1);
            }
        }

        return input;
    }



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
