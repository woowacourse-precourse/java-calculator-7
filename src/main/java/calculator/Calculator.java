package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String No_Space_Input;
    private List<String> Delimiter = new ArrayList<>(Arrays.asList(",",":"));
    private String del_deli_input;

    public Calculator(String input) {
        if(input.isEmpty() || !input.matches(".*\\d.*")) {
            System.out.println("결과 : 0");
        }
        this.No_Space_Input = input.replaceAll("\\s+", "");
    }

    public void print(){
        del_deli_input = Custom_Deli();
        System.out.println(Delimiter);
        System.out.println(del_deli_input);
        //System.out.println(No_Space_Input);
    }

    public String Custom_Deli(){
        int index = 0;
        StringBuilder returnstring = new StringBuilder(No_Space_Input);

        while((index = returnstring.indexOf("//",index)) != -1){
            if(index + 4 < returnstring.length()){
                String enter = Character.toString(returnstring.charAt(index + 3)) + Character.toString(returnstring.charAt(index + 4));
                char ch = returnstring.charAt(index+2);

                if(enter.equals("\\n") && !Character.isDigit(ch)){
                    Delimiter.add(Character.toString(returnstring.charAt(index + 2)));
                    returnstring.delete(index,index+5);
                    index = 0; // 수정된 문자열 다시 순회해서 찾게하기
                }
            }
            index += 2;
        }
        return returnstring.toString();
    }

}