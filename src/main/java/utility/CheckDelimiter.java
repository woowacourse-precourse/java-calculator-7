package utility;

public class CheckDelimiter {
    public String[] values = {",|:", ""};

    public CheckDelimiter(){}
    public CheckDelimiter(String inputValue) {
        this.values[1] = inputValue;
    }

    public String[] delimiter_strToSplit(String inputValue){
        this.values[1] = inputValue;

        if(inputValue.contains("//") && inputValue.contains("\\n")){
            int slashIdx = inputValue.indexOf("//");
            int newLineIdx = inputValue.indexOf("\\n");

            if(slashIdx!=0 || slashIdx>newLineIdx || newLineIdx-slashIdx>3){
                throw new IllegalArgumentException("-".repeat(58)+"\n" +
                        "커스텀 구분자 지정시, 아래의 형식에 맞게 입력해 주세요.\n" +
                        "➣ 문자열의 맨 앞에 지정해 주어야 합니다.\n" +
                        "➣ [ //구분자\\n ]를 순서를 지켜 지정해 주어야 합니다.\n" +
                        "➣ 커스텀 문자는 한 글자여야 합니다.\n");
            }

            values[0] += "|\\"+inputValue.substring(slashIdx+2,newLineIdx);
            values[1] = inputValue.substring(newLineIdx+2);
        }

        return values;
    }


    public String[] getRes() {
        return this.values;
    }

    public void setRes(String[] res) {
        this.values = res;
    }

    @Override
    public String toString() {
        return "결과(구분자, 분할할 문자열): " + this.values[0] + ", " + this.values[1];
    }
}
