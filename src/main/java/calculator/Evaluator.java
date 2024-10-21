package calculator;

import java.util.List;

public class Evaluator {
    private long result;

    public Evaluator() {
        this.result = 0L;
    }

    public void getResult(String formula, List<Character> separators) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            //입력 문자열의 i번째 위치가 숫자인 경우
            if (checkNum(ch)) {
                sb.append(ch);
            }
            //입력 문자열의 i번째 위치가 구분자인 경우
            else if (separators.contains(ch)) {
                result += makeNum(sb);
                sb.delete(0, sb.length());
            }
            //입력 문자열의 i번째 위치가 숫자 또는 구분자가 아닌 경우
            else {
                throw new IllegalArgumentException("선언되지 않은 구분자가 입력되었습니다.");
            }
        }
        result += makeNum(sb);
        System.out.println("결과 : " + result);
    }

    /**
     * 매개변수 character가 0-9 사이의 숫자인지 확인
     * @param ch
     * @return
     */
    private boolean checkNum(char ch) {
        return ch >= 48 && ch <= 57;
    }

    /**
     * 매개변수로 받은 문자열을 long 타입으로 변환
     * @param sb
     * @return
     */
    private long makeNum(StringBuilder sb) {
        try {
            return Long.parseLong(sb.toString());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 문자열에 수가 포함되지 않았거나 너무 큽니다.");
        }
    }
}
