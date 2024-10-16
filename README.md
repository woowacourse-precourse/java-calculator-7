# 프리코스 1주차 : 문자열 덧셈 계산기

## 1. 기초 요구 사항

- 기본 구분자 입력에 대한 덧셈 연산 수행
- 가장 처음 입력된 값이 "//" 라면 "\n" 전까지의 문자를 구분자로 사용하여 덧셈 연산 수행 (사용자 정의 구분자)
- 비정상 입력에 대해 예외처리 후 종료

---

## 2. 구현 기능 목록

- 사용자 입력 요구, 값 입력받기
- 계산 결과 출력
- 정상 입력 여부 판단하기
- 기본 구분자, 사용자 정의 구분자 여부 판단하기
- 구분자에 따라 연산하기
- 예외처리하기

---

## 3. 해결 필요한 예외 사항

- 개행문자 입력으로 인한 비정상 동작 수정 [O]
- 프로젝트 파일 인코딩 오류로 인한 테스트코드 동작 실패 수정 [O]
- 일부 특수문자를 구분자로 사용할 경우 예외 구분자 처리 [0]

- 공백 입력시 exception 처리 [O]

---

## view package

- `inputView` : 사용자 입력 요구, 값 입력받기 [O]
- `outputView` : 계산 결과 출력 [O]

## controller package

- `CalculatorController` : 전체 프로그램 동작 제어 [O]

## model package

- `CalculatorLogic` : 계산기 내부 동작 구성 [0]
    - `extractDelimiter` : 기본 구분자, 사용자 정의 구분자 추출 기능 [O]
    - `extractNumber` : 사용자 입력에서 숫자 추출 기능 [O]
    - `calculate` : 구분자에 따른 연산 기능 [0]

## service package

- `CalculatorService` : 계산기 동작 제어 [0]
    - `calculate` : 계산기 동작 제어 [0]
    
    - validation 내의 검증 기능 추가 필요

## validation package

- `inputValidator` : 입력 구문이 정상 연산 가능한지 판단 - 에러 반환

---

- 각 class 주요 메서드 구현 시 단위 테스트 진행
- git commit 컨벤션 지킬 것
- `README.md` 파일에 구현 기능 목록 최신화
- 자바 코드 컨벤션 지킬 것
