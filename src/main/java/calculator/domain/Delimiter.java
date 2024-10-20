package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import calculator.messages.ErrorMessages;

public class Delimiter {
    // 기본 구분자인 쉼표(,)와 콜론(:)을 포함하는 구분자 리스트 생성
    private List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    // 문자를 새로운 구분자로 추가
    public void addDelimiter(String delimiter) {
        // 생성자 호출시 파라미터 검증 후에 필드를 초기화
        validateDelimiter(delimiter);
        this.delimiters.add(delimiter);
    }

    // 추출한 구분자들을 정규표현식 형태로 변경
    public String getDelimitersRegex() {
        return "[" + this.delimiters.stream()
                .collect(Collectors.joining("")) + "]";
    }

    // 이미 존재하는 구분자를 커스텀 구분자로 입력한 경우 예외 처리
    private void validateDelimiter(String delimiter) {
        if (this.delimiters.contains(delimiter)) {
            throw new IllegalArgumentException(ErrorMessages.EXIST_SEPARTOR.getMessage());
        }
    }
}
