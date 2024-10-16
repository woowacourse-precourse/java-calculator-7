package calculator.tool1;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class StringInput {

  public static String[] inputString() {

    try {
      //입력을 \n 문자열 기준으로 받음
      //System.out.println("덧셈할 문자열을 입력해 주세요.");
      String delimiters = Console.readLine();
      String nums = Console.readLine();

      return new String[]{delimiters, nums};

    } catch (NoSuchElementException noSuchElementException) {
      throw new IllegalArgumentException();
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IllegalArgumentException();
    }
    finally {
      Console.close();
    }


  }

}
