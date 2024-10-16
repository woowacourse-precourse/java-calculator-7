package calculator.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
  public String readInput(){
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    return Console.readLine();
  }
}
