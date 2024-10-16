package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumCalculator {

  private static final String CUSTOM_DELIMITER = "//(.)\\\\n";

  // 기분 구분자, 커스텀 구분자 분리
  public int check(String input){
    if(input.isEmpty()){
      return 0; // 문자열이 비어있다면 0을 리턴
    }

    Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
    Matcher matcher = pattern.matcher(input);

    if(matcher.find() && input.startsWith("//")){
      System.out.println("커스텀 구분자 처리");
      return 2; //커스텀 구분자
    }
    System.out.println("기본 구분자 처리");
    return 1; // 기본 구분자
  }
}
