package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

    // 구분자 확인
    public static int add(String input) {
        if (input.isEmpty()) {  // 공벡이면 0 반환
            return 0;
        }

        // 기본 구분자
        String delimiters = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int endIndex = input.indexOf("\\n");
            if (endIndex == -1) {  // \n이 없으면
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            String customDelimiter = input.substring(2, endIndex);
            delimiters += "|" + specialSymbols(customDelimiter);
            input = input.substring(endIndex + 2); // 커스텀 구분자 이후의 문자열
        }

        String[] sentence = input.split(delimiters);
        return addNumbers(sentence);
    }
}