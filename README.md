# java-calculator-precourse

# 기능 구현 목록 정리

* 문자열 계산기 기능 구현 목록 정리

---

**계산기 동작 시나리오**

1. [InputView] : 문자열을 입력 받는다.
2. [StringParser] : 문자열에 따라 커스텀 구분자 경우인지, 기본 구분자 경우인지 나눈다. -> 나눈 경우에 따라 리스트 값으로 반환한다.
3. [StringParser] : 커스텀의 구분자의 경우, StringParser 클래스에서 예외처리를 진행한다.
4. [StringCalculator] : 기본 구분자의 경우, StringCalculator 클래스에서 예외처리를 진행한다.(기본 구분자는 "," 또는 ";"으로 구분하기에, 잘못된 값이 들어오면 리스트에 한 번에
   묶여서 들어가게 된다. -> int 형으로 변환하는 과정에서 예외처리 진행)
5. [StringCalculator] : 리스트 값들을 int 형으로 변환하여, 값을 계산한다.
6. [OutputView] : 결과값을 출력한다.

---

### 입력받기

* [X] 문자열을 입력받는다.

### InputNumbers(들어오는 값 원시값 포장)

* [x] 들어온 값을 원시값 포장한다.
* [x] 검증 로직을 구현한다.
    * [x] 빈 값 예외처리를 진행한다.
    * [x] 마지막에 구분자가 들어있는 경우 예외처리를 진행한다.
    * [x] 커스텀 구분자의 형식을 지키지 않을 경우 예외처리를 진행한다.

### 문자열 Parser

* [X] 들어온 값에 따라, 구분자를 추출한다.
* [X] 구분자 값에 따라, 리스트로 반환한다.

* 구분자가 쉼표(,) 또는 콜론(:)일 경우 - 기본(standard 경우로 가정한다.)
    * [X] 쉼표(,) 또는 콜론(:)을 구분하여 숫자를 리스트에 담아 반환한다.

* 구분자가 커스텀 구분자에 해당할 경우
    * [X] 추출한 커스텀 구분자로 구분하여 숫자를 리스트에 담아 반환한다.

### 문자열 계산기

* [X] 리스트의 값을 모두 더한다.
    * [X] 숫자 값이 아닌 형태가 있으면 ```IllegalArgumentException```을 발생시킨다.
    * [X] 숫자가 음수이면 ```IllegalArgumentException```을 발생시킨다.

### 출력하기

* [X] 숫자를 출력한다.

### 조립하기

* [X] 컨트롤러해서 해당 메서드 들을 알맞게 조립한다.

### 동작시키기

* [X] Application 에서 동작시키는 로직을 구현한다.

### 테스트하기

* [X] 각 로직에 대한 테스트를 진행한다.
    * **문자열 Parser**
        * [X] 예외처리 테스트를 진행한다.
        * [X] 올바른 경우 테스트를 진행한다.

    * **문자열 계산기**
        * [X] 예외처리 테스트를 진행한다.
        * [X] 올바른 경우 테스트를 진행한다.

    * **Application** - mission-utils 문서를 참고하여 테스트를 진행한다.
        * [X] 예외처리 테스트를 진행한다.
        * [X] 올바른 경우 테스트를 진행한다.

---

### 예외처리

##### 들어올 수 있는 문자열 : [기본 구분자]

* 빈 값 -> StringParser 에서 예외처리(처리 완료)
* 1,2;3 기본 구분자 형식 -> 정상 동작(처리 완료)
* 1,-2;3 음수가 포함된 형식 -> StringCalculator 에서 예외처리(처리 완료)
* 1,2?3 기본 구분자가 아닌 형식 -> StringCalculator 에서 예외처리(처리 완료)
* 1,2,a 형식에 다른 문자가 포함된 경우 -> StringCalculator 에서 예외처리(처리 완료)
* 1,2,3,, 마지막이 기본 구분자가 붙는 경우 -> InputNumber 에서 예외처리(처리 완료)

##### 들어올 수 있는 문자열 : [커스텀 구분자]

* 빈 값 -> StringParser 에서 예외처리(처리 완료)
* //;\1;2;3 완성되지 않은 형식 -> "\\" 혹은 "/"가 빠질 경우 StringParser 에서 예외처리(처리완료), 다른 문자의 경우 StringCalculator 에서 예외처리(처리완료)
* //;1n1;2;3 단일 구분자 형식 -> 정상 동작(처리 완료)
* //;;1;;2;;3 연속된 구분자 형식 -> 정상 동작(처리 완료)
* //?\n1?2?3 메타 문자가 구분자인 형식 -> 정상동작(처리 완료)
* //;\n1;-2;3 음수가 포함된 형식 -> StringCalculator 에서 예외처리(처리 완료)
* //1\n1;2;3 구분자가 숫자인 형식 -> StringCalculator 에서 예외처리(처리 완료)
* //\n1;2;3 구분자가 없는 경우 -> StringCalculator 에서 예외처리(처리 완료)
* 1//;\n1;2;3 형식 앞에 숫자가 있는 경우 -> StringCalculator 에서 예외처리 (처리 완료)
* //;\n1?2?3 구분자가 아닌 문자로 나눠진 경우 -> StringCalculator 에서 예외처리 (처리 완료)
* //;\n1;2;3;a 마지막에 다른 문자가 붙는 경우 -> StringCalculator 에서 예외처리 (처리 완료)
* //;\n1;2;3;; 마지막에 구분자가 붙는 경우 -> InputNumber 에서 예외처리(처리 완료)
