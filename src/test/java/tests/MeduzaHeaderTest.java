package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import configurations.MeduzaPage;
import configurations.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MeduzaHeaderTest extends TestBase {

    MeduzaPage meduzaPage = new MeduzaPage();

    @Test
    @DisplayName("Necessary links in header are displayed")
    void headerAppearanceTest() {
        meduzaPage.openPageRu();
        meduzaPage.topMenuRu.findBy(Condition.text("Новости")).shouldBe(Condition.visible);
        meduzaPage.topMenuRu.findBy(Condition.text("Война")).shouldBe(Condition.visible);
        meduzaPage.topMenuRu.findBy(Condition.text("Истории")).shouldBe(Condition.visible);
        meduzaPage.topMenuRu.findBy(Condition.text("Разбор")).shouldBe(Condition.visible);
        meduzaPage.languageButton.shouldBe(Condition.visible);
        meduzaPage.searchButton.shouldBe(Condition.visible);
        meduzaPage.authButton.shouldBe(Condition.visible);
    }

    @Test
    @DisplayName("Language changes when the button is clicked")
    void changeLanguageTest() {
        meduzaPage.openPageRu();
        meduzaPage.languageButton.shouldHave(Condition.text("EN"));
        meduzaPage.languageButton.click();
        webdriver().shouldHave(url(Configuration.baseUrl + "/en"));
        meduzaPage.languageButton.shouldHave(Condition.text("RU"));

        meduzaPage.languageButton.click();
        webdriver().shouldHave(url(Configuration.baseUrl + "/"));
        meduzaPage.languageButton.shouldHave(Condition.text("EN"));
    }

    @Test
    @DisplayName("Authorization modal dialog appears")
    void authModalTest() {
        meduzaPage.openPageRu();
        meduzaPage.authButton.click();
        meduzaPage.authModalDialog.should(Condition.appear);
        meduzaPage.authModalDialog.$(".Modal-header").shouldHave(Condition.text(
                "Читать «Медузу» удобнее, если у вас есть профиль"));
        meduzaPage.authModalDialog.$(byText("Войти через Google")).shouldBe(Condition.visible);
        meduzaPage.submitModalDialogButton.shouldBe(Condition.disabled);
        meduzaPage.authModalDialog.$("input").sendKeys("test@test.com");
        meduzaPage.submitModalDialogButton.shouldBe(Condition.enabled);
    }
}
