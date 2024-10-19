package calculator.input;

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
        separatorRepository.saveSeparator("//:");
        separatorRepository.saveSeparator("//,");

        //Console 초기화
        Console.close();

        //InputManager 초기화
        inputManager = new InputManagerImpl(numberRepository, separatorRepository);
    }

    @Test
    void 읽을_라인이_필요_이상으로_들어가면_예외가_발생() {
        String fakeInput = "//d\n1\nUnexpectedLine";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputManager.saveSeparatorAndNumbers());
    }

    @Test
    void 읽을_라인이_부족하면_예외_발생() {
        String fakeInput = "//d";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class
        , () -> inputManager.saveSeparatorAndNumbers());
    }

    @Test
    void 메서드_호출이_2번이상_발생하면_예외_발생() {
        String fakeInput = "//d\n12";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalStateException.class,
                () -> {
                    inputManager.saveSeparatorAndNumbers();
                    inputManager.saveSeparatorAndNumbers();
                });
    }

    /**
     * “//{커스텀 구분자}\n” 입력에는 두번째 라인을 빈문자열 취급하고
     * “//{커스텀 구분자}”은 분명히 잘못된 형식의 요청이기 때문에 IllegalArgmentExeception을 발생시키고 싶었지만
     *
     * Console API 에서 호출이 가능한 메서드가 readLine()과 close()밖에 존재하지 않기 때문에 “//{커스텀 구분자}”와
     * 구별할 수 있는  방법을 찾을 수 없었다.
     *
     * 사용자 이용을 고려하면 커스텀 구분자를 입력한다는거 자체가 그 커스텀 구분자를 사용하기 위한 것이기 때문에
     * “//{커스텀 구분자}\n” 입력을 해도 뒤에 아예 빈문자열이 오는 것은 잘못된 입력이라고 판단하고
     * IllegalArgmentExeception를 던지도록 만들었다.
     */
    @Test
    void 커스텀_구분자_설정_후_빈문자가_오면_예외_발생() {
        String fakeInput = "//d\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fakeInput.getBytes());
        System.setIn(inputStream);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputManager.saveSeparatorAndNumbers());
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
}
