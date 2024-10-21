package calculator.service;

public class StringCalculatorServiceImpl implements StringCalculatorService {
    /**
     * 주어진 문자열에서 쉼표(,) 또는 콜론(:)을 구분자로 사용하거나, 커스텀 구분자를 지정하여 숫자들을 추출하고 합을 반환합니다. 입력이 null이거나 빈 문자열일 경우 0을 반환합니다.
     *
     * @param input 입력된 문자열
     * @return 숫자들의 합
     */
    @Override
    public int add(String input) {
        // 입력이 null 이거나 빈 문자열인 경우, 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        // 커스텀 구분자가 있는 경우 "//[구분자]\n" 형식을 처리
        if (input.startsWith("//")) {
            int idx = input.indexOf("\n");
            String customDelimiter = input.substring(2, idx);

            // 정규 표현식에서 특수문자 이스케이프 처리
            customDelimiter = escapeSpecialRegexCharacters(customDelimiter);
            
            delimiter += "|" + customDelimiter;
            input = input.substring(idx + 1); // "\n" 이후 부터 입력으로 저장
        }

        // 쉽표(,)와 콜론(:)을 기본 구분자로 사용하여 문자열을 분리
        String[] tokens = input.split(delimiter);

        int total = 0; // 덧셈한 결과를 저장하는 변수를 초기화

        for (String token : tokens) {
            // 공백이 있을 수 있으므로 trim()을 이용해 제거
            token = token.trim();
            // 빈 문자열이 아닌지 확인 후, 숫자로 변환
            if (!token.isEmpty()) {
                total += Integer.parseInt(token); // 빈 문자열이 아닌 경우만 합산
            }
        }

        return total;
    }

    // 정규 표현식에서 특수문자를 이스케이프 처리하는 메서드
    private String escapeSpecialRegexCharacters(String delimiter) {
        String[] specialCharacters = {"\\", "^", "$", ".", "|", "?", "*", "+", "(", ")", "[", "]", "{", "}"};

        for (String specialChar : specialCharacters) {
            if (delimiter.contains(specialChar)) {
                delimiter = delimiter.replace(specialChar, "\\" + specialChar); // 특수문자 앞에 백슬래시 추가
            }
        }
        return delimiter;
    }
}
