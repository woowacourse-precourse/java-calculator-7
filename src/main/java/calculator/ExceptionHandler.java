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

    public void checkIncorrectInput(char[] elems, char customDelim) {
        for (char elem : elems) {
            if (elem != ',' && elem != ':' && elem != customDelim && !Character.isDigit(elem)) {
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
}
