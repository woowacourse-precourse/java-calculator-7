package calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private String No_Space_Input;
    private List<String> Delimiter = new ArrayList<>(Arrays.asList(",",":"));
    private String del_deli_input;
    private List<String> parts;

    public Calculator(String input) {
        if(input.isEmpty() || !input.matches(".*\\d.*")) {
            System.out.println("결과 : 0");
        }

        if(input.matches(".*-\\d.*")){
            throw new IllegalArgumentException("음수값이 포함되면 안됩니다.");
        }

        this.No_Space_Input = input.replaceAll("\\s+", "");
    }
    /*
    public void print(){
        Custom_Deli(); // 커스텀 구분자 추가
        split_input(); // 커스텀 구분자 구문 삭제된 문자열에서 구분자를 이용해 문자열 구분 후 parts 리스트 저장
        double_check(parts); // 구분자로 나뉜 문자열 실수형 체크
        System.out.println(parts);
        //System.out.println(Delimiter);
        //System.out.println(del_deli_input);
        //System.out.println(No_Space_Input);
    }
     */

    public void add(){
        double sum = 0;
        Custom_Deli(); // 커스텀 구분자 추가
        split_input(); // 커스텀 구분자 구문 삭제된 문자열에서 구분자를 이용해 문자열 구분 후 parts 리스트 저장
        double_check(parts); // 구분자로 나뉜 문자열 실수형 체크
        for(String num : parts){
            sum += Double.parseDouble(num);
        }
        System.out.println("결과 : " + sum);
    }

    public void Custom_Deli(){
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
        del_deli_input = returnstring.toString();
    }

    public void split_input(){
        List<String> escapedDelimiters = escapeDelimiters(Delimiter);

        List<String> parts = new ArrayList<>();

        for(String delimiter : escapedDelimiters){
            if(parts.isEmpty()){
                parts.addAll(Arrays.asList(del_deli_input.split(delimiter)));
            }else{
                List<String> newparts = new ArrayList<>();
                for(String part : parts){
                    newparts.addAll(Arrays.asList(part.split(delimiter)));
                }
                parts = newparts;
            }
        }
        for(String part : parts){
            if(part.matches(".*[^0-9.].*")) // .이 포함되도 되는 이유 : 숫자가 실수인 경우도 고려 하기 위해
                throw new IllegalArgumentException("입력된 값에 문자가 있습니다.");
        }
        this.parts = parts;
    }

    private static List<String> escapeDelimiters(List<String> delimiter) {
        List<String> escaped = new ArrayList<>();
        for (String deli : delimiter) {
            escaped.add(Pattern.quote(deli));
        }
        return escaped;
    }

    public void double_check(List<String> input){
        for(String num : input){
            if(num.startsWith(".") || num.endsWith(".") || num.contains("..")){
                throw new IllegalArgumentException("실수 표현이 잘못된 입력값이 있습니다.");
            }
        }
    }
}