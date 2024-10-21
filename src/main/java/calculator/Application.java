package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        // 1차
        System.out.println("입력해 주세요");
        String input_sen = Console.readLine();
        int sum= 0;
        String target_op =",:";
        String temp_buf = "";

        for(int i = 0; i < input_sen.length();i++){
            String c = String.valueOf(input_sen.charAt(i));

            if(target_op.contains(c)){
                // temp_buf 를 숫자로 바꿔서 더하기
                sum += Integer.parseInt(temp_buf);

                temp_buf = "";
            }
            else{// 포함되어있는 기호가 아닐때
                //todo 커스텀 기호
                //todo 숫자가 아닐때 error

                // 숫자일 때
                temp_buf = temp_buf + c;

            }
        }
        sum += Integer.parseInt(temp_buf);
        System.out.println(sum);

        //end
        Console.close();
    }
}
