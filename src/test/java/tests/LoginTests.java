package tests;

import static com.codeborne.selenide.Condition.visible;

import helpers.ConfigHelper;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Feature("Login tests")
public class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful login Google account")
    void loginWithGoogle() {

        step("Open main page", () -> {
                    open("");
                    $(".android.login-button").click();
                });
        step("Fill google auth form", () -> {
                    googleAuthPage.login(ConfigHelper.getGoogleUsername(), ConfigHelper.getGooglePassword());
                });

        step("Verify successful authorization", () -> {
            $(by("data-test-id", "onboarding-geolocation-access")).shouldBe(visible);
        });
    }
}
