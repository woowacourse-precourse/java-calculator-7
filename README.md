# java-calculator-precourse

# 🔢문자열 덧셈 계산기

<br/>

## 🔍기본 과제 요약

1. 기본 구분자로 ;와 ,를 사용합니다.
2. 커스텀 구분자를 추가할 수 있습니다.
3. 입력된 숫자들의 합을 계산하여 반환합니다.

<br/>

## 🔧 미션 구현 방식
1. 입력 문자열 검증
2. 커스텀 구분자 추가 여부 확인
3. 커스텀 구분자 추출 후 추가
4. 구분자를 이용해 문자열 분리
5. 분리된 문자열을 숫자로 반환 및 유효성 검사
6. 숫자들의 합 계산
7. 결과 반환

<br/>

## 📂 파일 구조도
``` 
└─src
    ├─main
    │  └─java
    │      └─calculator
    │          │  Application.java
    │          │
    │          ├─constant
    │          │      ValidConstants.java
    │          │      ViewConstants.java
    │          │
    │          ├─controller
    │          │      CalculateController.java
    │          │
    │          ├─exception
    │          │      InputValidationException.java
    │          │
    │          ├─model
    │          │      Numbers.java
    │          │      Separator.java
    │          │
    │          ├─service
    │          │      CalculateService.java
    │          │      SplitService.java
    │          │
    │          ├─validator
    │          │      InputValid.java
    │          │
    │          └─view
    │                  InputView.java
    │                  OutputView.java
    │
    └─test
        └─java
            └─calculator
                    ApplicationTest.java
                    ControllerTest.java
                    ServiceTest.java
                    ViewTest.java

```


## 📚 패키지 설명

1. **calculator**: 메인 패키지
    - `Application.java`


2. **constant**: 상수 정의
    - `ValidConstants.java`: 유효성 검사 관련 상수
    - `ViewConstants.java`: 입 출력 관련 상수
   

3. **controller**: 사용자 입력 처리 및 비즈니스 로직 연결
    - `CalculateController.java`: 계산 전 과정 제어


4. **exception**: 사용자 정의 예외
    - `InputValidationException.java`: 입력 유효성 검사 예외 메시지


5. **model**: 데이터 모델
    - `Numbers.java`: 숫자 데이터 관리
    - `Separator.java`: 구분자 관리


6. **service**: 비즈니스 로직
    - `CalculateService.java`: 실제 계산 수행
    - `SplitService.java`: 문자열 분리 로직
   

7. **validator**: 입력 유효성 검사
    - `InputValid.java`: 사용자 입력 검증
    

8. **view**: 사용자 인터페이스
    - `InputView.java`: 사용자 입력 처리
    - `OutputView.java`: 결과 출력

<br/>


## 🧪 테스트 설명

1. **ApplicationTest.java** : 전체 애플리케이션의 통합 테스트
    - 사용자 입력부터 결과 출력까지의 전체 흐름을 테스트
   

2. **ControllerTest.java** : 컨트롤러 로직 테스트
    - 사용자 입력 처리와 서비스 계층 연동이 올바르게 작동하는지 확인
   

3. **ServiceTest.java** : 비즈니스 로직 테스트
    - 계산 및 문자열 분리 로직이 동작 검증
   

4. **ViewTest.java**: 사용자 인터페이스 테스트
    - 입력 처리와 결과 출력이 올바르게 이루어지는지 확인


<br/>

## ✅ 유효성 검사

```java
public static void checkStringLength(String str) {
    if (str.length() > ValidConstants.MAX_TOTAL_LENGTH) {
        throw new IllegalArgumentException(InputValidationException.TOO_LONG_STRING.getMessage());
    }
    if (str.isEmpty()) {
        throw new IllegalArgumentException(InputValidationException.EMPTY_STRING.getMessage());
    }
}
```

### 상수 관리

- 유효성 검사에 사용되는 상수들은 `ValidConstants` 클래스에서 관리

### 예외 메시지

- 예외 메시지는 `InputValidationException` enum 클래스에서 관리


## 🔄 DI - singleton
- 주요 service 클래스와 controller 클래스에 싱글톤 패턴 적용

```java
    private static CalculateService instance;

    private CalculateService() {
    }

    public static CalculateService getInstance() {
        if (instance == null) {
            instance = new CalculateService();
        }
        return instance;
    }
```
