package calculator;

public class DelimiterParser {
    public String[] parse(String input) {
        String delimiter = ",|:";
        input=input.replace(" ","");

        // 공백 제거 후 입력이 비어있는 경우
        if (input.isEmpty()) {
            return new String[]{"0"}; // 0을 포함한 배열 반환
        }
        String[] inputs = new String[100];
        if (input.startsWith("//") && input.contains("\\n")){
            int newLineIndex = input.indexOf("\\n");
            delimiter=input.substring(2,newLineIndex);
            input=input.substring(newLineIndex+2);
            return input.split(delimiter);
        }
        else if((input.contains(","))||(input.contains(":"))){
           inputs= input.split(delimiter);
        }
        else{
            throw new IllegalArgumentException("커스텀 구분자가 올바르지 않은 형식인 경우입니다.");
        }

        return inputs;
    }
}
