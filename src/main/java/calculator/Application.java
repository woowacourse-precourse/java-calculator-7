package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
    // TODO: 프로그램 구현

    // 문자열 입력 받기
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String inputStr = Console.readLine();

    // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
    String customPolymerPattern = "//[^\\w\\s]";
    String basicPolymerList = "[,:]";
    String customPolymer = "";

    Pattern pattern = Pattern.compile(customPolymerPattern);
    Matcher matcher = pattern.matcher(inputStr);

    if(matcher.find() && inputStr.substring(3,5).equals("\\n")){
        customPolymer = inputStr.substring(2,3);
    }

    // 기본 구분자 리스트에 커스텀 구분자 추가하기
    String customPolymerList = "";
    if(customPolymer.length() > 0){
        customPolymerList = basicPolymerList.substring(0,basicPolymerList.length()-1) + customPolymer + "]";
    }

    // 입력한 문자열에서 구분자를 기준으로 숫자 문자열 분리시키기
    String[] inputStrList;
    if(customPolymer.length() == 1){
        inputStrList = inputStr.substring(5,inputStr.length()).split(customPolymerList);
    } else {
        inputStrList = inputStr.split(basicPolymerList);
    }
    }
}
