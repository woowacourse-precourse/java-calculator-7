package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private String inputString;
    private List<String> delimiterList = new ArrayList<>();
    private List<Integer> extractedNumList = new ArrayList<>();

    NumberParser(String inputString) {
        this.inputString = inputString;
        delimiterList.add(",");
        delimiterList.add(":");
        extractDelimiter();
    }

    private void extractDelimiter(){
        if(!inputString.contains("//")){
            return;
        }
        else{
            if(!inputString.contains("\\n")){
                // 예외처리
                System.out.println(inputString);
            }
            else{
                delimiterList.add(inputString.substring(inputString.indexOf("//")+2, inputString.indexOf("\\n")));
                System.out.println(delimiterList);
            }
        }
    }

    private void extractNum(){

    }
}
