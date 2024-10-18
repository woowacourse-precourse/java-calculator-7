# java-calculator-precourse

==============================================
## 개요
- 우테코 프리코스 1주차 미션 : 문자열 덧셈 계산기
- 사용자가 입력한 문자열에서 구분자를 기준으로 숫자를 추출하여 합산한 결과를 출력하는 계산기 입니다.
===
## 기능
### 1. 메인: Application Class
- 역할: Controller Class의 메서드를 호출합니다.
- 구성: main() 메서드가 있습니다.
- 예외 처리: 호출한 메서드에서 IllegalArgumentException이 발생한 경우 프로그램이 종료됩니다.
---
### 2. 조작: Controller Class
- 역할: Input, Checker, Cleaner, Calculator, Output Class의 메서드를 조건에 따라 차례로 호출합니다.
- 구성: controlFlow() 메서드가 있습니다.
- 예외 처리: 호출한 메서드에서 예외가 발생한 경우 catch하여 IllegalArgumentException을 발생시켜 상위 메서드로 던집니다.
---
### 3. 입력: Input Class
- 역할: Console API를 사용해 사용자로부터 문자열을 입력받습니다.
- 구성: requestInput() 메서드가 있습니다.

### 4. 출력: Output Class
- 역할: 합산 값을 형식에 맞추어 사용자에게 출력합니다.
- 구성: formatOutput() 메서드가 있습니다.
---
### 5. 확인 로직: Checker Class
- 역할: 문자열을 확인하고 구분자를 찾아서 추출합니다.
- 구성: checkIsNotString(), checkIsSingleNumber(), checkCustomSeparator(), checkDefaultSeparator() 메서드가 있습니다.
- 예외 처리: 구분자 형식이 올바르지 않은 경우 IllegalArgumentException을 발생시켜 상위 메서드로 던집니다.

### 6. 가공 로직: Cleaner Class
- 역할: 문자열과 구분자를 전처리합니다.
- 구성: refineString(), refineSeparator() 메서드가 있습니다.

### 7. 계산 로직: Calculator Class
- 역할: 구분자를 기준으로 문자열에서 숫자를 추출해 합산합니다.
- 구성: calculateSingleValue(), calculateString() 메서드가 있습니다.
- 예외 처리: 문자열 형식이 올바르지 않은 경우 NumberFormatException을 발생시켜 상위 메서드로 던집니다.
---
### 8. 저장: StringData Class, SumData Class
1) StringData Class:
    - 역할: 문자열과 구분자 데이터를 저장합니다.
    - 구성: inputString, separator, hasCustomSeparator 멤버 변수가 있습니다.
2) SumData Class:
    - 역할: 합산된 숫자 값 데이터를 저장합니다.
    - 구성: sumData 멤버 변수가 있습니다.
---
### 9. 테스트: ApplicationTest Class
1) 정상 작동 테스트:
<details>
    <summary>빈 문자열</summary>
    - 정상_빈_문자열_입력_널문자: "\0"<br>
    - 정상_빈_문자열_입력_개행문자: "\n"
</details>

<details>
    <summary>디폴트 구분자</summary>
    - 정상_디폴트_구분자_단일_정수값: "7"<br>
    - 정상_디폴트_구분자_단일_실수값: "7.15"<br>
    - 정상_디폴트_구분자_복수_실수값: "1.2:2.3"
    <br>
    - 정상_디폴트_구분자_단일_구분자: "1,"<br>
    - 정상_디폴트_구분자_혼합_구분자: "1:2,3"
</details>

<details>
    <summary>커스텀 구분자</summary>
    - 정상_커스텀_구분자_빈_문자열:    "//;\\n"<br>
    - 정상_커스텀_구분자_미사용_정수값:  "//;\\n1"<br>
    - 정상_커스텀_구분자_미사용_실수값   "//;\\n1.15"
    <br>
    - 정상_커스텀_구분자_단일_정수값: "//!\\n1!"<br>
    - 정상_커스텀_구분자_단일_실수값: "//;\\n1.15;"<br>
    - 정상_커스텀_구분자_복수_실수깂: "//;\\n1;4.2"
    <br>
    - 정상_커스텀_구분자_특수기호: "//(\\n1(2"<br>
    - 정상_커스텀_구분자_한글기호: "//ㅎ\\n1ㅎ2"<br>
    - 정상_커스텀_구분자_문장부호: "//\"\\n1\"2"
    <br>
    - 정상_커스텀_구분자_음수부호: "//-\\n1-2"<br>
    - 정상_커스텀_구분자_소수점: "//.\\n1.2"<br>
    - 정상_커스텀_구분자_공백문자: "// \\n1 2"
</details>

2) 예외 처리 테스트:
<details>
    <summary>빈 문자열</summary>
    - 예외_빈_문자열_입력_탭문자: "\\t"<br>
    - 예외_빈_문자열_입력_공백문자: " "
</details>
    
<details>
    <summary>디폴트 구분자</summary>
    - 예외_디폴트_구분자_음수값: "-1,2,3"<br>
    - 예외_디폴트_구분자_미사용: "2;3"
</details>

<details>
    <summary>커스텀 구분자</summary>
    - 예외_커스텀_구분자_문자혼용: "//;\n1;&2;3"<br>
    - 예외_커스텀_구분자_숫자사용: "//7\n17273"<br>
    - 예외_커스텀_구분자_형식_시작_미준수: "&\n1&2"<br>
    - 예외_커스텀_구분자_형식_마감_미준수: "//&1&2"
</details>