package calculator.vaildator;

public class SeparatorHandler {

    // 사용자 지정 구분자를 추출하는 메서드
    public char getCustomSeparator(String input) {
        // 구분자가 두 글자 이상이면 예외 발생
        if (input.matches("//.{2,}\\\\n.*")) {
            throw new IllegalArgumentException("2개 이상의 구분자가 들어왔습니다.");
        }

        // 정규식으로 //로 시작하고 \n으로 끝나는 패턴 확인
        if (input.matches("//.{1}\\\\n.*")) { // 1글자의 구분자를 허용
            char separator = input.charAt(2);

            validateSeparator(separator);
            return separator;
        }

        // 사용자 정의 구분자가 없으면 기본 구분자 반환
        return 0; // 기본 구분자
    }

    // 입력 문자열을 구분자 기준으로 분리하는 메서드
    public String[] splitInput(String input, char separator) {
        // 사용자 정의 구분자가 있을 경우
        if (separator != 0) {
            input = input.substring( 5); // 사용자 지정 구분자를 제외한 나머지 문자열
            return splitByCustomSeparator(input, separator);
        }

        // 기본 구분자 ','와 ':'로 분리
        return splitByDefaultSeparators(input);
    }

    // 사용자 정의 구분자로 분리하는 메서드
    private String[] splitByCustomSeparator(String input, char separator) {
        return input.split("[" + separator + ",:]");
    }

    // 기본 구분자 ','와 ':'로 분리하는 메서드
    private String[] splitByDefaultSeparators(String input) {
        return input.split("[,:]");
    }

    // 구분자 유효성을 검증하는 메서드
    private void validateSeparator(char separator) {
        if (separator == ',' || separator == ':') {
            throw new IllegalArgumentException("기본 구분자입니다.");
        }
        if (Character.isDigit(separator)) {
            throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
        }
    }
}
