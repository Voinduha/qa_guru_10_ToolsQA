package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    emailInput =  $("#userEmail"),
                    genderInput = $("#genterWrapper"),
                    userNumberInput = $("#userNumber"),
                    subjectInput = $("#subjectsInput"),
                    hobbySportInput = $("#hobbiesWrapper"),
                    uploadPicturePaste = $("#uploadPicture"),
                    currentAddressFill = $("#currentAddress"),
                    stateInput = $("#react-select-3-input"),
                    cityInput = $("#react-select-4-input"),
                    submitButton = $("#submit"),
                    resultsTable = $(".table-responsive");

    public CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeHobbySport(String value) {
        hobbySportInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicturePaste.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressFill.setValue(value);
        return this;
    }

    public RegistrationPage typeState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public void checkResultsValue(String firstName) {
        resultsTable.shouldHave(text(firstName));
    }
}
