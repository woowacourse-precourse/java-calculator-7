# 🖥🙈 java-calculator-precourse
## 💡기능 요구 사항

### 🙉 기능 개요
- 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현.

### 💡기능 요구 사항
#### 🔖 기본 기능
1.  숫자 추출 및 합산
    - 입력 문자열에서 숫자를 추출하여 더하는 기능이 필요.
    - 기본 구분자: 쉼표(,)와 콜론(:).
    - 예시:
        - "" -> 0
        - "1,2" -> 3
        - "1,2:3" -> 6

#### 🔖 추가 기능
2. 커스텀 구분자 지원
    - 사용자가 정의한 구분자를 지원해야함.
    - 커스텀 구분자는 문자열 시작 부분의 //와 \n 사이에 위치하는 문자임.
    - 예시:
        - "//;\n1;2;3" -> 6 `세미콜론(;)을 구분자로 사용한한 예시.

#### 🔖 오류처리
3. 입력 값 검증
    - 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고 어플리케이션 종료.


### 🔖입출력 요구사항 
#### 입력
- 구분자와 양수로 구성된 문자열

#### 출력
- 덧셈 결과.

#### 예시
- 사용자 입력: 1,2:3
    - 테스트 케이스 : 만약 1,2,:3 이런것도 처리 필요할것 같음.
- 출력: 결과 :6

### 🔖프로그래밍 요구사항
- JDK 21 버전에서 실행 가능.
- 프로그램 시작점은 Application의 main() 메서드.
- build.gradle 파일은 변경할 수 없음.
- 제공된 라이브러리 이외의 외부 라이브러리 사용 금지.
- 프로그램 종료 시 System.exit() 호출 금지.
- 파일, 패키지 등의 이름을 변경하거나 이동하지 않음.
- Java 코드 컨벤션 및 스타일 가이드 준수.


### 🔖사용 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Console API 사용.
- 사용자 입력: camp.nextstep.edu.missionutils.Console의 readLine() 메서드 활용.

### 실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```



## 👨‍💻 커밋 큐칙
### 주제 라인
- 형식: <type>(<scope>): <subject>
- 주제 내용: 간결하게 변경 사항 설명


#### 👉 허용된 <type>
- feat (기능)
- fix (버그 수정)
- docs (문서)
- style (형식, 세미콜론 누락 등)
- refactor
- test (테스트 추가)
- chore (유지보수)


#### 👉 허용된 <scope>
- 커밋 변경의 위치를 명시하는 범위. 예: $location, $browser, $compile, $rootScope, 등.


#### 👉 <subject> 텍스트
- 명령형 현재 시제 사용: “change”가 아닌 “changed” 또는 “changes”
- 첫 글자 대문자 사용 금지
- 마침표(.) 사용 금지


#### 메시지 본문
- 명령형 현재 시제 사용
- 변경 동기 및 이전 동작과의 대비 설명
- Close에 이슈 번호를 지정하여 몇번 이슈를 추가하거나 제거하였는지 확인할 수 있도록 작성함 



#### 예시) feat($browser): onUrlChange 이벤트 추가
```
- feat($browser): onUrlChange 이벤트 추가

$browser에 새로운 이벤트 추가:
- 가능할 경우 popstate 이벤트 전달
- popstate가 불가능할 경우 hashchange 이벤트 전달
- 두 이벤트 모두 불가능할 경우 polling 수행

BREAKING CHANGE: $browser.onHashChange가 제거되었습니다. 대신 onUrlChange를 사용해야 합니다.

Closes #1
```