package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DemoQATestWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

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

        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.typeGender(gender);
        registrationPage.typeUserNumber(userNumber);
        registrationPage.calendar.setDate(11, "May", "2000");
        registrationPage.typeSubject(subject);
        registrationPage.typeHobbySport(hobbySport);
        registrationPage.uploadPicture(uploadPicture);
        registrationPage.typeCurrentAddress(currentAddress);
        registrationPage.typeState(state);
        registrationPage.typeCity(city);
        registrationPage.checkResultsValue(firstName + " " + lastName);
    }
}






