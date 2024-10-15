# java-calculator-precourse

### 추가로 정의한 요구사항

- 커스텀 구분자는 길이 제한이 없다. + 문자/숫자여도 상관 없다.
- 커스텀 구분자 지정 시 커스텀 구분자와 기본 구분자를 함께 사용할 수 있다.

# 🧮 문자열 덧셈 계산기 Todo List

![](./architecture.png)

### Application 객체

- [x] 사용자로부터 문자열을 입력받은 후, 커스텀 구분자를 사용 여부에 따라 다른 Separator 구현체를 생성하여 Calculator의 생성자 인자로 넣어줌
- [x] Calculator 객체의 `calculate()` 메서드를 호출하여 계산기 애플리케이션을 실행한다.

### Calculator 객체

- [ ] Separator 객체를 사용하여 하나의 문자열을 구분자 기준으로 쪼갠다.
- [ ] Converter 객체를 사용하여 문자열 배열을 정수 배열로 변환한다.
- [ ] Aggregator 객체를 사용하여 정수 배열의 합을 구한다.

### Separator 인터페이스

- `split()` 메서드 → 다형성

#### DefaultSeparator 객체

- [ ] 기본 구분자만을 사용하여 문자열을 쪼갠 후 List 자료형으로 반환한다.

#### CustomSeparator 객체

- [ ] 커스텀 구분자가 특수문자인 경우와 일반문자인 경우를 구분한다.

  특수 문자인 경우 구분자 앞에 이스케이프 문자를 추가하여 구분한다.

### Converter 객체

- [ ] String 배열을 Integer 배열로 변환한다.

  정수로 변환하기 전에 문자열이 포함되어 있는지 확인하기. 정수가 아닌 경우 `IllegalException` 예외를 발생시키고 프로그램 종료

### Aggregator 객체

- [ ] 정수 배열의 합을 계산하여 반환한다.