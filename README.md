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