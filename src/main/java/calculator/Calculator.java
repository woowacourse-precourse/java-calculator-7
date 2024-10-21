package calculator;

public class Calculator {
    private String delimiter = ",|:";
    //커스텀 구분자 및 숫자 추출
    private String parseNumber(String input){
        if(input.startsWith("//")){
            int start = input.indexOf("//") + 2;
            int end = input.indexOf("\\n");
            if(end == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            delimiter = input.substring(start,end);//커스텀 구분자

            delimiter = escapeMetaCharacters(delimiter);

            input = input.substring(end+2);//더할 숫자 추출
        }
        return input;
    }
    //메타 문자 대체
    private String escapeMetaCharacters(String delimiter) {
        return delimiter.replaceAll("([\\\\+*\\[\\](){}|.^$?])", "\\\\$1");
    }
    
    //입력 값 계산
    public int getResult(String input){
        if(input == null || input.isEmpty()){
            return 0;
        }
        input = parseNumber(input);
        int result = 0;
        String[] numbers = input.split(delimiter);//커스텀 구분자제거
        for(String number : numbers){
            try{
                int num = Integer.parseInt(number);
                if(num < 0){
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
                result += num;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        return result;
    }
}
