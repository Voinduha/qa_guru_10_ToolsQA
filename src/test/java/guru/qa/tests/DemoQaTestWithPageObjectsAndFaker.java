package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class DemoQaTestWithPageObjectsAndFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    @Test
    public void fillForm() {

        String
                firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = "Male",
                userNumber = faker.phoneNumber().subscriberNumber(10),
                subject = "Physics",
                hobbySport = "Sports",
                uploadPicture = "Test.jpeg",
                currentAddress = faker.address().fullAddress(),
                state = "NCR",
                city = "Noida";

        registrationPage
        .openPage()
        .typeFirstName(firstName)
        .typeLastName(lastName)
        .typeEmail(userEmail)
        .typeGender(gender)
        .typeUserNumber(userNumber)
        .calendar.setDate(11, "May", "2000");
        registrationPage
        .typeSubject(subject)
        .typeHobbySport(hobbySport)
        .uploadPicture(uploadPicture)
        .typeCurrentAddress(currentAddress)
        .typeState(state)
        .typeCity(city)
        .clickSubmit()
        // проверки
        .checkResultsValue(firstName + " " + lastName)
        .checkResultsValue(userEmail)
        .checkResultsValue(gender)
        .checkResultsValue(userNumber)
        .checkResultsValue("11 May, 2000")
        .checkResultsValue(subject)
        .checkResultsValue(hobbySport)
        .checkResultsValue(uploadPicture)
        .checkResultsValue(currentAddress)
        .checkResultsValue(state)
        .checkResultsValue(city);
    }
}






