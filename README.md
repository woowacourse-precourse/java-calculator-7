# java-calculator-precourse

문자열 덧셈 계산기

## 기능 목록
1. **입력받은 문자열에서 숫자를 추출하는 기능**
   - 쉼표(`,`) 또는 콜론(`:`)을 구분자로 사용하여 문자열을 숫자로 분리합니다.
   - 분리된 숫자를 모두 더한 값을 반환합니다.
   - 입력이 빈 문자열인 경우 0을 반환합니다.

2. **커스텀 구분자 지정 기능**
   - 문자열 앞부분에 `//`와 `\n` 사이에 위치한 문자를 커스텀 구분자로 사용합니다.
   - 예: `//;\n1;2;3` -> 커스텀 구분자 `;`로 숫자를 분리하고 더합니다.

3. **잘못된 입력값 처리 기능**
   - 입력된 값이 올바르지 않은 경우 `IllegalArgumentException`을 발생시킵니다.
   - 예: 숫자가 아닌 문자가 포함된 경우, 음수 숫자가 포함된 경우 등

4. **계산된 결과를 출력하는 기능**
   - 계산된 합계를 콘솔에 출력합니다.
   - 예: `결과 : 6`

5. **사용자 입력 처리 기능**
   - 사용자에게 문자열을 입력받습니다.
   - `camp.nextstep.edu.missionutils.Console.readLine()` 메서드를 사용해 입력을 받습니다.

## 실행 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 커밋 메시지 규칙
- 커밋 메시지는 [AngularJS Git Commit Message Conventions](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#-git-commit-guidelines)를 따릅니다.
  - `feat`: 새로운 기능 추가
  - `fix`: 버그 수정
  - `refactor`: 코드 리팩토링
  - `test`: 테스트 코드 관련 변경
  - `docs`: 문서 추가 및 수정
  - `style`: 코드 포맷팅, 세미콜론 누락, 공백 수정 등

## 테스트 실행 방법
- 터미널에서 `./gradlew clean test` (Mac/Linux) 또는 `gradlew.bat clean test` (Windows)를 실행해 모든 테스트가 성공하는지 확인합니다.

## 주의 사항
- 요구 사항에 맞지 않는 출력 형식을 사용하면 0점 처리됩니다.
- 잘못된 입력에 대해 반드시 `IllegalArgumentException`을 발생시켜야 합니다.
- JDK 21에서 정상적으로 동작해야 하며, 제공된 외부 라이브러리 이외의 추가 라이브러리는 사용할 수 없습니다.
