package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorDisplay {

    private static final String inputMessage = "덧셈할 문자열을 입력해 주세요.";

    public void show(){
        // 1. 사용자 입력 받기
        System.out.println(inputMessage);
        String input = Console.readLine();
        Console.close();

        SeparationProcessor separationProcessor = new SeparationProcessor(',', ':');

        // 2. 커스텀 구분자 등록 여부 확인
        Pattern pattern = Pattern.compile("^(\\/\\/.\\\\n)");
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()){
            Character customSeparation = matcher.group().charAt(2);
            separationProcessor.addSeparation(customSeparation);

            // 구분자 등록에 사용됐던 명령어 제거
            input = input.replace(matcher.group(), "");
        }

        // 3. 구분자를 기준으로 숫자 분리하기
        String[] strings = separationProcessor.split(input);
        for(String s : strings){
            System.out.printf("%s ", s);
        }

        // 4. 숫자의 합 계산하기

        // 5. 결과 출력하기
    }
}
