package calculator.tool1;

public class StringChecker {

  public static boolean checkString(String delimiter, String nums) {
    //문자열 유효성 체크
    if (!delimiter.startsWith("//")) {
      return false;
    } else if (delimiter.length() < 3) {
      return false;
    } else {
      return true;
    }
  }


}
