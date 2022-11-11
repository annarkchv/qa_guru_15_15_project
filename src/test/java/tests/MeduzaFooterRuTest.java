package tests;

import com.codeborne.selenide.Condition;
import configurations.MeduzaPage;
import configurations.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;

public class MeduzaFooterRuTest extends TestBase {

    MeduzaPage meduzaPage = new MeduzaPage();

    @Test
    @DisplayName("Necessary links in footer are displayed, RU")
    void linksInFooterRuTest() {
        meduzaPage.openPageRu();

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

        meduzaPage.appsFooterBlockRu.shouldHave(size(2));
        meduzaPage.appsFooterBlockRu.shouldHave(texts("iOS", "Android"));

        meduzaPage.friendsFooterBlockRu.shouldHave(size(2));
        meduzaPage.friendsFooterBlockRu.shouldHave(texts("Имейл-рассылка KIT", "«Радио Долин»"));

        meduzaPage.platformsFooterBlockRu.shouldHave(size(6));
        meduzaPage.platformsFooterBlockRu.shouldHave(texts(
                "Инста",
                "Телеграм",
                "Фб",
                "Твиттер",
                "Ютуб",
                "Все платформы"));
    }

    @Test
    @DisplayName("'Signal' block is present")
    void signalBlockTest() {
        meduzaPage.openPageRu();

        // Check header and text
        meduzaPage.newsletterHeader.shouldBe(Condition.visible);
        meduzaPage.newsletterHeader.shouldHave(Condition.text("Рассылка"));

        meduzaPage.newsletterText.shouldBe(Condition.visible);
        meduzaPage.newsletterText.shouldHave(Condition.text("Подпишитесь на «Сигнал» — новое медиа от создателей «Медузы».\n" +
                "Эта имейл-рассылка действительно помогает понимать новости.\n" +
                "Она будет работать до тех пор, пока в России есть интернет."));

        // Check subscribe button
        meduzaPage.newsletterSubscribeButton.shouldHave(Condition.text("Подписаться"));
        meduzaPage.newsletterSubscribeButton.shouldBe(Condition.disabled);
        meduzaPage.newsletterSubscribeInput.sendKeys("test@test.com");
        meduzaPage.newsletterSubscribeButton.shouldBe(Condition.enabled);
    }
}
