package calculator.tool1;

public class StringChecker {

  public static boolean checkNumberic(String[] inputString) {
    try{
      for (String s : inputString) {
        int num = Integer.parseInt(s);
        if (num < 0) return false;
      }
      return true;
    } catch(NumberFormatException e){
      return false;
    }
  }


}
