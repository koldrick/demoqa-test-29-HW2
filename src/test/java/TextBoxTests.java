import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Simon");
        $("#lastName").setValue("Job");
        $("#userEmail").setValue("simon@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("8005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("October")).click();
        $(".react-datepicker__year-select").$(byText("1947")).click();
        $(".react-datepicker__month").$(byText("15")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("testPhoto.png");
        $("#currentAddress").setValue("Moscow street 1");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text("Simon Job"));
        $(".modal-body").shouldHave(text("simon@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8005553535"));
        $(".modal-body").shouldHave(text("15 October,1947"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Sports, Reading"));
        $(".modal-body").shouldHave(text("testPhoto.png"));
        $(".modal-body").shouldHave(text("Moscow street 1"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

    }
}
