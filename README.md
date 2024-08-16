# mss-codi

## 구현 범위에 대한 설명
- 과제 내용에 있는 아래의 내용에 대해서 API 구현.
    - 고객은 카테고리 별로 최저가격인 브랜드와 가격을 조회하고 총액이 얼마인지 확인할 수 있어야 합니다. 
    - 고객은 단일 브랜드로 전체 카테고리 상품을 구매할 경우 최저가격인 브랜드와 총액이 얼마인지 확인할 수 있어야 합니다. 
    - 고객은 특정 카테고리에서 최저가격 브랜드와 최고가격 브랜드를 확인하고 각 브랜드 상품의 가격을 확인할 수 있어야 합니다. 
    - 운영자는 새로운 브랜드를 등록하고, 모든 브랜드의 상품을 추가, 변경, 삭제할 수 있어야 합니다.


- 프로젝트 구조를 core, admin, api 3개의 모듈로 나누어 Layered Architecture 구조로 구현.
    - core : 도메인 모델 및 공통 로직 구현.
      - domain : 도메인 모델 구현.
      - config : DB, Redis 설정 구현.
      - repository : JPA Repository 구현.
    - admin : 운영자 관련 API 구현.
      - 브랜드 등록, 상품 등록, 수정, 삭제 API 구현.
    - api : 서비스 관련 API 구현.
      - Controller : API 요청 및 응답 처리.
      - Facade : 비즈니스 로직의 조합을 처리.
        - 데이터를 조회시 1차는 캐시에서 2차는 DB에서 조회.
        - Mapper를 활용해서 최종 결과의 오브젝트를 생성.
      - Service : 비즈니스 로직 구현.
- Redis 캐시 관리에 대해서는 API에만 처리하였습니다. 원래는 Admin 에서도 데이터가 변경시에 캐시를 업데이트 되도록 해야하지만, 이 과제에는 API 메소드 레벨에서 TTL(1분)을 설정한 캐시처리를 해주었습니다.


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

