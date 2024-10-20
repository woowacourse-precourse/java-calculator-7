package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {

    //구분자는 정규표현식 쓰기 쉽게 그냥 string으로 관리
    String alreadyDivision = ",:";

    System.out.println("덧셈할 문자열을 입력해 주세요. ");
    String input = Console.readLine();

    int result = 0;

    String[] divisionArray = divideInput(input); //구분자를 찾는 반복문을 메서드로 분리
    String realInput = divisionArray[0]; //입력값을 분리해서 하나는 커스터마이징 부분을 제외한 실제 입력
    String divisionString = divisionArray[1]; //커스터 마이징으로 분리해낸 구분자 문자열

    String finalDivision = divisionString + alreadyDivision; //기존 구분자 설정이랑 합치기
    //사용자 입력 값에 오류 없는지 확인
    realInput = checkValid(realInput, finalDivision);

    String regex = "[" + finalDivision + "]";
    String[] numsArray = realInput.split(regex); //구분자들 문자열 중에 있으면 기준으로 분리

    for (String num : numsArray) {
      result += Integer.parseInt(num);
    }
    
    System.out.println("결과 : " + result);

  }


  public static String[] divideInput(String userString) {
    String finalInput = userString;
    String divideString = "";

    int start = 0;

    for (int i = 0; i < userString.length(); i++) { //커스터 마이징이 있는 경우에 한해서만 substring을 해줌
      char c = userString.charAt(i);

      if (c == '/') {
        start += 1; //처음에 /를 통해 조건문에 들어오면 1이 될 것이고, 그 다음에 들어올 때는 2
      } else if (c == '\\') { // \가 시작된다는 건 구분자 설정이 끝난다는 의미
        char cNext = userString.charAt(i + 1);
        if (cNext == 'n') { //백슬래시 다음에 n이 나온다면 이제 구분자 커스터 마이징은 끝남
          finalInput = userString.substring(i + 2); //구분자를 커스터 마이징하는 부분을 제외하고 부분 문자열을 할당
          //System.out.println(userString.substring(i + 2));
          break;
        }
      } else { //커스터마이징 시작 문구도 끝문구도 아닌경우
        if (start == 2) { //커스터 마이징 문구를 추가하기 시작했다는 뜻
          if (Character.toString(c).matches("\\d+")) { //근데 구분자가 숫자인 경우에는 추가를 안함
            continue;
          }
          divideString += c;
        } else if (i > 1) { //2번째까지 확인을 했는데도 //이 나오지 않은 경우 커스터 마이징 기회 종료
          break;
        }
      }

    }
    return new String[]{finalInput, divideString};
  }

  public static String checkValid(String userString, String regx) {
    String error = "[^" + regx + "0-9]";

    Pattern pattern = Pattern.compile(error); //원래는 contain메서드 쓸려고 했는데 정규표현식을 인식 못해서 ..
    Matcher matcher = pattern.matcher(userString);

    if (matcher.find()) { //구분자가 아닌 문자가 포함된 경우
      throw new IllegalArgumentException();
    } else {
      return userString;
    }
  }
}
