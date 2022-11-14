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

public class MeduzaFooterEngTest extends TestBase {

    MeduzaPage meduzaPage = new MeduzaPage();

    @Test
    @DisplayName("Necessary links in footer are displayed, ENG")
    @Tag("eng")
    @Tag("footer")
    void linksInFooterEngTest() {
        step("Open english version", () -> {
            meduzaPage.openPageEng();
        });

        step("Links in Meduza block are displayed", () -> {
            meduzaPage.meduzaFooterBlockEng.shouldHave(size(6));
            meduzaPage.meduzaFooterBlockEng.shouldHave(texts(
                    "About",
                    "Code of conduct",
                    "Privacy notes",
                    "Cookies",
                    "Meduza in Russian",
                    "Support Meduza"));
        });

        step("Social-networks are displayed");
        meduzaPage.platformsFooterBlockEng.shouldHave(size(4));
        meduzaPage.platformsFooterBlockEng.shouldHave(texts(
                "Facebook",
                "Twitter",
                "Instagram",
                "RSS"
        ));

        step("Podcast 'The Naked Pravda' is displayed", () -> {
            meduzaPage.podcastsFooterBlockEng.shouldHave(size(1));
            meduzaPage.podcastsFooterBlockEng.shouldHave(texts("The Naked Pravda"));
        });
    }

    @Test
    @DisplayName("Newsletter block is present")
    @Tag("eng")
    @Tag("footer")
    void newsletterBlockEngTest() {
        step("Open english version", () -> {
            meduzaPage.openPageEng();
        });

        step("Newsletter block is displayed", () -> {
            meduzaPage.newsletterHeader.shouldBe(Condition.visible);
            meduzaPage.newsletterHeader.shouldHave(Condition.text("Our newsletter"));

            meduzaPage.newsletterAdditionalHeader.shouldBe(Condition.visible);
            meduzaPage.newsletterAdditionalHeader.shouldHave(Condition.text("The Real Russia. Today."));

            meduzaPage.newsletterText.shouldBe(Condition.visible);
            meduzaPage.newsletterText.shouldHave(Condition.text("Subscribe to Meduza’s newsletter and don’t miss the next major event\n" +
                    "in the post-Soviet region. Available everywhere with an Internet connection."));
        });

        step("Subscribe-button is active when value in email-input is correct", () -> {
            meduzaPage.newsletterSubscribeButton.shouldHave(Condition.text("Subscribe"));
            meduzaPage.newsletterSubscribeButton.shouldBe(Condition.disabled);
            meduzaPage.newsletterSubscribeInput.sendKeys("test@test.com");
            meduzaPage.newsletterSubscribeButton.shouldBe(Condition.enabled);
        });
    }
}
