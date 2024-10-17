package calculator;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    private List<Character> separators;
    private String input;
    private int result;


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


    private boolean isItNum(Character c) {
        int input = c;
        return c >= 48 && c <= 57;
    }

    public int getResult() {
        return result;
    }
}
