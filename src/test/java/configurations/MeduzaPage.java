package configurations;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MeduzaPage {

    public MeduzaPage openPageRu() {
        open("/");
        return this;
    }

    public MeduzaPage openPageEng() {
        open("/en");
        return this;
    }

    public ElementsCollection
            // RU
            meduzaFooterBlockRu = $$(".Footer-groupTitle").findBy(text("Медуза"))
            .parent().$(".Footer-groupList").$$("li"),
            appsFooterBlockRu = $$(".Footer-groupTitle").findBy(text("Приложения"))
                    .parent().$(".Footer-groupList").$$("li"),
            friendsFooterBlockRu = $$(".Footer-groupTitle").findBy(text("Друзья «Медузы»"))
                    .parent().$(".Footer-groupList").$$("li"),
            platformsFooterBlockRu = $$(".Footer-groupTitle").findBy(text("Платформы"))
                    .parent().$(".Footer-groupList").$$("li"),
            topMenuRu = $$(".Header-item"),

            // ENG
            meduzaFooterBlockEng = $$(".Footer-groupTitle").findBy(text("Meduza"))
                    .parent().$(".Footer-groupList").$$("li"),
            platformsFooterBlockEng = $$(".Footer-groupTitle").findBy(text("Platforms"))
                    .parent().$(".Footer-groupList").$$("li"),
            podcastsFooterBlockEng = $$(".Footer-groupTitle").findBy(text("Podcast"))
                    .parent().$(".Footer-groupList").$$("li");

    public SelenideElement
            authModalDialog = $(".Modal-container"),
            submitModalDialogButton = authModalDialog.$("[data-testid=button]"),
            languageButton = $(".Header-itemLang"),
            searchButton = $(".Header-itemSearch"),
            authButton = $(".Header-itemAuth"),
            newsletterHeader = $(".FooterBlock-content").$("h2"),
            newsletterAdditionalHeader = $(".FooterBlock-content").$("h3"),
            newsletterText = $(".FooterBlock-content .FooterBlock-text"),
            newsletterSubscribeInput = $("#footer-email"),
            newsletterSubscribeButton = $(".FooterBlock-content .FooterBlock-button");




}
