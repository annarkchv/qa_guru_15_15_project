package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import configurations.MeduzaPage;
import configurations.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class MeduzaHeaderTest extends TestBase {

    MeduzaPage meduzaPage = new MeduzaPage();

    @Test
    @DisplayName("Necessary links in header are displayed")
    @Tag("ru")
    @Tag("header")
    void headerAppearanceTest() {
        step("Open russian version", () -> {
            meduzaPage.openPageRu();
        });

        step("Topics are displayed in header", () -> {
            meduzaPage.topMenuRu.findBy(Condition.text("Новости")).shouldBe(Condition.visible);
            meduzaPage.topMenuRu.findBy(Condition.text("Война")).shouldBe(Condition.visible);
            meduzaPage.topMenuRu.findBy(Condition.text("Истории")).shouldBe(Condition.visible);
            meduzaPage.topMenuRu.findBy(Condition.text("Разбор")).shouldBe(Condition.visible);
        });

        step("Language, search and auth buttons are displayed in header", () -> {
            meduzaPage.languageButton.shouldBe(Condition.visible);
            meduzaPage.searchButton.shouldBe(Condition.visible);
            meduzaPage.authButton.shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Language changes when the button is clicked")
    @Tag("header")
    void changeLanguageTest() {
        step("Open russian version", () -> {
            meduzaPage.openPageRu();
        });

        step("Text on the language-button is 'EN'", () -> {
            meduzaPage.languageButton.shouldHave(Condition.text("EN"));
        });

        step("English version opens when the button is clicked", () -> {
            meduzaPage.languageButton.click();
            webdriver().shouldHave(url(Configuration.baseUrl + "/en"));
            meduzaPage.languageButton.shouldHave(Condition.text("RU"));
        });

        step("Russian version opens when the button is clicked for the second time", () -> {
            meduzaPage.languageButton.click();
            webdriver().shouldHave(url(Configuration.baseUrl + "/"));
            meduzaPage.languageButton.shouldHave(Condition.text("EN"));
        });
    }

    @Test
    @DisplayName("Authorization modal dialog appears when the button is clicked")
    @Tag("ru")
    @Tag("header")
    void authModalTest() {
        step("Authorization modal dialog appears when the button is clicked", () -> {
            meduzaPage.openPageRu();
            meduzaPage.authButton.click();
            meduzaPage.authModalDialog.should(Condition.appear);
            meduzaPage.authModalDialog.$(".Modal-header").shouldHave(Condition.text(
                    "Читать «Медузу» удобнее, если у вас есть профиль"));
        });

        step("Authorization with Google is available", () -> {
            meduzaPage.authModalDialog.$(byText("Войти через Google"))
                    .shouldBe(Condition.visible)
                    .shouldBe(Condition.enabled);
        });

        step("Auth-button is active when the email-input is filled", () -> {
            meduzaPage.submitModalDialogButton.shouldBe(Condition.disabled);
            meduzaPage.authModalDialog.$("input").sendKeys("test@test.com");
            meduzaPage.submitModalDialogButton.shouldBe(Condition.enabled);
        });
    }
}
