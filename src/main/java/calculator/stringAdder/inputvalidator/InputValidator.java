package calculator.stringAdder.inputvalidator;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class InputValidator {

  public String validateInput() {
    System.out.println("덧셈할 문자열을 입력해주세요.");
    try{
      String input = Console.readLine();
      if (input == null){
        throw new IllegalArgumentException(this.getClass().getSimpleName()+ ": 입력한 문자열이 비었습니다.");
      }
      return input;
    } catch (NoSuchElementException e){ //테스트용
      return "";
    }
  }
}
