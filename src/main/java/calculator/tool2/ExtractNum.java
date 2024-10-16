package calculator.tool2;

import java.util.Arrays;

public class ExtractNum {

  public static long[] extractNum(String numString,String[] delimiters) {
    //구분자들로 regex를 만듭니다. ex) [:,]
    String regex = convertToRegex(delimiters);

    //regex로 숫자들을 추출하고 long 형 배열로 숫자들을 리턴합니다.
    return Arrays.stream(numString.split(regex))
        .mapToLong(Long::parseLong)
        .toArray();
  }

  private static String convertToRegex(String[] delimiters) {
    String regex = "[";
    for (String delimiter : delimiters) {
      regex += delimiter;
    }
    return regex + "]";
  }

}
