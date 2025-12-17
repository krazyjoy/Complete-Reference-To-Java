# ApplicationContext Interface
The interfaces of *BeanFactory* and *ApplicationContext* represent the Spring IoC container.

- BeanFactory - the root interface for accessing the spring container 
- ApplicationContext - a sub-interface of BeanFactory, resolves messaging, supporting internalization, publishing events, and application-layer specific contexts

A bean is an object that the Spring Container instantiates, assembles and manages

The primary job for ApplicationContext is to manage beans.

## Configure Beans in the Container
1. Java-based configuration
    ```java
    @Configuration
    public class AccountConfig {

        @Bean
        public AccountService accountService() {
            return new AccountService(accountRepository());
        }

        @Bean
        public AccountRepository accountRepository() {
            return new AccountRepository();
        }
    }
    ```
2. Annotation-based configuration
    ```java
    @Component
    public class UserService {
        // user service code
    }
    ```
    - a test case
    ```java
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/user-bean-config.xml");

    UserService userService = context.getBean(UserService.class);
    assertNotNull(userService);
    ```

## Types of ApplicationContexts
1. AnnotationConfigApplicationContext
    - takes @Configuration, @Component and JSR-330 metadata as input
    ```java
    ApplicationContext context = new AnnotationConfigApplicationContext("AccountConfig.class");
    
    AccountService accountService = context.getBean("AccountService.class");
    ```

2. AnnotationConfigWebApplicationContext
    - a web-variant of AnnotationConfigApplicationContext
    ```java
    public class MyWebAppInitializer implements WebAppInitializer{
        public void onStartup(ServletContext Container) throws ServletException{
            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

            context.register(AccountConfig.class);
            context.setServletContext(container);

            // servlet configuration

        }
    }
    ```

3. ClassPathXmlApplicationContext
    - load an XML configuration file from classpath
    ```java
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext/account-bean-config.xml");

    AccountService accountService = context.getBean("accountService", AccountService.class);
    ```

## Showcase 
1. Create a Spring Project w/ Spring Initializer:
    - package name: `com.gfg.demo`

2. Create a Student class under `com.gfg.demo.domain`
    ```java
    public class Student{
        private int id;
        private String name;

        public Student(){};
        public Student(int id, String name){
            this.id = id;
            this.name = name;
        }
        @Override
        public String toString(){
            return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }
    ```
3. Create an App class that contains all Java Beans
    ```java
    @Configuration
    public class AppConfig{
        @Bean
        public Student student(){ // bean name is first char lower cased of Bean class
            return new Student(1, "Geek");
        }
    }
    ```
3. MainApplication class contains the creation of a container (at root)
    - `SpringBootApplication` creates the container, creates beans, manages dependency injection and life cycle of those beans
    ```java
    @SpringBootApplication
    public class DemoApplication{
        ApplicationContext context = SpringApplication.run(
            DemoApplication.class,
            args
        );
        Student student = context.getBean(Student.class);
        System.out.println(student);
    }
    ```