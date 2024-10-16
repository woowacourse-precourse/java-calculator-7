package calculator.tool1;

public class StringChecker {

  public static boolean checkString(String input) {
    //문자열 유효성 체크
    if (!input.startsWith("//")) {
      return false;
    } else if (input.contains("//\n")) {
      return false;
    } else {
      return true;
    }
  }


}
