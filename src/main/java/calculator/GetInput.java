package calculator;


import camp.nextstep.edu.missionutils.Console;

// 입력을 받기 위한 클래스
public class GetInput {
    static String getInput(){
        System.out.println("문자열을 입력해주세요.");
        return Console.readLine();
    }
}
