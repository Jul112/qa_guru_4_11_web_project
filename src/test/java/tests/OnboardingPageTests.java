package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.not;

@Feature("Onbording page content")
@Tag("web")
public class OnboardingPageTests extends TestBase{
    // Тест, что онбординг открывается с главной страницы
    @Test
    @DisplayName("Page should be opened from Main page")
    void shouldBeOpenedFromMainPageTest() {
        open("");

        $(byText("Check other ads")).click();

        $(byText("The anonymous")).shouldBe(visible);
    }

    //Тест, что онбординг открывается по прямой ссылке
    @Test
    @DisplayName("Page should be opened with direct link")
    void shouldBeOpenedWithDirectLinkTest() {
        open("/app/ru/onboarding");

        $(byText("The anonymous")).shouldBe(visible);
    }

    //проверим, что в логе консоли нет ошибок:
    @Test
    @DisplayName("Console log should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        open("/app/ru/onboarding");

        //заберем лог консоли
        String consoleLogs = getConsoleLogs();

        //проверим, что в логе нет "SEVERE"
        assertThat(consoleLogs, not(containsString("SEVERE")));

    }
}

/* https://pure.app/app/ru/onboarding */