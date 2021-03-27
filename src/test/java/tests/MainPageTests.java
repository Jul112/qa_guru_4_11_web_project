package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page should have title\"Shameless hookup dating\"") //на главной странице присутствует заголовок
    void titlePageTest() {
        open("");

        $("#intro .intro-title").shouldHave(text("SHAMELESS HOOKUP DATING"));
    }

    @Test
    @DisplayName("Page blocks should be loaded") //загрузились основные блоки главной страницы
    void baseBlocksLoadedTest() {
        open("");

        $("#announcements").shouldBe(visible);
        $("#online-block").shouldBe(visible);
        $("#chats").shouldBe(visible);
        $("#features").shouldBe(visible);
        $("#blog-index").shouldBe(visible);
        $("#links").shouldBe(visible);
    }

    @Test
    @DisplayName("Page should change language") //главная страница сменила язык
    void changeLanguageTest() {
        open("");

        $("#language").click();
        $("#language-menu").$(byText("Deutsch")).click();

        $("#intro .intro-title").shouldHave(text("SCHAMLOSES DATING"));
    }

}
