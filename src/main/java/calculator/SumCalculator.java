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
      String deletedCustom = input.replaceFirst(pattern.pattern(),"");
      return customSum(deletedCustom, matcher.group(1)); //커스텀 구분자
    }
    return normalSum(input); // 기본 구분자
  }

  private int normalSum(String input){
    // 기본 구분자는 쉼표와 콜론으로, 받은 문자열은 이것을 기준으로 숫자의 합을 수행한다.
    int answer = 0;
    String[] number = input.split("[,|:]");
    if(number.length == 0){
      throw new IllegalArgumentException("계산식이 잘못되었습니다.");
    }
    try{
      for(int i = 0; i<number.length; i++){
        if(number[i].isEmpty()){
          throw new IllegalArgumentException("계산식이 잘못되었습니다.");
        }
        answer += Integer.parseInt(number[i]);
      }
    } catch (NumberFormatException e){
      throw new IllegalArgumentException("int 범위를 벗어낫거나 계산식이 잘못되었습니다.");
    }
    return answer;
  }

  private int customSum(String input, String customDelimiter){
    // 커스텀 구분자는 쉼표, 클론과 함께 지정한 구분자를 기준으로 숫자의 합을 수행한다.
    int answer = 0;
    String[] number = input.split("[,|:"+customDelimiter+"]");
    if(number.length == 0){
      throw new IllegalArgumentException("계산식이 잘못되었습니다.");
    }
    try{
      for(int i = 0; i<number.length; i++){
        if(number[i].isEmpty()){
          throw new IllegalArgumentException("계산식이 잘못되었습니다.");
        }
        answer += Integer.parseInt(number[i]);
      }
    } catch (NumberFormatException e){
      throw new IllegalArgumentException("int 범위를 벗어낫거나 계산식이 잘못되었습니다.");
    }
    return answer;
  }
}
