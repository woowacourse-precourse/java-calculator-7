package calculator.tool2;

import calculator.tool1.StringChecker;
import java.util.Arrays;

public class Extracts {

  private int[] nums;

  private String numString;

  private String delimiterRegex;

  public int[] getNums() {
    return this.nums;
  }

  public Extracts(String numString, String delimiterRegex) {
    this.numString = numString;
    this.delimiterRegex = delimiterRegex;
  }

  public void splitNums(){
    String[] strNums = numString.split(delimiterRegex);

    if (!StringChecker.checkNumberic(strNums)){
      throw new IllegalArgumentException("숫자가 아니거나 음수입니다.");
    }

    this.nums = Arrays.stream(strNums)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

}
