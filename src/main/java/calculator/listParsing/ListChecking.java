package calculator.listParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ListChecking {
    public String checklist;
    public List<String> delimiters = new ArrayList<>();   //구분자는 최대 3개
    public String delimiter;
    public String numbers;

/*    private ListChecking() {
    }*/

    public void checkDelimeter(String input) {
        this.checklist = input;
        String cult = this.checklist;
        char[] charArray = cult.toCharArray();
        delimiters.add(":");
        delimiters.add(",");

        if (checklist == null || checklist.isEmpty()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }

        if (checklist.startsWith("//")) {
            if (charArray[3] == '\\' && charArray[4] == 'n') {          //split이 작동을 안함
                delimiters.add(String.valueOf(charArray[2]));
                numbers = String.valueOf(charArray, 5, charArray.length - 5);
//                delimiter = Pattern.quote(parts[0].substring(2));  // 커스텀 구분자 추출
//                numbers = parts[1];  // 숫자 부분 추출
            } else {
                throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
            }
        } else if (Character.isDigit(checklist.charAt(0))) {
            numbers = input;  // 커스텀 구분자가 없으면 입력 그대로 숫자로 처리
        } else {
            throw new IllegalArgumentException("잘못된 구분자 형식입니다.");
        }
    }
}
