package calculator;

import calculator.tool1.StringChecker;
import calculator.tool1.StringInput;
import calculator.tool2.Extracts;
import calculator.tool3.Answer;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

  public static void main(String[] args) {

    try {
      //입력값 받기
      StringInput input = new StringInput();

      //문자열 유효성 검사
      if (!StringChecker.checkString
          (input.getDelimiters(), input.getNums())) {
        throw new IllegalArgumentException("문자열이 유효하지 않습니다");
      }

      Extracts extracts =
          new Extracts(input.getNums(),input.getDelimiters());

      extracts.extractDelimiter();
      extracts.extractNum();

      Answer answer = new Answer(extracts.getNums());

      answer.calSum();
      answer.printAns();


    } catch (NoSuchElementException |
             IllegalArgumentException noSuchElementException) {
      throw new IllegalArgumentException("문자열이 유효하지 않습니다");
    } finally {
      Console.close();
    }


  }
}
