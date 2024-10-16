package calculator.model;

import java.util.ArrayList;

public class Delimiter {
    private String inputString;
    private ArrayList<String> delimiterList = new ArrayList<>();
    private String customDelimiter;

    public Delimiter(String inputString) {
        this.inputString = inputString;
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public void setCustomDelimiter() {
        int delimiterEndIndex = inputString.indexOf("\n");
        customDelimiter = inputString.substring(2, delimiterEndIndex);

        // 구분자가 한 글자를 초과하는 경우 예외 발생
        if (customDelimiter.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자는 한 글자만 허용됩니다");
        }
        // 구분자가 공백인 경우 예외 발생
        else if (customDelimiter.equals("")) {
            throw new IllegalArgumentException("커스텀 구분자는 공백이 허용되지 않습니다.");
        }

        delimiterList.add(customDelimiter);
        inputString = inputString.substring(delimiterEndIndex + 1);
    }

    // Controller 에서 Delimiter 객체 생성 후 사용 (커스텀 구분자 존재 여부 확인)
    public void checkCustomDelimiter() {
        if(inputString.startsWith("//")) {
            setCustomDelimiter();
        }
    }

    public String[] splitString() {
        String delimiterRegex = String.join("|", delimiterList); // ",|:|customDeli"
        return inputString.split(delimiterRegex);
    }
}
