#### 2024-10-19

##### Documentation Changes

* **README:**
  *  내용 수정 및 다이어그램 추가 (693d12f4)
  *  기능 구현 목록 작성 (76e7af4e)
* **CHANGELOG:**  CHANGELOG.md 생성 (d47da260)

##### New Features

* **Application:**  main 메서드 구현 (ab94a75b)
* **CalculatorController:**  CalculatorController 구현 (0c87824d)
* **OutputView:**  OutputView 구현 (61b2990d)
* **InputView:**  InputView 구현 (79b0ac16)
* **CalculatorFacadeImpl:**  CalculatorFacade 구현체 구현 (7899f50a)
* **CalculatorFacade:**  CalculatorFacade 인터페이스 정의 (4101a160)
* **Calculator:**  Calculator 도메인 구현 (525cfe6b)
* **Numbers:**  Numbers 도메인 구현 (e1bda70f)
* **InputStringValidator:**  StringValidator 구현체 구현 (21487a1a)
* **StringValidator:**  StringValidator 인터페이스 정의 (60230ed7)
* **InputStringConvertor:**  StringConvertor 구현체 구현 (320fbb5f)
* **StringConvertor:**  StringConvertor 인터페이스 정의 (3256585f)
* **InputStringParser:**  StringParser 구현체 구현 (fe7d7cf9)
* **StringParser:**  StringParser 인터페이스 정의 (60956a53)
* **ErrorType:**  에러 타입 및 메시지 정의 (1f9fecfb)
* **NumberRange:**  숫자 범위 최소, 최대 정의 (61c194cb)
* **Delimiter:**  상수 정의 (beb37318)
*  setup project (d0a82b7d)

##### Refactors

* **Numbers:**  구분자 정규표현식 정의하는 부분 및 필드명 수정 (e6457b10)
* **InputStringParser:**
  *  구분자 정규표현식 가져오는 메서드 구현 (3d18fa63)
  *  extractTokens 수정 (36c16340)
  *  extractCustomDelimiter 수정 (def56976)
* **StringParser:**  구분자 정규표현식 가져오는 메서드 정의 (ce2ce209)
* **Delimiter:**
  *  기본 구분자 정규표현식 추가 (3daafb47)
  *  커스텀 구분자 형식 수정 (57ead14d)
  *  백슬래시 구분자 추가 (43786f27)

##### Tests

* **CalculatorControllerTest:**
  *  리팩토링 내용 반영하여 테스트 (02f91fdd)
  *  CalculatorController 테스트 (b2935be4)
* **CalculatorTest:**
  *  sumIntegerTest() 설명 수정 (956daf43)
  *  Calculator 테스트 (ceecbc03)
* **InputStringValidatorTest:**
  *  리팩토링된 내용 반영하여 테스트 (9e2bd30b)
  *  InputStringValidator 테스트 (022dcaa1)
* **NumbersTest:**  Numbers 테스트 (83fd4b18)
* **InputStringConvertorTest:**  InputStringConvertor 테스트 (b05777a9)
* **InputStringParserTest:**  InputStringParser 테스트 (4c80909e)

