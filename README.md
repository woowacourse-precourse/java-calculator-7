# java-calculator-precourse

# 🧮 문자열 계산기 기능 요구사항


## 🖥️ 입출력 (InputView/OutputView)
- [x] 입력
    - [x] 사용자로부터 입력 받기
- [x] 출력
    - [x] 사용자로부터 입력 받기 전 입력 문구 출력
    - [x] 계산 결과 출력

## 🔤 문자열 처리 (Separator & CustomSeparatorHandler)

- [x] 구분자 처리
    - [x] 기본 구분자(쉼표, 콜론) 정의 및 식별
    - [x] 커스텀 구분자 추출 및 처리
    - [x] "//"와 "\n" 사이에 정의된 커스텀 구분자 추출 (`extractCustomSeparator` 메소드)
    - [x] 문자열에서 커스텀 구분자 정의 제거 (`removeCustomSeparatorDefinition` 메소드)
    - [x] 커스텀 구분자 형식 검증 (잘못된 형식 시 예외 처리)
    - [x] 모든 구분자 목록 생성 (기본 + 커스텀)
- [x] 문자열 파싱
    - [x] 구분자를 이용한 문자열 분할 (`splitByAllSeparators` 메소드)
    - [x] 정규식 생성을 통한 복합 구분자 처리 (`createSeparatorRegex` 메소드)

## 🔢 숫자 처리 (Number & Numbers)
- [x] Numbers 객체 생성 및 합계 계산 (`sumNumbers` 메소드)
	- [x] 문자열을 Number 객체로 변환 (`from` 메소드)
	- [x] Number 객체 간 덧셈 연산 (`add` 메소드)
	- [x] 숫자의 문자열 표현 (`toString` 메소드)
	- [x] Number 객체의 동등성 비교 (`equals` 메소드)
	- [x] Number 객체의 해시코드 생성 (`hashCode` 메소드)

## 🧮 계산 (Calculator)
- [x] 문자열을 입력받고 숫자들의 합계 계산 (`sumNumbersFromString` 메소드)
	- [x] 입력 문자열 검증
	    - [x] 공백 문자 확인 (`isBlank` 메소드)
	    - [x] 빈 문자열 처리 (빈 입력 시 0 반환)
## ⚠️ 예외 처리
- [x] `IllegalArgumentException` 발생 및 처리
    - [x] 유효하지 않은 숫자 형식에 대한 예외 처리("유효하지 않은 숫자 형식입니다: " + value)
    - [x] 잘못된 커스텀 구분자 형식 처리("커스텀 구분자 형식이 올바르지 않습니다.")

## 🚀 확장성
- [x] 새로운 구분자 추가 가능한 확장 가능한 구조
    - [x] 여러 자리의 커스텀 구분자 입력 및 처리 가능
- [x] 다양한 숫자 형식 처리
    - [x] 음수 처리 가능
    - [x] 소수 처리 가능
- [x] 연산 확장
    - [x] 덧셈 외에 다른 계산 기능 추가 시 구조 설계

