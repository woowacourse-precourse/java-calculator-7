package calculator.tool1;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class StringInput {

  private String delimiters;

  private String nums;

  private boolean isCustomDelimiter;

  public String getDelimiters() {
    return delimiters;
  }

  public String getNums() {
    return nums;
  }

  public boolean getIsCustomDelimiter() {
    return isCustomDelimiter;
  }

  public StringInput() {

    try {
      //입력을 \n 문자열 기준으로 받음
      System.out.println("덧셈할 문자열을 입력해 주세요.");
      this.delimiters = Console.readLine();

      if (!StringChecker
          .checkCustomDelimiter(delimiters)) {
        this.nums = this.delimiters;
        this.delimiters = "//:,";
        this.isCustomDelimiter = false;
      } else {
        this.nums = Console.readLine();
        this.isCustomDelimiter = true;
      }


    } catch (NoSuchElementException noSuchElementException) {
      throw new IllegalArgumentException();
    } catch (IllegalArgumentException illegalArgumentException) {
      throw new IllegalArgumentException();
    } finally {
      Console.close();
    }

  }

}
