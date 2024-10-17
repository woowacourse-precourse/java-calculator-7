package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Logic {
    // 구분자 리스트 선언
    private final ArrayList<Character> delimiter = new ArrayList<>(Arrays.asList(',', ':'));

    // 문자열에 커스텀 구분자를 갖고 있는지 확인
    public boolean hasCustomDelimiter(String str) {
        if (str.startsWith("//")) { // 커스텀 구분자일 경우
            if (str.charAt(3) != '\\' || str.charAt(4) != 'n') { // 커스텀 구분자 형식에 안맞을 경우 exception
                throw new IllegalArgumentException();
            }
            delimiter.add(str.charAt(2)); // 구분자 리스트에 커스텀 구분자 추가
            return true;
        }
        return false;
    }

    // 해당 인덱스부터 숫자를 추출
    public int getNum(String str, int idx) {
        int num = 0;

        while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
            num *= 10;
            num += str.charAt(idx) - '0';
            idx++;
        }

        return num;
    }

    // 주어진 문자열 요구사항에 맞게 계산
    public int calculate(String str) {
        int result = 0, i = -1;

        if (hasCustomDelimiter(str)) {
            i = 4;
        }

        while (++i < str.length()) {
            char c = str.charAt(i);

            if (Character.isDigit(c)) { // 숫자일 경우 추출해서 result에 더함
                result += getNum(str, i);
            } else if (delimiter.contains(c)) { // 구분자일 경우 continue
                continue;
            } else { // 다른 문자일 경우 exception
                throw new IllegalArgumentException();
            }
        }

        return result;
    }
}
