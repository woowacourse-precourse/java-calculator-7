package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력 받기
        String inputStr = getInput();

        // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
        String customPolymer = findCustomPolymer(inputStr);
        String basicPolymerList = "[,:]";

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

        // 문자열 숫자가 아닌 경우 예외 처리
        boolean isStringNumber = true;
        for (String s : inputStrList) {
            if(!s.matches("\\d+")){
                isStringNumber = false;
            }
        }

        if(!isStringNumber){
            throw new IllegalArgumentException("숫자 제외 입력 금지");
        }

        // 분리된 문자열 숫자로 변환하기
        int[] strToIntList = new int[inputStrList.length];
        boolean isMinus = false;
        int index = 0;
        for (String str : inputStrList) {
            strToIntList[index] = Integer.parseInt(str);
            if (strToIntList[index] < 0){
                isMinus = true;
            }
            index++;
        }

        // 음수인 경우 에러처리
        if(isMinus){
            throw new IllegalArgumentException("음수 입력 불가");
        }

        // 변환된 숫자를 더하기
        int sum = 0;
        for (int number : strToIntList) {
            sum += number;
        }

        // 덧셈 결과 출력하기
        System.out.println("결과 : " + sum);
    }

    // 문자열 입력 받기
    private static String getInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 입력한 문자열에서 기본 구분자, 커스텀 구분자 찾아내기
    private static String findCustomPolymer(String inputStr){
        String customPolymerPattern = "//[^\\w\\s]";

        String customPolymer = "";

        Pattern pattern = Pattern.compile(customPolymerPattern);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.find() && inputStr.substring(3,5).equals("\\n")){
            customPolymer = inputStr.substring(2,3);
        }

        return customPolymer;
    }

}