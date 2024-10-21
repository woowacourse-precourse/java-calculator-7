package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자에게서 입력값 받기
        String inputValue;
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            inputValue = Console.readLine();
        } catch (IllegalArgumentException e){
            return;
        }


        // 2. 입력값에서 기본 구분자(쉼표, 콜론)를 통해 숫자를 추출하는 기능
        ArrayList<Integer> result = new ArrayList<Integer>();
        // 2-1. 입력값이 비어있을 경우 0만 추출
        String[] nums={"0"};

        String[] parts = {};
        if (inputValue.length()>1) {
            // 2-2. 커스텀 구분자를 지정한 경우를 판단하는 기능
            if (inputValue.startsWith("//")) {
                if (inputValue.contains("\\n")){
                    inputValue=inputValue.substring(2);
                    parts = inputValue.split("\\\\n");
                    // 2-2-1.커스텀 구분자를 확정하는 기능
                    nums = parts[1].split(parts[0]);
                }else{
                    nums = inputValue.split(",|:");
                }
            }else{
                nums = inputValue.split(",|:");
            }
        }

        // 3. 입력값에서 커스텀 구분자를 통해 숫자를 추출하는 기능
        // 4. 추출한 숫자를 합하는 기능
        Integer total = 0;
        Integer tmp=0;

        // 5. 사용자가 값을 잘못 입력할 경우, 예외처리 기능
        if (nums.length>0){
            for (String value: nums){
                try{
                    tmp = Integer.parseInt(value);
                } catch(NumberFormatException e){
                    throw new IllegalArgumentException();
                }
                if (tmp<0){
                    throw new IllegalArgumentException();
                }
                total+=Integer.parseInt(value);
            }
        }

        System.out.println("결과 : "+total);

    }
}
