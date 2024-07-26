package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Simon")
                .setLastName("Job")
                .setUserEmail("simon@gmail.com")
                .setGender("Male")
                .setUserNumber("8005553535")
                .setDateOfBirth("31", "October", "1947")
                .setSubjects("Maths")
                .setHobbies("Sports", "Reading")
                .uploadPicture("testPhoto.png")
                .setCurrentAddress("Moscow street 1")
                .setStateAndCity("NCR", "Delhi")
                .clickSubmit()
                .checkResult("Student Name", "Simon Job")
                .checkResult("Student Email", "simon@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8005553535")
                .checkResult("Date of Birth", "31 October,1947")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading")
                .checkResult("Picture", "testPhoto.png")
                .checkResult("Address", "Moscow street 1")
                .checkResult("State and City", "NCR Delhi");
    }


    @Test
    void fillNotFullFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Simon")
                .setLastName("Job")
                .setGender("Male")
                .setUserNumber("8005553535")
                .setDateOfBirth("31", "October", "1947")
                .clickSubmit()
                .checkResult("Student Name", "Simon Job")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8005553535")
                .checkResult("Date of Birth", "31 October,1947");
    }

    @Test
    void negativeFormTest() {


        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Simon")
                .setLastName("Job")
                .setWrongUserEmail("simon@gmail")
                .setGender("Male")
                .setUserNumber("8005553535")
                .setDateOfBirth("31", "October", "1947")
                .clickSubmit()
                .checkNegativeResult();
    }
}
