package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import calculator.messages.ErrorMessages;

public class Separator {
    // 기본 구분자인 쉼표(,)와 콜론(:)을 포함하는 구분자 리스트 생성
    private List<String> separators = new ArrayList<>(List.of(",", ":"));

    // 문자를 새로운 구분자로 추가
    public void addSeperator(String separator) {
        if (this.separators.contains(separator)) {
            throw new IllegalArgumentException(ErrorMessages.EXIST_SEPARTOR.getMessage());
        }
        this.separators.add(separator);
    }
    
    // 외부에 구분자들을 전달하는 getter 메서드
    public List<String> getSeparators() {
        return this.separators;
    }

    // 추출한 구분자들을 정규표현식 형태로 변경
    public String getSeparatorsRegex(){
        return "["+this.separators.stream()
                .collect(Collectors.joining("|"))+"]";
    }
}
