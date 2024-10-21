package calculator;

import java.util.ArrayList;
import java.util.List;


class Calculator {

    private List<Character> separators;
    private String input;
    private int result;

    final static int CUSTOM_START_IDX = 0;
    final static int CUSTOM_END_IDX = 3;
    final static int CUSTOM_IDX = 2;

    Calculator(String s) {
        separators = new ArrayList<Character>();
        separators.add(',');
        separators.add(':');
        input = s;
    }

    int add() {
        //첫글자가 숫자면 일반 구분자만 사용하는 케이스
        checkInputHaveCustom();
        return addBySeperaters(separators);
    }

    private int addBySeperaters(List<Character> separators) {
        String num = "";
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            num = checkBySeperator(separators, c, num);
        }
        //마지막에 num이 차있다면 더하기
        if (!num.isEmpty()) {
            result += Integer.parseInt(num);
            return result;
        }
        throw new IllegalArgumentException();
    }

    private String checkBySeperator(List<Character> separators, Character c, String num) {
        if (separators.contains(c)) {
            //num이 차있는지 확인
            if (num.isEmpty()) {
                throw new IllegalArgumentException();
            }
            //이전까지 쌓인 모든 num을 결과에 더함
            result += Integer.parseInt(num);
            num = "";
        }
        //숫자를 만나는 경우
        else if (isItNum(c)) {
            num += c;
        } else {
            throw new IllegalArgumentException();
        }
        return num;
    }

    private void checkInputHaveCustom() {
        //1.커스텀 사용 여부 확인
        //커스텀 문자는 `//(커스텀)\n으로 이루어져 있음`
        //예외상황:커스텀 문자에 숫자가 들어갈 수 없음
        int custom_idx_start = input.indexOf("//");
        int custom_idx_end = input.indexOf("\\n");
        if (haveCustomOperator(custom_idx_start, custom_idx_end)) {
            return;
        }
        if (custom_idx_end == -1 && custom_idx_start == -1) {
            return;
        }
        throw new IllegalArgumentException("잘못된 커스텀 패턴");

    }

    private boolean haveCustomOperator(int custom_idx_start, int custom_idx_end) {
        if (custom_idx_start == CUSTOM_START_IDX && custom_idx_end == CUSTOM_END_IDX) {
            addSeperator(custom_idx_end);
            return true;
        }
        return false;
    }

    private void addSeperator(int custom_idx_end) {
        char custom_seperator = input.charAt(CUSTOM_IDX);
        separators.add(custom_seperator);
        input = input.substring(custom_idx_end + 2);
    }

    private boolean isItNum(Character c) {
        return c >= 48 && c <= 57;
    }


}
