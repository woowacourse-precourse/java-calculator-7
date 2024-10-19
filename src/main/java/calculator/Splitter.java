package calculator;

import java.util.ArrayList;
import java.util.Stack;

public class Splitter {
    static final String CUSTOM_SPLIT_FLAG = "//";

    private int makeNumber(Stack<Integer> numbers) {
        int flag = 1;
        int sum = 0;

        while(!numbers.isEmpty()) {
            int target = numbers.pop();
            sum += (target * flag);
            flag *= 10;
        }

        return sum;
    }

    private boolean isSplitter(char[] splitter, char target) {
        for (char c : splitter) {
            if (c == target)
                return true;
        }

        return false;
    }

    private ArrayList<Integer> findNumbers(String target, char[] splitter, int startPoint) {
        if(target.length() < startPoint) {
            throw new IllegalArgumentException();
        }

        Stack<Integer> numbers = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int loop = startPoint; loop < target.length(); ++loop) {
            char current = target.charAt(loop);

            if(current >= '0' && current <= '9') {
                numbers.push(current - '0');
            }
            else if (isSplitter(splitter, current)){
                result.add(makeNumber(numbers));
                numbers.clear();
            }
            else {
                throw new IllegalArgumentException();
            }
        }

        if(!numbers.isEmpty()) {
            result.add(makeNumber(numbers));
        }

        return result;
    }

    private ArrayList<Integer> normalTarget(String target) {
        char[] splitter = new char[2];
        splitter[0] = ',';
        splitter[1] = ':';

        return findNumbers(target, splitter, 0);
    }

    private ArrayList<Integer> customTarget(String target) {
        char splitHere = target.substring(2,3).charAt(0);
        char[] splitter = new char[1];
        splitter[0] = splitHere;

        return findNumbers(target, splitter, 5);
    }

    private boolean isCustom(String target) {
        if (target.length() < 2)
            return false;

        String head = target.substring(0,2);

        return head.compareTo(CUSTOM_SPLIT_FLAG) == 0;
    }

    public ArrayList<Integer> splitTarget(String target) {
        ArrayList<Integer> numbers = new ArrayList<>();

        if (target.isEmpty()) {
            numbers.add(0);
            return numbers;
        }

        if (isCustom(target)) {
            numbers = customTarget(target);
        }
        else {
            numbers = normalTarget(target);
        }

        return numbers;
    }
}
