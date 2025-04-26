package Clase1;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class JunitExampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is a Before all");
    }

    @BeforeEach
    void setUp() {
        System.out.println("this is the BeforeEach");

    }
    @AfterEach
    void tearDown() {
        System.out.println("this is the AfterEach");

    }
    @Order(2)
    @DisplayName("This is the login test")
    @Test
    void login() {
        System.out.println("This is the login test");
    }
    @Order(3)
    @DisplayName("This is the test to verify the about pages is correct")
    @Test
    void verifyAboutTest() {
        System.out.println("This is the Verify test");
    }
    @Order(1)
    @DisplayName("This is the Log out test")
    @Test
    void logOut() {
        System.out.println("This is the Log out test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is the After all");
    }
}
