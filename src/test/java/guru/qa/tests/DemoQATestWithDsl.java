package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoQATestWithDsl {

    RegistrationPage registrationPage = new RegistrationPage();
    private String month;
    private String year;
    private String day;
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void fillForm() {

        String
                firstName = "Sergey",
                lastName = "Me",
                userEmail = "ya@ya.ru",
                gender = "Male",
                userNumber = "1234567890",
                subject = "Physics",
                hobbySport = "Sports",
                uploadPicture = "Test.jpeg",
                currentAddress = "Somewhere",
                state = "NCR",
                city = "Noida";


        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(userEmail)
                .typeGender(gender)
                .typeUserNumber(userNumber)
                .typeSubject(subject)
                .typeHobbySport(hobbySport)
                .uploadPicture(uploadPicture)
                .typeCurrentAddress(currentAddress)
                .typeState(state)
                .typeCity(city);
        registrationPage.calendar.setDate(11, "May", "2000");

        String year;
        registrationPage.clickSubmit()
                .checkResultsValue(firstName + " " + lastName);
    }
}






