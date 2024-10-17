package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    // 규칙에 맞게 입력을 했는가?
    //잘못 입력했을 경우 어느 정도 허용하고 예외처리를 하겠는가?
//        String regex = "^([1-9][0-9]*[^0-9]|[^0-9][1-9][0-9]*)+$"
    System.out.println("양수를 ,와:으로 구분해 작성해주세요 다른구분자를 원하시면 \"//[구분자]\\n[작성]\"으로 작성해 주세요 (ex://;\\n1;2;3)");


    RegexCheck input = new Print(Console.readLine());

    if(input.isSort()){


    }else{

    }



  }
}
