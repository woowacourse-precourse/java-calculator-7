package org.example.domain;

import java.util.Arrays;
import java.util.List;

public class Number {

    private final List<Integer> nums;

    public Number(String parseInput) {
        if (parseInput.isEmpty() || parseInput.isBlank()) {
            nums = List.of(0);
            return;
        }

        nums = Arrays.stream
                        (parseInput.split(" "))
                .map(Integer::valueOf)
                .peek(num -> validatePositive(num))
                .toList();
    }

    public int sum() {
        return nums.stream().reduce(0, Integer::sum);
    }

    private void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Invalid number: " + num);
        }
    }
}
