# what i learn
```text
1. preference의 gradle 설정을 build시 intellij 사용하도롥 설정
2. root에서
    - ./gradlew build
    - cd build/libs
    - java -jar hello-spring-0.0.1-SNAPSHOT.jar
    와 같이 배포 환경에서 jar파일 실행 하면 된다.
    - ./gradlew clean -> 빌드한 파일 삭제 한다.
3. controller, service, repository 등록하는 방법
 - 1. @Service, @Repository 로 등록 (@Autowired)
 - 2. Config 로 @Bean 등록
 - 3. DI에는 field, Constructor, Setter주입 이렇게 세가지가 있는대
  field is bad, Setter is mutable s
  Best practice is constructor injection
```