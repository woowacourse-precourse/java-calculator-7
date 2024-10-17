package calculator.validator;

public class ValueValidator implements Validator {

    @Override
    public void validate(String value) {
        if (value.contains(" ")) {
            throw new IllegalArgumentException("잘못된 입력: 값에 공백이 포함될 수 없습니다.");
        }
    }
}
