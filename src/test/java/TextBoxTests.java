import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
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

        open("/text-box");
        $("#userName").setValue("Simon");
        $("#userEmail").setValue("simon@gmail.com");
        $("#currentAddress").setValue("NYC");
        $("#permanentAddress").setValue("Moscow");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Simon"));
        $("#output").$("#email").shouldHave(text("simon@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("NYC"));
        $("#output").$("#permanentAddress").shouldHave(text("Moscow"));
    }
}
