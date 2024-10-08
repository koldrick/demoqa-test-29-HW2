package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateAndCityInput = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanner() {

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.scrollTo();
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {

        lastNameInput.scrollTo();
        lastNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.scrollTo();
        userEmailInput.setValue(value);
        return this;

    }

    public RegistrationPage setGender(String value) {
        genderWrapper.scrollTo();
        genderWrapper.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.scrollTo();
        userNumberInput.setValue(value);
        return this;

    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.scrollTo();
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.scrollTo();
        subjectsInput.setValue(value).pressEnter();

        return this;
    }


    public RegistrationPage setHobbies(String value) {
        hobbiesInput.scrollTo();
        hobbiesInput.$(byText(value)).click();

        return this;
    }


    public RegistrationPage uploadPicture(String value) {
        uploadInput.scrollTo();
        uploadInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.scrollTo();
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String value, String value2) {
        stateAndCityInput.scrollTo();
        stateAndCityInput.$(byText("Select State")).click();
        stateAndCityInput.$(byText(value)).click();
        stateAndCityInput.$(byText("Select City")).click();
        stateAndCityInput.$(byText(value2)).click();


        return this;

    }

    public RegistrationPage clickSubmit() {
        submitButton.scrollTo();
        submitButton.click();

        return this;
    }

    public RegistrationPage setWrongUserEmail(String value) {
        userEmailInput.scrollTo();
        userEmailInput.setValue(value);
        return this;

    }


    public RegistrationPage checkResult(String key, String value) {
        tableComponent.table(key, value);
        tableComponent.table(key, value);

        return this;

    }


    public void checkNegativeResult() {
        $(".table-responsive").shouldNotBe(visible);

    }


}
