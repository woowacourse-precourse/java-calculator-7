package calculator;

import java.util.ArrayList;
import java.util.List;

public class DelimiterService {
    private List<String> delimiters = new ArrayList<>();
    private String input;

    //Generator: 기본 구분자 추가
    public DelimiterService(String input) {
        this.input = input;
        delimiters.add(",");
        delimiters.add(":");
    }

    //isDelimStarting(): true일 때 커스텀 구별자가 모두 끝난 것
    protected boolean isDelimStarting(){
        return input.startsWith("//");
    }

    //addDelimiter(): 문자열에서 커스텀 구분자를 분리 -> 구분자 리스트에 추가, userInput 잘라서 초기화
    protected void addDelimiter(){
        int endDelimIndex = input.indexOf("\\n");

        // "\\n"을 찾지 못했을 때 예외 처리
        if (endDelimIndex == -1) {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. \\n이 누락되었습니다.");
        }

        String customDelimiter = input.substring(2, endDelimIndex);

        // 구분자가 숫자일 때 예외처리
        if(isNumberic(customDelimiter)){
            throw new IllegalArgumentException("잘못된 구분자 형식입니다. 숫자는 구분자가 될 수 없습니다.");
        }

        delimiters.add(customDelimiter);
        input = input.substring(endDelimIndex + 2);
    }

    //replacePattern(): 정규식 패턴 문자가 구분자로 입력될 때 backslash 더함
    protected void replacePattern() {
        delimiters.replaceAll(delim -> {
            String patterns = "\\ ( [ { ^ $ . * + ? | ₩ x X";

            if (patterns.contains(delim)) {
                return "\\" + delim;
            }
            return delim;
        });
    }

    //getDelimiters(): 구분자 List를 정규식 형태의 하나의 문자열로 바꾼다
    protected String getDelimiters() {
        StringBuilder delimiterRegex = new StringBuilder();

        for (String delimiter : delimiters) {
            delimiterRegex.append(delimiter).append("|");
        }

        // 마지막 추가된 |를 제거
        delimiterRegex.deleteCharAt(delimiterRegex.length() - 1);

        return delimiterRegex.toString();
    }

    //getInput(): 숫자만 남은 문자열을 반환
    protected String getInput() {
        return input.trim();
    }

    //isNumberic(): 구분자 중 숫자가 있는지 확인 - addDelimiter()에서 사용
    private boolean isNumberic(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}

