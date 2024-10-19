# java-calculator-precourse

## 문자열 덧셈 계산기

- 문자열을 입력받아 구분자에 따라 숫자를 추출하고, 덧셈한 결과를 반환
- 기본 구분자 : 쉼표(,) , 콜론(:)
- 커스텀 구분자 : 입력 시 맨 앞에 "//"와 "\n"사이에 넣어 적용
- 유효하지 않은 입력 시 `IllegalArgumentException` 발생 후 어플리케이션 종료

<br>
  
## 기능 목록
| 기능 ID         |기능|카테고리| 상세기능                                       | 구현           |
|---------------|--|----|--------------------------------------------|--------------|
| JCAL_INPUT_01 |문자열 입력|입력| 문자열을 입력받아 저장                               | 입출력 메서드, 자료형 |
| JCAL_INPUT_02 |커스텀 구분자 적용|입력| 커스텀 구분자(// 와 \n 사이) 저장                     | 정규표현식        |
|JCAL_INPUT_03|유효한 숫자만 추출|입력| 구분자에 따라 숫자 추출                              | split메서드     |
|JCAL_CAL_01|숫자 덧셈|계산| 숫자를 다 더함                                   | 덧셈 연산자       |
|JCAL_PNT_01|결과 출력|출력| 덧셈의 결과를 출력                                 |출력 연산자|
|JCAL_EXEP_01|예외 처리|예외처리| `IllegalArgumentException` (Invalid input) |try/catch|

<br>

---

## Test Cases

테스트 함수명은 다음과 같은 것을 의미합니다.

- Custom()\_Number()\_Delimiter()
  - CustomN : N개의 커스텀 구분자 정의
  - NumberN : N개의 숫자
  - DelimiterN : N개의 구분자
    를 가진 입력값을 의미합니다.
  - e.g. Custom0_Number0_Delimiter0() : 빈 문자열 입력 테스트 케이스
  - e.g. CustomString_Number1_Delimiter2() : 문자열 커스텀 구분자 정의 1개, 1개의 숫자와 2개의 구분자

| Custom          | Number                  | Delimiter | 입력                   | 예상 출력   |
| --------------- | ----------------------- | --------- | ---------------------- | ----------- |
| 0               | 0                       | 0         |                        | 결과 : 0    |
| 0               | 1                       | 0         | 3492                   | 결과 : 3492 |
| 0               | 2                       | 2         | 3;4;93                 | 결과 : 100  |
| 0               | 0                       | 2         | :,                     | 결과 : 0    |
| 1               | 0                       | 0         | //;\n                  | 결과 : 0    |
| 1               | 1                       | 0         | //;\n34                | 결과 : 34   |
| 1               | 2                       | 1         | //;\n3;4               | 결과 : 7    |
| 1               | 0                       | 3         | //;\n;;:               | 결과 : 0    |
| 2               | 0                       | 0         | //;\\n//'\\n           | 결과: 0     |
| 2               | 3                       | 3         | //;\n//’\n3;4’93:      | 결과 : 100  |
| 문자열          | 1                       | 2         | //;mz\n//’34\n’34;mz93 | 결과 : 93   |
| 이스케이프 문자 | 3                       | 2         | //;\n//\t\n3\t4;93     | 결과 : 100  |
| 2               | 커스텀 정의 사이1,그외2 | 1         | //;\n3:4//’\n93        | 결과 : 100  |

<br>

---

## Commit Convention

> [!NOTE] > [Angular 9 Commit Message Format](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#type) 를 참고하였습니다.

<br>

```shell
<type>(<scope>): <short summary>
```

#### \<type>

- `feat`: 새로운 기능
- `fix`: 버그 수정
- `docs`: 문서
- `refactor`: 코드 리팩토링
- 등

#### \<scope>

- \<scope>는 변경되거나 추가된 함수의 이름을 의미합니다.

#### \<short summary>

- 명령문으로 작성합니다.
- 마지막에 .(dot)을 포함하지 않습니다.

- - 커밋에 대한 부가 설명은 다음과 같은 형식을 따릅니다.
  * `기능_ID` - 부가설명
  * 예시 : JCAL_INPUT_01- Get input by readline

#### commit e.g.

```shell
feat(getInput): JCAL_INPUT_01- Get input by readline
```

> [!NOTE]
>
> - 로 표시한 것은 해당 저장소에서의 convention 입니다.

###

[Angular 9 Commit Message Format](https://github.com/angular/angular/blob/main/CONTRIBUTING.md#type)을 참고하였습니다.
