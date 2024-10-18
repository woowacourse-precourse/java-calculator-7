package calculator;

import java.util.*;

public class Numberlist {
    List<Integer> numbers;
    int temp;

    public Numberlist() {
        numbers = new ArrayList<>();
        temp = 0;
    }

    public void pushtemp(int number) {
        temp = temp*10 + number - '0';
    }

    public void push() {
        numbers.add(temp);
        temp = 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
