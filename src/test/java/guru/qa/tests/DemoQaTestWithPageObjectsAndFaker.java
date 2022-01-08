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
        registrationPage.clickSubmit();
        registrationPage.checkResultsValue(firstName + " " + lastName);
        registrationPage.checkResultsValue(userEmail);
        registrationPage.checkResultsValue(gender);
        registrationPage.checkResultsValue(userNumber);
        registrationPage.checkResultsValue("11 May, 2000");
        registrationPage.checkResultsValue(subject);
        registrationPage.checkResultsValue(hobbySport);
        registrationPage.checkResultsValue(uploadPicture);
        registrationPage.checkResultsValue(currentAddress);
        registrationPage.checkResultsValue(state);
        registrationPage.checkResultsValue(city);
    }
}






