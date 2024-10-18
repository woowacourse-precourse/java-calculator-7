package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {

  public static void main(String[] args) {

    //구분자를 기억하고 있는 배열
    String[] divisionList = {",", ":"};

    System.out.println("덧셈할 문자열을 입력해 주세요. ");
    String input = Console.readLine();

    int result = 0;

    String[] divisionArray = divideInput(input);//구분자를 찾는 반복문을 메서드로 구분
    String realInput = divisionArray[0];
    String divisionString = divisionArray[1];

    //입력 받은 구분자 문자열을 빈문자열을 split에 구분자로 넣어 배열로 만듦
    String[] divisionList2 = divisionString.split("");
    //기존에 가지고 있던 구분자의 배열과 입력을 받은 구분자의 배열의 길이를 합쳐서 최종 구분자 배열의 길이를 정해줌
    String[] finalDivision = new String[divisionList.length + divisionList2.length];

    System.arraycopy(divisionList, 0, finalDivision, 0, divisionList.length);
    System.arraycopy(divisionList2, 0, finalDivision, divisionList.length, divisionList2.length);

    String nums = "";
//    System.out.println("중간에 결과 한번 보자" + realInput);
    for (int j = 0; j < realInput.length(); j++) {

      String element = Character.toString(realInput.charAt(j));

      if (Arrays.asList(finalDivision).contains(element)) { //구분자가 맞는 경우
        result = result + Integer.parseInt(nums); //이전에 확인했으니 정수만 들어있는 문자열일 것
        nums = ""; //숫자 초기화
        continue;
      } else {//구분자가 아닌 경우
        if (element.matches("\\d+")) { //숫자인 경우
          nums += element; //다음에도 숫자가 이어질 수 있으니 nums 변수에 더해주기
          if (j == realInput.length() - 1) { //마지막 인덱스인 경우 nums에 저장만 하고 안더해주므로 따로 조건
            result = result + Integer.parseInt(nums);
          }
          continue;
        } else {  //구분자도 아니고 숫자도 아닌 잘못된 문자인 경우
          System.out.println(element + "에러를 내는거지?");
          throw new IllegalArgumentException();
        }
      }
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
          divideString += c;
        } else if (i > 1) { //2번째까지 확인을 했는데도 //이 나오지 않은 경우 커스터 마이징 기회 종료
          break;
        }
      }

    }

    return new String[]{finalInput, divideString};
  }
}
