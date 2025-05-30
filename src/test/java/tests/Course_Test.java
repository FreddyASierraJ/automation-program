package tests;

import dataclasses.Student;
import listeners.ExtentReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CoursePage;
import pages.HomePage;

@ExtendWith(ExtentReportExtension.class)
public class Course_Test extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(Course_Test.class);
    private final String studentCSVFile ="/files/students.csv";

    static HomePage homePage;
    static CoursePage coursePage;

    @BeforeAll
    static void initPageObject() {
        homePage = new HomePage();
        coursePage = new CoursePage();

        homePage.clickOnCoursesLink();
    }

    @Test
    void test() {
        coursePage.typeName("Ana");
        coursePage.typeDate("04/30/2025");
        coursePage.selectAPITestingCourse();
        coursePage.selectJavaCourse();
        coursePage.clickOnAddCourse();
        coursePage.verifyTextIsPresentInTable("Ana");
    }

    @ParameterizedTest
    @CsvFileSource(resources = studentCSVFile, numLinesToSkip = 1)
    void verifyAdding_StudentCourses(String name,String country,String date,int courses_quantity) {

        Student student = new Student(name,country,date);

        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectRandomCourses(2);
        coursePage.addingSelectedCoursesToStudent(student);

        coursePage.clickOnAddCourse();

        Assertions.assertTrue(coursePage.isCoursePresentForUser(student),"student not added to the table correctly");

    }

}
