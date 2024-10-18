package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterProcess {
    private List<String> delimiters = new ArrayList<>();
    private String userInput;
    private boolean numberStarting;

    //Generator: 기본 구분자 추가
    public DelimiterProcess(String userInput) {
        this.userInput = userInput;
        delimiters.add(",");
        delimiters.add(":");
    }

    //isNumberString(): true일 때 커스텀 구별자가 모두 끝난 것
    private void isNumberStarting(){
        if(userInput.startsWith("//")){
            numberStarting = false;
        } else {
            numberStarting = true;
        }
    }

    //addDelimiter(): 문자열에서 커스텀 구분자를 분리 -> 구분자 리스트에 추가
    private void addDelimiter(){
        if (userInput.startsWith("//")) {
            int endDelimIndex = userInput.indexOf("\\n");

            if (endDelimIndex == -1) {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다. \\n이 누락되었습니다.");
            }

            String customDelimiter = userInput.substring(2, endDelimIndex);
            delimiters.add(customDelimiter);
            userInput = userInput.substring(endDelimIndex + 2);
        }
    }

    //getDelimiter(): 커스텀 구별자가 없을 때까지 반복 -> 숫자와 구별자만 남은 문자열을 반환
    private String getNewUserInput(){
        isNumberStarting();
        if (numberStarting) {
            return userInput;
        }

        while (!numberStarting) {
            addDelimiter();
        }
        return userInput;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getUserInput() {
        return userInput;
    }
}
