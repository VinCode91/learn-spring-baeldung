# Project Configuration

This is the codebase for Module 'Project Configuration' of [Learn Spring](https://www.baeldung.com/learn-spring-course)

## M3L3
property *logging.level.root* allows to tune logging level in spring boot apps which use logback by default

different logging levels can be configured for packages, using *logging.level.packagename* property

To **print log statements in a log file**: *logging.file.name=app.log* To **change date format of logs** : *logging.pattern.dateformat=yyyy-MM-dd*

## M3L5
*@SpringJUnitConfig(value = {TestConfig.class})* is the combination of *@ExtendWith(SpringExtension.class)* and *@ContextConfiguration(classes = {TestConfig.class})*
*TestConfig class may of course be annotated with @ComponentScan*

@SpringJUnitConfig is **ideal for targeted integration tests**

### @DirtiesContext
Spring framework caches the context so that it’s not reloaded for every test.
However, there might be some tests which may intend to modify the application context, leading to side effects on other tests.
In such cases we can **notify the framework to close and recreate the context for later tests**.
This is done by using the @DirtiesContext annotation at the test class or method level.

the *MockitoAnnotations#initMocks* directive has been deprecated in favor of *openMocks* since Spring Boot 2.4 onwards

    private AutoCloseable closeable;

    @BeforeEach
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

## M3L6
Simply put, **PropertySource is an annotation used to configure additional sources of properties** – i.e. additional property files – for our Spring Environment.

Similarly, TestPropertySource is an annotation that can be used to configure property file sources for our tests.
A property defined using this testing-focused annotation will have *a higher priority than the same property defined in main property sources*.

## M3L7
Index of latest spring boot release default properties: https://docs.spring.io/spring-boot/appendix/application-properties/index.html

## M3L8
The plugin’s base setup is defined by the Spring Boot parent pom, but in order to trigger its functionality in the maven
build process, we still have to explicitly include it in the build > plugins section of our project’s pom.xml file:

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

We can run the application by executing the run goal of the plugin:

    mvn spring-boot:run

**Running the application using the plugin isn’t recommended in production**.
First of all, it would need the codebase to be present in the server. Furthermore, the process wouldn’t be optimized,
as it has to pull the dependencies, build the app, and then run the application in place each time it’s executed.

Usually, in production environments, it’s suitable to run a pre-packaged artifact.

Another option is to execute our application as a jar using the java command.

**A regular Spring Boot jar can’t be executed out of the box, since it doesn’t include the “provided” dependencies (that should be supplied by the container)** that are required to run the application.

**The Spring Boot Maven Plugin comes into play again with a repackage goal. This feature packages the jar into an executable fat jar containing the application class files and all the necessary dependencies to run the project as a self-contained app**.

Since we’re inheriting the plugin from the spring-boot-starter-parent pom, and including the plugin in our build configuration, the repackage goal execution is preconfigured and will be triggered as part of the regular build process:

    mvn package

You can see in the logs that the repackage goal is in fact executed.
**Having a packaged executable jar allows us to simply run the application using the java command:**

    java -jar target/deploying-boot-2-application-other-options-0.1.0-SNAPSHOT.jar

We may also provide runtime configurations using command line arguments, if necessary:

    java -jar -Dspring.profiles.active=dev \
        -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 \
        target/deploying-boot-2-application-other-options-0.1.0-SNAPSHOT.jar \ 
        property1 --my.application.property=value


This is a comparatively better approach for running the app in a production environment, as we’ve decoupled the build and execution processes;
**the server only needs to have the required Java version installed to run the app**