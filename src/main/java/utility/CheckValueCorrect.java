package utility;

public class CheckValueCorrect {
    public String value;

    public CheckValueCorrect(){}
    public CheckValueCorrect(String inputValue) {
        this.value = inputValue;
    }

    public int strToInt(String inputValue){
        this.value = inputValue;
        int intValue;

        try {
            intValue = Integer.parseInt(this.value);
        }catch (Exception e){
            throw new IllegalArgumentException("-".repeat(58)+"\n" +
                    "정수로 변환할 수 없는 값이 감지되었습니다. 아래의 형식에 맞게 입력해 주세요.\n" +
                    "➣ 커스텀 구분자 지정시, //와 \\n를 모두 사용하며 순서를 지켜야 합니다.\n" +
                    "➣ 구분자를 제외한 모든 문자는 양수인 정수여야 합니다.\n");
        }

        if(intValue < 0) {
            throw new IllegalArgumentException("-".repeat(58)+"\n" +
                    "음수를 입력하였습니다. 양수인 정수를 입력해 주세요.\n");
        }

        return intValue;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "입력된 변수: " + this.value;
    }
}
