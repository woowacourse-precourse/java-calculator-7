package calculator;

public class Numbers {
    private final String[] numbers;

    public Numbers(String[] numbers) {
        for (String number : numbers) {
            if(number.isBlank()){
                throw new IllegalArgumentException("숫자에 빈값을 입력할순 없습니다");
            }
            if(Integer.parseInt(number) < 0){
                throw new IllegalArgumentException("음수를 입력할수 없습니다");
            }
        }


        this.numbers = numbers;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
