package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


@Tag("regression")
public class TextBoxTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fillFormTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay)
                    .setSubjects(testData.subject)
                    .setHobbies(testData.hobby)
                    .uploadPicture(testData.picturePath)
                    .setCurrentAddress(testData.address)
                    .setStateAndCity(testData.state, testData.city);
        });
        step("Send form", () -> {
            registrationPage.clickSubmit();
        });
        step("Check result", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.dayOfBDay + " " + testData.monthOfBDay + "," + testData.yearOfBDay)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", testData.picturePath)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }


    @Test
    void fillNotFullFormTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Fill form not full", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay);
        });
        step("Send form", () -> {
            registrationPage.clickSubmit();
        });
        step("Check result", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.dayOfBDay + " " + testData.monthOfBDay + "," + testData.yearOfBDay);
        });
    }

    @Test
    void negativeFormTest() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeBanner();
        });
        step("Fill form not full", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setWrongUserEmail(testData.wrongEmail)
                    .setGender(testData.gender)
                    .setUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.dayOfBDay, testData.monthOfBDay, testData.yearOfBDay);
        });
        step("Send form", () -> {
            registrationPage.clickSubmit();
        });
        step("Check wrong result", () -> {
            registrationPage.checkNegativeResult();
        });
    }
}
