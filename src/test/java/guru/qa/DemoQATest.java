package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void fillForm() {

        String firstName = "Serg";
        String lastName = "Me";
        String userEmail = "ya@ya.ru";
        String gender = "Male";
        String userNumber = "1234567890";
        String dateOfBirth = "11 May,2000";
        String subject = "Physics";
        String hobbySport = "Sports";
        String hobbyMusic = "Music";
        String uploadPicture = "Test.jpeg";
        String currentAddress = "Somewhere";
        String state = "NCR";
        String city = "Noida";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $$(".react-datepicker__day").find(text("11")).click();

        $("#subjectsInput").setValue(subject).pressEnter();


        $(byText(hobbySport)).click();
        $(byText(hobbyMusic)).click();

        $("#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        $("#submit").click();

        //Проверяем что перешли в модальное окно
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Проверяем введенные данные
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("[class=\"table table-dark table-striped table-bordered table-hover\"]").$("tbody")
                .shouldHave(text("Serg Me"),
                        text("ya@ya.ru"),
                        text("Male"),
                        text("1234567890"),
                        text("11 May,2000"),
                        text("Sport"),
                        text("Music"),
                        text("Test.jpeg"),
                        text("Somewhere"),
                        text("NCR Noida"));
    }
}






