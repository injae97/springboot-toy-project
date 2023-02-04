## 💡 SpringBoot-Toy-Project Env
    - Framework: Spring boot
    - View: JSP
    - DBMS: Oracle
    - Mapper: MyBatis
    - IDE: Spring Tool Suite
    
## 💡 Spring Tool Suite Download 
https://github.com/spring-projects/sts4/wiki/Previous-Versions

    - 컨트롤 + F > Spring Tools 4.13.1 > spring-tool-suite-4-4.13.1.RELEASE-e4.22.0-win32.win32.x86_64.zip
        
## 💡 Spring Tool Suite Project Create
```java
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
```        
    
## 💡 HOW TO AUTO IMPORT WITH SHORTCUT KEYS?
    - Ctrl + Shift + O
    
## 💡 HOW DO AUTOMATICALLY TRANSLATE ENGLISH THROUGH DRAG?
    - https://chrome.google.com/webstore/detail/google-translate/aapbdbdomjkkjkaonfhkkikfgjllcleb?hl=ko
        - 확장 추가 > 확장 프로그램에서 Google 번역 오른쪽 마우스 > 옵션 > 즉시 팝업을 표시합니다. > 저장
            - 재부팅 후 영어 문장에 드래그만 한번 해주면 자동으로 번역된 팝업창 나옴

## 💡 HOW TO IMPORT DEPENDENCIES ON MAVEN?
```java
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
```
