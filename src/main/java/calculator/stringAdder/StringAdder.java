package calculator.stringAdder;


import calculator.stringAdder.inputvalidator.InputValidator;
import calculator.stringAdder.delimiterParser.DelimiterParser;
import calculator.stringAdder.numberParser.NumberParser;
import calculator.stringAdder.calculator.Calculator;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 16.
 */
public class StringAdder {
  public static void run() {
    try{

      InputValidator inputValidator = new InputValidator();
      String input = inputValidator.validateInput();

      DelimiterParser delimiterParser = new DelimiterParser();
      String[] delimiters = delimiterParser.getDelimiters(input);

      NumberParser numberParser = new NumberParser();
      String[] numbers = numberParser.getNumbers(input, delimiters);

      Calculator calculator = new Calculator();
      String result = calculator.sum(numbers);

      System.out.println("결과 : "+ result);

    } catch (IllegalArgumentException e){
      System.err.println(e.getMessage());
      throw new IllegalArgumentException();
    } finally{
      System.out.println("애플리케이션을 종료합니다.");
    }
  }
}
