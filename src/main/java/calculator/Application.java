package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    // 커스텀 구분자를 지정한 문자열의 패턴
    private final String CUSTOM_SEPARATOR_PATTERN = "^//.\\\\n.*";
    // 기본 구분자 리스트
    private final List<Character> DEFAULT_SEPARATOR_LIST = List.of(':', ',');
    // 커스텀 구분자
    private Character customSeparator = ':';
    // 사용자에게 입력받은 문자열
    private String inputString = "0";
    // 커스텀 구분자 사용 유무를 판단하는 플래그
    private Boolean usingCustomSeparatorFlag = null;
    // 시작 위치 정보
    private Integer startIndex = null;

    private List<Integer> numbersList = null;

    Application(String inputString) {
        if (!inputString.isEmpty()) {
            this.inputString = inputString;
        }
        initialize();
    }


    public Integer calculate() {
        return 0;
    }

    private void initialize() {

    }

    // 커스텀 구분자를 지정한 문자열이면 true, 아니라면 false를 반환해준다.
    private Boolean hasCustomSeparator() {
        if (usingCustomSeparatorFlag != null) {
            return usingCustomSeparatorFlag;
        }
        return usingCustomSeparatorFlag = inputString.matches(CUSTOM_SEPARATOR_PATTERN);
    }

    // 기본 구분자 리스트에 등록되어있는 구분자인지 검사하고 맞다면 true를 반환한다.
    // 기본 구분자 리스트에 없는 구분자이면 커스텀 구분자인지 결과를 반환한다.
    private Boolean isRegisteredSeparator(Character separator) {
        for (Character registeredSeparator : DEFAULT_SEPARATOR_LIST) {
            if (registeredSeparator == separator) {
                return true;
            }
        }
        return (separator == customSeparator);
    }

    private Boolean isValidCustomSeparator() {
        return !Character.isDigit(customSeparator);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Application calculator = new Application(Console.readLine());
        System.out.println("결과 : " + calculator.calculate());
    }
}
