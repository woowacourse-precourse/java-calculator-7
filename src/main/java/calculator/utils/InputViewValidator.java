package utils;

public class InputViewValidator {


    public String validateQutoPair(String inputName) {

        if (inputName == null || !inputName.startsWith("\"") || !inputName.endsWith("\"")) {
            throw new IllegalArgumentException("입력은 큰따옴표로 감싸져 있어야 합니다.");
        }
        return inputName.substring(1, inputName.length() - 1);
    }

    public void validateCustom(String inputName) {

    }

    public void validateDuplicationCustom(String inputName) {

    }

}