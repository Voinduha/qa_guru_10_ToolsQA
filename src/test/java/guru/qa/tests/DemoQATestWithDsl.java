package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class DemoQATestWithDsl extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

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
                .typeCity(city)
        .calendar.setDate(11, "May", "2000");
        registrationPage.clickSubmit()
                // проверки
                .checkResultsValue(firstName)
                .checkResultsValue(lastName)
                .checkResultsValue(userEmail)
                .checkResultsValue(gender)
                .checkResultsValue(userNumber)
                .checkResultsValue("11 May,2000")
                .checkResultsValue(subject)
                .checkResultsValue(hobbySport)
                .checkResultsValue(uploadPicture)
                .checkResultsValue(currentAddress)
                .checkResultsValue(state)
                .checkResultsValue(city);
    }
}






