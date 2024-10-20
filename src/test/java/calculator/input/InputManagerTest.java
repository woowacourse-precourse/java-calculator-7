package calculator.input;

import calculator.Constants;
import calculator.repository.number.NumberRepository;
import calculator.repository.number.NumberRepositoryImpl;
import calculator.repository.separator.SeparatorRepository;
import calculator.repository.separator.SeparatorRepositoryImpl;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class InputManagerTest {

    private InputManager inputManager;
    private final NumberRepository numberRepository;
    private final SeparatorRepository separatorRepository;

    public InputManagerTest() {
        separatorRepository = SeparatorRepositoryImpl.getInstance();
        numberRepository = NumberRepositoryImpl.getInstance(separatorRepository);
        inputManager = new InputManagerImpl(numberRepository, separatorRepository);
    }

    @BeforeEach
    void setUp() {
        numberRepository.clearAll();
        separatorRepository.clearAll();
        //기본 구분자 입력
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_1);
        separatorRepository.saveSeparator(Constants.DEFAULT_SEPARATOR_2);

        //Console 초기화
        Console.close();

        //InputManager 초기화
        inputManager = new InputManagerImpl(numberRepository, separatorRepository);
    }

    @Test
    void 커스텀_구분자_형식이_잘못되면_예외_발생() {
        String fakeInput = "//d";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class
        , () -> inputManager.saveSeparatorAndNumbers());
    }

    @Test
    void 메서드_호출이_2번이상_발생하면_예외_발생() {
        String fakeInput = "//d\\n12";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalStateException.class,
                () -> {
                    inputManager.saveSeparatorAndNumbers();
                    inputManager.saveSeparatorAndNumbers();
                });
    }

    @Test
    void 커스텀_구분자_설정_후_빈문자가_오면_0을_저장() {
        String fakeInput = "//d\\n";
        List<Integer> expected = List.of(0);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        inputManager.saveSeparatorAndNumbers();

        Assertions.assertEquals(expected, numberRepository.getNumbers());
    }

    @Test
    void 빈문자가_오면_빈문자열_저장() {
        String fakeInput = "";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        inputManager.saveSeparatorAndNumbers();

        List<Integer> expected = List.of(0);

        Assertions.assertEquals(expected, numberRepository.getNumbers());
    }

    @Test
    void 숫자의_형식이_잘못되면_에러_발생() {
        String fakeInput = "/d\\n12:13";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> inputManager.saveSeparatorAndNumbers());
    }
}
