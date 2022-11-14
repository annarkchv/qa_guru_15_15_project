package tests;

import com.codeborne.selenide.Condition;
import configurations.MeduzaPage;
import configurations.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static io.qameta.allure.Allure.step;

public class MeduzaFooterRuTest extends TestBase {

    MeduzaPage meduzaPage = new MeduzaPage();

    @Test
    @DisplayName("Necessary links in footer are displayed, RU")
    @Tag("ru")
    @Tag("footer")
    void linksInFooterRuTest() {
        step("Open russian version", () -> {
            meduzaPage.openPageRu();
        });

        step("Links in Meduza block are displayed", () -> {
            meduzaPage.meduzaFooterBlockRu.shouldHave(size(8));
            meduzaPage.meduzaFooterBlockRu.shouldHave(texts(
                    "О редакции",
                    "Кодекс «Медузы»",
                    "Meduza in English",
                    "Блог",
                    "Использование куки",
                    "Обработка данных",
                    "Связаться анонимно",
                    "Поддержать «Медузу»"));
        });

        step("Mobile apps links are displayed", () -> {
            meduzaPage.appsFooterBlockRu.shouldHave(size(2));
            meduzaPage.appsFooterBlockRu.shouldHave(texts("iOS", "Android"));
        });

        step("Partners' links are displayed", () -> {
            meduzaPage.friendsFooterBlockRu.shouldHave(size(2));
            meduzaPage.friendsFooterBlockRu.shouldHave(texts("Имейл-рассылка KIT", "«Радио Долин»"));
        });

        step("Social-networks are displayed", () -> {
            meduzaPage.platformsFooterBlockRu.shouldHave(size(6));
            meduzaPage.platformsFooterBlockRu.shouldHave(texts(
                    "Инста",
                    "Телеграм",
                    "Фб",
                    "Твиттер",
                    "Ютуб",
                    "Все платформы"));
        });
    }

    @Test
    @DisplayName("'Signal' block is present")
    @Tag("ru")
    @Tag("footer")
    void newsletterBlockRuTest() {
        step("Open russian version", () -> {
            meduzaPage.openPageRu();
        });

        step("'Signal' block is displayed", () -> {
            meduzaPage.newsletterHeader.shouldBe(Condition.visible);
            meduzaPage.newsletterHeader.shouldHave(Condition.text("Рассылка"));

            meduzaPage.newsletterText.shouldBe(Condition.visible);
            meduzaPage.newsletterText.shouldHave(Condition.text("Подпишитесь на «Сигнал» — новое медиа от создателей «Медузы».\n" +
                    "Эта имейл-рассылка действительно помогает понимать новости.\n" +
                    "Она будет работать до тех пор, пока в России есть интернет."));
        });

        step("Subscribe-button is active when value in email-input is correct", () -> {
            meduzaPage.newsletterSubscribeButton.shouldHave(Condition.text("Подписаться"));
            meduzaPage.newsletterSubscribeButton.shouldBe(Condition.disabled);
            meduzaPage.newsletterSubscribeInput.sendKeys("test@test.com");
            meduzaPage.newsletterSubscribeButton.shouldBe(Condition.enabled);
        });
    }
}
