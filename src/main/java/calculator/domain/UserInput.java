package calculator.domain;

public class UserInput {
    private String text;

    //생성자 생성
    public UserInput(String text) {
        this.text = text;
    }

    //입력값이 비어있는지 검사하고, 비어있다면 0을 반환
    private Integer validateInput(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        } else {
            //계산을 시작하는 메서드
            return null;
        }
    }

    // Getter
    public String getText() {
        return text;
    }

}


