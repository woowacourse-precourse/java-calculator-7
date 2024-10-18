package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Console.close;

public class Application {

    public static void main(String[] args) {
        String delimiter = ",|:";
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputString = readLine();

        // TODO:  커스텀 구분자
        if (inputString.startsWith("//")){
            String[] findDelim = inputString.split("\\\\n");
            delimiter = findDelim[0].substring(2);
            inputString = inputString.substring(4+delimiter.length());
        }

        String[] separatedInput = inputString.split(delimiter);
        int sumValue = 0;
        for(int i=0; i<separatedInput.length;i++){
            sumValue += Integer.parseInt(separatedInput[i]);
        }
        System.out.println(String.format("결과 : %d", sumValue));

        // TODO:  예외처리
    }
}
