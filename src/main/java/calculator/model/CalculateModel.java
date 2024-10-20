package calculator.model;

public class CalculateModel {

    // 기본 구분자
    private static final String DEFAULT_DELIMITERS = ",|:";

    // 덧셈 계산 메소드
    public int add(String input) {
        if (input == null || input.isEmpty()) return 0; // 입력이 비어있는 경우 0 반환

        String delimiters = DEFAULT_DELIMITERS;
        // 커스텀 구분자 확인
        if (input.startsWith("//") && input.contains("\\n")) {
            // 커스텀 구분자 추출
            delimiters += "|" + input.charAt(2);
            input = input.substring(5);
        } else {
            // 형식 검증: "//" 이후에 커스텀 구분자가 오고, 그 뒤에 "\n"이 있는지 확인
            if (!input.matches("//.\\n.*")) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. 올바른 형식은 //구분자\\n 입니다.");
            }
        }

        return sum(input.split(delimiters)); // 숫자를 구분자로 분리 후 덧셈
    }

    // 숫자를 모두 더하는 메소드
    private int sum(String[] numbArr) {
        int result = 0;
        for (String num : numbArr) {
            int n;
            try {
                n = Integer.parseInt(num);
                if (n < 0) throw new IllegalArgumentException("음수는 입력할 수 없습니다."); // 음수 예외처리
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다.");
            }

            result += n;
        }
        return result;
    }
}
