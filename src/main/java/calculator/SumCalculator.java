package calculator;

public class SumCalculator {
    public static int add(String input) {
        // 빈 문자열은 0을 반환
        if (input.isEmpty()) {
            return 0;
        }

        String customDelimiter = ",";
        String numbersPart = input;

        // 커스텀 구분자 사용 여부 확인
        if (input.startsWith("//")) {
            // "\\n" 기준으로 구분
            String[] parts = input.split("\\\\n", 2); // "\\n" 문자열로 분리
            customDelimiter = parts[0].substring(2); // 커스텀 구분자 추출
            numbersPart = parts[1]; // 숫자 부분 추출
        }

        // 기본 구분자와 커스텀 구분자를 결합하여 정규 표현식 생성
        String regex = "[" + customDelimiter + ",:]"; // 커스텀 구분자와 기본 구분자(쉼표, 콜론) 결합
        String[] tokens = numbersPart.split(regex); // 숫자 분리

        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) { // 빈 문자열 제외
                sum += Integer.parseInt(token); // 문자열을 정수로 변환 후 합산
            }
        }
        return sum; // 최종 합계 반환
    }
}
