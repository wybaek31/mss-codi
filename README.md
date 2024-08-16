# mss-codi

## 구현 범위에 대한 설명
- 과제 내용에 있는 아래의 내용에 대해서 API 구현.
    - 고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다. 
    - 고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다. 
    - 고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다. 
    - 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.


- 프로젝트 구조를 core, admin, api 3개의 모듈로 나누어 구현.
    - core : 도메인 모델 및 공통 로직 구현.
    - admin : 운영자 관련 API 구현.
    - api : 서비스 관련 API 구현.



## 기술스택

- Java 21, Spring Boot, JPA, Redis(Embedded), H2(Embedded)

## 빌드 및 실행

- IDE : IntelliJ IDEA
    - Run > Run Configuration > Active Profile : local

- H2 Database Console
    - URL : `http://localhost:8080/h2-console` or `http://localhost:8081/h2-console`
    - JDBC URL : `jdbc:h2:./database/mss-codi-db`
    - User Name : `sa`

- 실행 테스트를 위한 테스트 요청 정보
  - /http/admin-brand.http : 브랜드 등록 API 테스트
  - /http/admin-product.http : 상품 등록,수정,삭제 API 테스트
  - /http/api-category.http : 최저, 최고 가격 브랜드와 상품 가격 조회 API 테스트
  - /http/api-product.http : 카테고리 별 최저가 브랜드, 상품 조회 API, 모든 카테고리 구매시 최저가 브랜드 조회 API 테스트


- Swagger 문서
  - Admin URL : `http://localhost:8081/swagger-ui/index.html`
  - API URL : `http://localhost:8080/swagger-ui/index.html`

