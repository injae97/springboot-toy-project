## 💡 SpringBoot-Record (CRUD)
- Spring boot + JSP + Mybatis(Oracle) + Spring Tool Suite (IDE)

## 💡 Spring Tool Suite Download 
https://github.com/spring-projects/sts4/wiki/Previous-Versions

    - 컨트롤 + F > Spring Tools 4.13.1 > spring-tool-suite-4-4.13.1.RELEASE-e4.22.0-win32.win32.x86_64.zip
        
## 💡 Spring Tool Suite Project Create
    - File > New > Spring Starter Project
        - Service URL: https://start.spring.io
        - Name: SpringBoot-Record
        - Type: Maven 
        - Packaging: War
        - Java Version: 8
        - Language: Java
        - Group: com.spring.boot
        - Artifact: SpringBoot-Record
        - Version: 0.0.1-SNAPSHOT
        - Description: SpringBoot-Record
        - Package: com.spring.boot
        
    - Dependencies
        - Spring Boot Version: 2.7.8
        - Available: Spring Web > Finish
        
## 💡 HOW TO AUTO IMPORT WITH SHORTCUT KEYS?
    - Ctrl + Shift + O

## 💡 HOW TO IMPORT DEPENDENCIES ON MAVEN? 
    - https://mvnrepository.com/
        - 해당 링크에서 추가 하려는 의존성을 검색 > 버전 클릭 > Maven > 복사한 후 pom.xml 
        - pom.xml 오른쪽 마우스 > Maven > Update > Force Update of ~ 
        
        <!-- https://mvnrepository.com/artifact/org.apache.tomcat.embed/tomcat-embed-jasper -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
        
## 💡 Guide
    [2023-01-26]
    a.  webapp에 필요한 디렉토리 생성
        1. /src/main/webapp/index.html 에 index.html 생성
        2. /src/main/webapp/WEB-INF    
        3. /src/main/webapp/WEB-INF/views
            - /src/main/webapp/WEB-INF/views/html
                - 해당 경로에 테스트 목적으로 hello.html 생성
                * http://localhost:8080/html/hello.html 로 확인 가능
            - /src/main/webapp/WEB-INF/views/jsp
                - 해당 경로에 테스트 목적으로 hello.jsp 생성
                * http://localhost:8080/jsp/hello.jsp 로 확인 가능
    
    b. spring 환경 설정 
        - /src/main/resources/application.properties
            
            # port setting
            server.port = 8090
    
    c. BootStrap
        - https://getbootstrap.com/docs/5.3/getting-started/introduction/
            - Quick start > 2번 복사 > /src/main/webapp/base/bootstrap.html 에 붙여줌
                - 그런 후 bootstrap example에 들어가서 마음에 드는 UI 일부분 Ctrl + Shift + C 로 확인 후 페이지 소스보기 > 복사 > bootstrap.html에 붙여줌
                * Headers, Heroes, Footers
                
        - grid example(record.html, member_list.html)
            * https://getbootstrap.com/docs/5.3/layout/grid/ 
            
        - Sign-in example(login.html)
            * https://getbootstrap.com/docs/5.3/examples/sign-in/
        
        * Source file download
            - https://getbootstrap.com/docs/5.3/getting-started/download/
                - Source files, Examples download
                - "bootstrap-5.3.0-alpha1-examples\bootstrap-5.3.0-alpha1-examples\sign-in\sign-in.css"
                - /src/main/webapp/css/sign-in.css 폴더 생성 후 넣어줌