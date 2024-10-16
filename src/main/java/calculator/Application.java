package calculator;

import calculator.tool1.StringChecker;
import calculator.tool1.StringInput;
import calculator.tool2.ExtractDelimiter;
import calculator.tool2.ExtractNum;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

  public static void main(String[] args) {

    try {
      //입력값 받기
      String[] input = StringInput.inputString();

      String delimitersString = input[0];
      String numsString = input[1];

      //문자열 유효성 검사
      if (!StringChecker.checkString(delimitersString,numsString)) {
        throw new IllegalArgumentException("문자열이 유효하지 않습니다");
      }

      String[] delimiters =  ExtractDelimiter.
          extractDelimiter(delimitersString);

      /*
       * for (String delimiter: delimiters) {
       *   System.out.print(delimiter);
       * }
       */

      long[] nums = ExtractNum.extractNum(numsString, delimiters);

      for (long num : nums) {
        System.out.print(num);
      }

    } catch (NoSuchElementException |
             IllegalArgumentException noSuchElementException) {
      throw new IllegalArgumentException("문자열이 유효하지 않습니다");
    } finally {
      Console.close();
    }


  }
}
