package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberExtraction {
    private Set<String> separationSet = new HashSet<String>(Arrays.asList(",", ":"));
    private ArrayList<Integer> extractedNumber = new ArrayList<>();
    private ArrayList<String> inputArray;
    private final String isNumber = "0123456789";
//    private final String banSeparation = ".";

    public ArrayList<Integer> run(String input){
        if (!checkNull(input)){
            inputArray = new ArrayList<>(Arrays.asList(input.split("")));
            extractNumber(checkCustomSeparation(input));
        }
        return extractedNumber;
    }

    private boolean checkNull(String input){
        return input.isEmpty();
    }

    //커스텀 구분자가 있다면 separation에 add 후 구분자 지정 구문이 끝나는 idx+1 반환.
    private int checkCustomSeparation(String input){
        System.out.println(input);
        int customEndIdx = input.indexOf("\\n");
        if (input.startsWith("//")){
            if(customEndIdx == -1){
                throwArgumentException("커스텀 구분자는 //와 \\n 사이에 입력해야 합니다.");
            }
            int i = 0;

            for(String s : inputArray){
                System.out.println(s);
                if (i++ < 2) continue;
                if (i > customEndIdx) break;

                if (isNumber.contains(s)){
                    throwArgumentException("숫자는 구분자가 될 수 없습니다.");
                }
                else{
                    separationSet.add(s);
                }
            }
            return i+1;
        }
        return 0;
    }

    private void extractNumber(int startNumberIdx){
        int i = 0;
        String numberTemp = "";
        for(String s : inputArray){
            if(i++ < startNumberIdx) continue;
            if(isNumber.contains(s)){
                numberTemp += s;
            }
            else if(separationSet.contains(s)){
                if(!numberTemp.isEmpty()){
                    // 단순 덧셈 계산만 한다면 AdditionCalculator로 List를 넘기지 말고 여기서 바로 더해서 총합 구하는 게 효율적일 듯하다.
                    extractedNumber.add(Integer.parseInt(numberTemp));
                    numberTemp = "";
                }
            }
            else{
                throwArgumentException("구분자도, 숫자도 아닌 문자는 허용하지 않습니다.");
            }
        }
        if (!numberTemp.isEmpty()) extractedNumber.add(Integer.parseInt(numberTemp));
    }

    private void throwArgumentException(String errorContext){
        throw new IllegalArgumentException(errorContext);
    }
}
