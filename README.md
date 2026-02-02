# MyBatis FileUpload
> **Spring Framework & MyBatis 기반의 상품 파일 업로드 실습**

Spring MVC 환경에서 MyBatis를 활용한 정교한 데이터 매핑과 **MultipartFileUpload**를 통한 멀티미디어 데이터 처리를 완벽하게 구현했습니다.

---

## 🛠 Tech Stack
| Category | Tech Stack |
| :--- | :--- |
| **Framework** | Spring Framework (Legacy) |
| **ORM** | MyBatis (XML Mapping) |
| **Language** | Java 17 |
| **Database** | Oracle DB (XE 21c) |
| **Frontend** | JSP, JSTL, CSS3 (T1 Official Dark Theme) |
| **Library** | Lombok, Slf4j, Jakarta Multipart |

---

## 주요 구현 기능 (Key Features)

### 1. 파일 업로드 시스템 (File Management)

- **Multipart Data Handling:** `Item` 도메인을 활용한 상품 이미지 업로드 및 서버 저장.
- **Custom UI Input:** 브라우저 기본 UI를 탈피한 T1 테마의 커스텀 파일 업로드 인터페이스 구축.
- **Image Mapping:** 업로드된 이미지와 DB 데이터 간의 1:1 매핑 및 조회 처리.

### 2. Oracle DB 설계 - 자동 ID 부여
DROP TABLE ITEM;
CREATE TABLE ITEM(
    ID NUMBER(5),
    NAME VARCHAR2(100),
    PRICE NUMBER(6),
    DESCRIPTION VARCHAR2(500),
    URL VARCHAR2(300),
    PRIMARY KEY (ID)
);
DROP SEQUENCE ITEM_SEQ;
CREATE SEQUENCE ITEM_SEQ
START WITH 1
INCREMENT BY 1;

### 3. UI/UX 디자인 (T1 Branded)
- **T1 Signature Color:** `#E2012D`(Red), `#0F0F0F`(Black), `#C69C6D`(Gold) 적용.
- **Modern Interface:** 시각적 피드백을 주는 `50px` 높이의 시원한 입력 필드와 반응형 카드 레이아웃.

---

## Project Structure
```text
src/main/java
 └── com.zeus
      ├── controller   # 요청 매핑 및 파일 처리 (ItemController, MemberController)
      ├── domain       # 데이터 객체 및 MultipartFile 정의 (Item, Users, AuthVO)
      ├── mapper       # MyBatis XML 인터페이스 매핑
      └── service      # 비즈니스 로직 및 파일 저장 로직
      
src/main/webapp
 └── WEB-INF/views     # T1 테마 기반 JSP (create, list, detail 등)
