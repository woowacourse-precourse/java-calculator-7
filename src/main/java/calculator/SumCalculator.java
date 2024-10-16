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
      return customSum(input); //커스텀 구분자
    }
    return normalSum(input); // 기본 구분자
  }

  private int normalSum(String input){
    // 기본 구분자는 쉼표와 콜론으로, 받은 문자열은 이것을 기준으로 숫자의 합을 수행한다.
    int answer = 0;
    String[] number = input.split("[,|:]");
    try{
      for(int i = 0; i<number.length; i++){
        answer += Integer.parseInt(number[i]);
      }
    } catch (NumberFormatException e){
      throw new IllegalArgumentException();
    }
    return answer;
  }

  private int customSum(String input){
    int answer = 0;
    // To-do
    return answer;
  }
}
