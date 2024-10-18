package calculator;

import java.util.ArrayList;

/* 문자열 데이터의 분리를 위해 state 그래프를 이용해 처리한다.
 *
 *   START -> NUMBER : 0~9 입력
 *   START -> [*] : 유효하지 않은 입력 발생 (예외 처리)
 *   START -> END : 문자열 순회가 끝날 경우
 *
 *   NUMBER --> NUMBER : 연속된 숫자 입력
 *   NUMBER --> DELIMITER : 구분자 입력
 *   NUMBER --> [*] : 유효하지 않은 입력 발생 (예외 발생)
 *   NUMBER -> END : 문자열 순회가 끝날 경우
 *
 *   DELIMITER --> NUMBER : 숫자 입력 (Character.isDigit)
 *   DELIMITER --> DELIMITER : 구분자 입력 (isDelimiter)
 *   DELIMITER --> [*] : 유효하지 않은 입력 발생 (예외 발생)
 *   DELIMITER -> END : 문자열 순회가 끝날 경우
 */
public class AdderScanner {

    private ArrayList<Integer> output;
    private char customDelimiter=',';

    enum State {
        START,
        NUMBER,
        DELIMITER,
        END
    }



    ArrayList<Integer> getOutput() {

        return output;
    }
    public AdderScanner(String input)  {

        output=new ArrayList<>();
        StringBuilder cur_num=new StringBuilder();

        State state= State.START;

        //커스텀 구분자 처리
        if(input.startsWith("//")) {

            int delimiterEndIndex=input.indexOf("\\n");

            // \n이 존재하는 경우 customDelimiter 추출 후 \n 까지 문자열 데이터 제거 해 NUMBER 부터 시작할 수 있게함
            if(delimiterEndIndex !=-1) {
                customDelimiter=input.substring(2,delimiterEndIndex).charAt(0);
                input=input.substring(delimiterEndIndex+2);
            }
        }
        //System.out.println("customDeliiter: " + customDelimiter);
        //System.out.println("input:" + input);


        for(char ch: input.toCharArray()) {
            switch(state) {
              case START:
                if (Character.isDigit(ch)) {
                  state=State.NUMBER;
                  cur_num.append(ch);
                } else if(!isDelimiter(ch,customDelimiter)) {
                  // 예외 처리
                  throw new IllegalArgumentException("Invaild input: " + ch);
                }
                break;
              case NUMBER:
                if(Character.isDigit(ch)) {
                  cur_num.append(ch);
                } else if(isDelimiter(ch,customDelimiter)) {
                  //cur_num에 입력받은 문자열 숫자 데이터를 output 리스트에 저장 후 cur_num 초기화
                  state=State.DELIMITER;
                  output.add(Integer.parseInt(cur_num.toString()));
                  cur_num.setLength(0);
                } else {
                  throw new IllegalArgumentException("Invaild input: " + ch);
                }
                break;
              case DELIMITER:
                if(Character.isDigit(ch)) {
                  state=State.NUMBER;
                  cur_num.append(ch);
                } else if(!isDelimiter(ch,customDelimiter)) {
                  throw new IllegalArgumentException("Invaild input: " + ch);
                }
                break;
            }

        }

        //마지막 숫자 데이터는 DELIMITER STATE로 넘어가지 못했으니 순회문 탈출 한 후 리스트에 추가함
        //아무런 입력이 없을 경우 0을 출력하기 위해 리스트에 0 추가
        if(cur_num.length()>0) {
            output.add(Integer.parseInt(cur_num.toString()));
        } else if(output.isEmpty()) {
            output.add(0);
        }

        /*
        for(int i=0;i<output.size();i++) {
            System.out.print(output.get(i) +" ");
        }
        System.out.println();\
         */
    }

    private static boolean isDelimiter(char ch,char custom_char) {

        return ch == ':' || ch == ',' || ch==custom_char;
    }



}
