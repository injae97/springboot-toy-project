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
                
    
    [2023-01-27]
    a. MVC 흐름
        - Request > 1. Controller > 2. Model > 3. View
		    * WAS : Controller, Model, View
    
    b. Home Page Setting
        a. src/main/java/com/spring/boot/controller(package create)
        b. src/main/java/com/spring/boot/controller/Home.java(class create)
            - @Controller : 내가 바로 컨트롤러다.
            - @RequestMapping : @RequestMapping("/")로 들어오면 return jsp file 화면을 보여주겠다.  
            
            
## 💡 forward(request) vs sendRedirect(response)
    - HTTP 통신으로 생각
    - forward(request): forward는 request를 계속적으로 던져주는 것 (WAS 내부에서만 요청자가 입력한 값을 던져줌)
        * 통로를 통해 진입한 곳은 경로가 보이지 않는다.
    - sendRedirect(response): response를 다시 다른 곳으로 넘겨주는 것
    
    a. forward(request)  = Spring return "view path"
        - /WEB-INF/views/*.jsp (호출 성공)
        - /jsp/*.jsp (호출 성공)
        - https://www.naver.com (호출 실패 - Error)
        
        * 구조 : 요청자(Client) > request > localhost[WAS] Call > WEB-INF/views/list.jsp        
                
    b. sendRedirect(response) = Spring redirect:/path 
        - /WEB-INF/views/*.jsp (호출 실패 - Error)
            - response는 요청자로 보내줘야하는데 자기 일 끝났다고 요청자 말고 직접 호출시킴(그래서 외부 접속이 됨)
        - /jsp/*.jsp (호출 성공)
        - https://www.naver.com (호출 성공)
		
		
## 💡 Spring - Controller & RestController 에 대한 기본적인 이해
    a. Controller
		@Controller
		@RequestMapping("URL-PATH")
		public String doDefault() {
			return "result"; // result.jsp 화면 렌더링
		}
	
	b. RestController
	    @Controller + @ResponBody = @RestController
		
		/* RestController.class */
		@RestController
		public class RestController {
		
			@RequestMapping("URL-PATH")
			public String doResponse() {
			String strContents = "View : ResponBody!! <HR>  ";
			return strContents;
		    }
	    }
	

    * 1 HTTPServletResponse
	    - java에서 jsp를 만든 것
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println(" View : response Self");
		out.println("</body></html>");
		
	* 2 @ResponBody
		@RequestMapping("URL-PATH")
		@ResponBody
		public String useResponsebody() {
		    String strContents = "View : ResponBody!! ";
			return strContents;
		}
		
	* HTTPServletResponse 소스코드와 @ResponBody 안에 있는 소스코드와 동일