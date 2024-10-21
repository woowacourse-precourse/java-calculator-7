# java-calculator-precourse

## 기능 구현 순서

### 1. 입출력 처리
- camp.nextstep.edu.missionutils.Console 의 readLine을 이용하여 사용자의 입력을 받는다.

### 2. 커스텀 구분자 존재 유무 확인 및 예외 처리
- hasCustomDelimiter를 통한 커스텀 구분자 존재 유무 확인
- 예외 처리
  - 커스텀 구분자가 공백인 경우 예외 처리
  - 커스텀 구분자가 문자열인 경우 예외 처리(문자만 받는 경우만 통과)
  - 커스텀 구분자 형식이 유효하지 않을 경우 예외 처리

### 3. 기본 구분자 확인
- hasCustomDelimiter를 통해 기본 구분자 확인

### 4. 숫자 추출

### 5. 추출 후 숫자 연산
- stream을 통해 받는 과정에서 추출한 숫자 중 음수가 존재한다면 예외 처리
- orElseThrow를 통해 숫자가 존재하지 않으면 예외 처리
- sum 을 실행하는 과정에서 숫자로 변환할 수 없는 값이 포함되어 있으면 예외 처리

## 요구사항 체크
- jdk 21 확인
- camp.nextstep.edu.missionutils.Console.readLine() 사용 확인
- ./gradlew clean test 통과 확인
- 자바 코드 컨벤션 확인
- 외부 라이브러리 미사용 확인