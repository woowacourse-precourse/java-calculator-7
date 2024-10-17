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
        //- **기능**: 요구사항에 맞는 패턴인지 검사하고, 덧셈을 진행한다.
        //    - **알고리즘**:
        //        - 일반 구분자만 사용하는 문자열 or 커스텀 구분자를 사용하는 문자열 인지 구분
        //            - 숫자로 시작해서 숫자로 끝난다
        //            - `//(커스텀 구분자)\n`의 형태로 시작하고,숫자로 끝난다.
        //                - 커스텀 구분자를 구분자 리스트에 추가한다.
        //        - 문자열 끝까지 아래를 반복한다
        //            - 숫자 구분자 숫자의 패턴을 만날때마다 `result`변수에 더한다.

        //첫글자가 숫자면 일반 구분자만 사용하는 케이스

        checkInputHaveCustom();
        String num = "";
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            //구분자를 만나는 경우
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
        }
        //마지막에 num이 차있다면 더하기
        if (!num.isEmpty()) {
            result += Integer.parseInt(num);
            return result;
        }

//        int d = input.charAt(0);
//        if(d>=48 && d<=57){
//            //한글자씩 순회
//            for (int i = 0; i < input.length(); i++) {
//                char a=input.charAt(i);
//            }
//        }else if(){
//
//        }
        throw new IllegalArgumentException();
    }

    private void checkInputHaveCustom() {
        //1.커스텀 사용 여부 확인
        //커스텀 문자는 `//(커스텀)\n으로 이루어져 있음`
        //예외상황:커스텀 문자에 숫자가 들어갈 수 없음
        int custom_idx_start = input.indexOf("//");
        int custom_idx_end = input.indexOf("\\n");
        if (custom_idx_start == CUSTOM_START_IDX && custom_idx_end == CUSTOM_END_IDX) {
            char custom_seperator = input.charAt(CUSTOM_IDX);
            separators.add(custom_seperator);
            input = input.substring(custom_idx_end + 2);
            return;
        }
        if (custom_idx_end == -1 && custom_idx_start == -1) {
            return;
        }
        throw new IllegalArgumentException("잘못된 커스텀 패턴");

    }

    private boolean isItNum(Character c) {
        return c >= 48 && c <= 57;
    }


}
