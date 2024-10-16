package calculator.tool2;

import java.util.Arrays;

public class Extracts {

  private String numString;
  private String delimiterString;
  private String[] delimiters;
  private long[] nums;


  public long[] getNums(){
    return this.nums;
  }

  public String[] extractDelimiter() {
    return this.delimiters =
        delimiterString.substring(2).split("");
  }

  public long[] extractNum() {
    //구분자들로 regex를 만듭니다. ex) [:,]
    String regex = convertToRegex(delimiters);

    //regex로 숫자들을 추출하고 long 형 배열로 숫자들을 리턴합니다.
    return this.nums =  Arrays.stream(numString.split(regex))
        .mapToLong(Long::parseLong)
        .toArray();
  }

  private String convertToRegex(String[] delimiters) {
    String regex = "[";
    for (String delimiter : delimiters) {
      regex += delimiter;
    }
    return regex + "]";
  }

  public Extracts(String numString, String delimiterString) {
    this.numString = numString;
    this.delimiterString = delimiterString;
  }

}
