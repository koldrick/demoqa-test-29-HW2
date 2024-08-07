package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


@Tag("regression")
public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();



    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picturePath)
                .setCurrentAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .clickSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayOfBDay + " " + testData.monthOfBDay + "," + testData.yearOfBDay)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picturePath)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }


    @Test
    void fillNotFullFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay)
                .clickSubmit()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.dayOfBDay + " " + testData.monthOfBDay + "," + testData.yearOfBDay);
    }

    @Test
    void negativeFormTest() {


        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setWrongUserEmail(testData.wrongEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay)
                .clickSubmit()
                .checkNegativeResult();
    }
}
