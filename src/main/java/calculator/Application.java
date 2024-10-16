package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        ArrayList<Character> seperators = new ArrayList<>();
        seperators.add(',');
        seperators.add(':');

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try{
            //구분자 리스트에 구분자 추가
            if(input.charAt(0) == '/' && input.charAt(1) == '/'){
                int index = 2;
                while(!(input.charAt(index) == '\\' && input.charAt(index + 1) == 'n')){
                    char c = input.charAt(index);
                    if(Character.isDigit(c)){
                        throw new IllegalArgumentException();
                    }

                    seperators.add(input.charAt(index));

                    if(index + 2 >= input.length()){
                        throw new IllegalArgumentException();
                    }

                    index++;
                }
            }

            //커스텀 구분자가 존재하지 않음에도 시작 char이 문자열이 아님
            if(!Character.isDigit(input.charAt(0))){
                throw new IllegalArgumentException();
            }

            System.out.print("결과 : " + result);
        }
        catch(IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException();
        }
    }
}
