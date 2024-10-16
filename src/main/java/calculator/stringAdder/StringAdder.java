package calculator.stringAdder;

import calculator.stringAdder.inputvalidator.InputValidator;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class StringAdder {
  public static void run() {
    try{
      InputValidator inputValidator = new InputValidator();
      while (true){
        String input = inputValidator.validateInput();
      }
    } catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
    } finally{
      System.out.println("애플리케이션을 종료합니다.");
    }

  }
}
