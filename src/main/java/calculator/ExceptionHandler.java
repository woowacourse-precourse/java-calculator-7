package calculator;

import java.util.List;

public class ExceptionHandler {
    private static ExceptionHandler instance;

    private ExceptionHandler() {
    }

    public static ExceptionHandler getInstance() {
        if (instance == null) {
            instance = new ExceptionHandler();
        }
        return instance;
    }

    public void checkIncorrectDelimGenerateInput(char elem) {
        if (elem != '/' && elem != 'n' && elem != '\\') {
            throw new IllegalArgumentException(
                    "지정된 구분자인 쉼표와 콜론, 양의 정수, 커스텀 구분자를 지정하기 위한 슬래시와 역슬래시 그리고 n 이외에는 입력하실 수 없습니다.");
        }
    }

    public void checkIncorrectInputWithoutCustomDelim(char[] elems) {
        for (char elem : elems) {
            if (elem != ',' && elem != ':' && elem != '-' && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(
                        "지정된 구분자인 쉼표와 콜론, 양의 정수, 커스텀 구분자를 지정하기 위한 슬래시와 역슬래시 그리고 n 이외에는 입력하실 수 없습니다.");
            }
        }
    }

    public void checkIncorrectInputWithCustomDelim(char[] elems, char customDelim) {
        for (char elem : elems) {
            if (elem != ',' && elem != ':' && elem != customDelim && elem != '-' && !Character.isDigit(elem)) {
                throw new IllegalArgumentException(
                        "지정된 구분자인 쉼표와 콜론, 양의 정수, 커스텀 구분자를 지정하기 위한 슬래시와 역슬래시 그리고 n 이외에는 입력하실 수 없습니다.");
            }
        }
    }

    public void checkIncorrectDelim(char delim) {
        if (delim == ',' || delim == ':') {
            throw new IllegalArgumentException("기본 구분자는 커스텀 구분자로 설정할 수 없습니다.");
        }
    }

    public void detectNonDigitElem(List<String> splitElems) {
        for (String elem : splitElems) {
            try {
                Integer.parseInt(elem);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 사이에는 양의 정수만 입력할 수 있습니다.");
            }
        }
    }

    public void checkZeroAndNegativeDigit(List<Integer> nums) {
        for (int num : nums) {
            if (num <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다! 양수만 입력해주세요.");
            }
        }
    }
}
