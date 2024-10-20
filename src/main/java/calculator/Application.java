package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    // 커스텀 구분자를 지정한 문자열의 패턴
    private final String CUSTOM_SEPARATOR_PATTERN = "^//.\\\\n.*";


    private final Integer CUSTOM_SEPARATOR_POS = 2;
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

    private void isValidString() {
        hasCustomSeparator();
        isValidCustomSeparator();
        for (int i = getStartIndex(); i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                continue;
            }
            isRegisteredSeparator(inputString.charAt(i));
        }
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
    private void isRegisteredSeparator(Character separator) {
        for (Character registeredSeparator : DEFAULT_SEPARATOR_LIST) {
            if (registeredSeparator == separator) {
                return;
            }
        }
        if (separator != customSeparator) {
            throw new IllegalArgumentException();
        }
    }

    // 커스텀 구분자가 숫자이면 예외처리
    private void isValidCustomSeparator() {
        if (Character.isDigit(customSeparator)) {
            throw new IllegalArgumentException();
        }
    }

    // 시작 위치를 찾아 반환한다.
    private Integer getStartIndex() {
        if (startIndex != null) {
            return startIndex;
        }
        return startIndex = (hasCustomSeparator() ? 5 : 0);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Application calculator = new Application(Console.readLine());
        System.out.println("결과 : " + calculator.calculate());
    }
}
