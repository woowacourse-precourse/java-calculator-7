package calculator.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public abstract class RandomSupport {
    private static final Random RANDOM = new Random();

    protected long randomNegative;
    protected long randomPositive;
    protected int loopCount;

    @BeforeEach
    void set() {
        this.randomNegative = createNegative();
        this.randomPositive = createPositive();
        this.loopCount = createLoopCount();

        Assertions.assertThat(this.randomNegative).isLessThan(0);
        Assertions.assertThat(this.randomPositive).isGreaterThanOrEqualTo(1);
        Assertions.assertThat(this.loopCount).isGreaterThanOrEqualTo(1);
    }

    protected long createNegative() {
        int negativeMin = -Integer.MAX_VALUE;
        int negativeMax = -1;
        return RANDOM.nextInt(negativeMax - negativeMin + 1) + negativeMin;
    }

    protected long createPositive() {
        int positiveMin = 1;
        int positiveMax = Integer.MAX_VALUE;
        return RANDOM.nextInt(positiveMax - positiveMin + 1) + positiveMin;
    }

    protected int createLoopCount() {
        int positiveMin = 1;
        int positiveMax = 30;
        return RANDOM.nextInt(positiveMax - positiveMin + 1) + positiveMin;
    }


    protected String createLowerAlphabetWord() {
        final int start = 'a';
        final int end = 'z';
        return String.valueOf((char) (RANDOM.nextInt(end - start + 1) + start));
    }

    protected String createUpperAlphabetWord() {
        final int start = 'A';
        final int end = 'Z';
        return String.valueOf((char) (RANDOM.nextInt(end - start + 1) + start));
    }

    protected String createKorean() {
        final int start = '가';
        final int end = '힣';
        return String.valueOf((char) (RANDOM.nextInt(end - start + 1) + start));
    }
}