package calculator;

public class CustomInputValidation {

    private String[] separatedNumbers;

    private String userNumbers;

    private boolean isValid;

    public CustomInputValidation(boolean isValid, String userNumbers) {
        this.isValid = isValid;
        this.userNumbers = userNumbers;
    }

    public void userInputValidate(String Numbers) {
        if (isValid) {
            //customInputValidate(userNumbers);
            checkCustomSeparatorForm(Numbers);
            isCustomNotDigit(Numbers);
            separatedNumbers = makeUserCustomNumbers(Numbers);
        }

        if (!isValid) {
            separatedNumbers = makeUserNormalNumbers(Numbers);
        }

    }


    public void checkCustomSeparatorForm(String Numbers) {
        if ((Numbers.substring(0, 2) + Numbers.substring(3, 5)).equals("//\\n")) {

        } else {
            throw new IllegalArgumentException();
        }
    }

    public String makeNormalSeparator() {

        return "[" + SeparatorUtil.normalSeparator + "]";
    }

    public String[] makeUserNormalNumbers(String Numbers) {
        return Numbers.split(makeNormalSeparator());
    }

    public void isCustomNotDigit(String Numbers) {
        if (Character.isDigit(Numbers.charAt(2))) {
            throw new IllegalArgumentException();
        }
    }

    public String makeCustomSeparator(String Numbers) {

        return "[" + SeparatorUtil.normalSeparator + Numbers.charAt(2) + "]";
    }

    public String[] makeUserCustomNumbers(String Numbers) {
        return Numbers.substring(5).split(makeCustomSeparator(Numbers));
    }

    public String[] getNumbers() {
        userInputValidate(userNumbers);

        return separatedNumbers;
    }

}
