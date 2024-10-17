package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    // 규칙에 맞게 입력을 했는가?
    //잘못 입력했을 경우 어느 정도 허용하고 예외처리를 하겠는가?
//        String regex = "^([1-9][0-9]*[^0-9]|[^0-9][1-9][0-9]*)+$";

//        String regex="^//(.)\\\\\\\\n(.*)$";

//    private String regex ="^([1-9][0-9]*[,;]|[,;][1-9][0-9]*)+";

//    String basicPattern = "^([0-9]+([,|:]{1,})[0-9]+)*$"; //숫자와 ,:
//    String sortPattern = "^//([^0-9])\\\\n([1-9][0-9]*(\\1)*)+[1-9][0-9]*(\\1)*$"; // 구분자 작성
//    String basic="^(([1-9][0-9]*[^0-9]+)|([^0-9]+[1-9][0-9]*))+$";
    //아 구분자작성을 시작으로만 할까 뒤에 숫자 패턴도 일치하는걸로 할까...
    String regex = "^//[^0-9]\\\\n(.+)$";

    System.out.println("양수를 ,와:으로 구분해 작성해주세요 다른구분자를 원하시면 \"//[구분자]\\n[작성]\"으로 작성해 주세요 (ex://;\\n1;2;3)");

    String input = Console.readLine();

    if(input.matches(regex)){

    }else{

    }



  }
}
