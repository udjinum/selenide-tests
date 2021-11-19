package github;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5CodeTest {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }

    private final SelenideElement wikiLink = $("[data-content=Wiki]"),
            showMorePagesLink = $(".wiki-more-pages-link"),
            chaptersList = $(".markdown-body");
    private final ElementsCollection softAssertionsExamples = $$("ol[start='3']~div");

    @Test
    public void getBlockJUnit5CodeTest() {
        String url = "https://github.com/selenide/selenide";
        String jUnit5Code = "@ExtendWith({SoftAssertsExtension.class})";

        open(url);
        wikiLink.click();
        showMorePagesLink.click();
        chaptersList.$(byText("Soft assertions")).click();
        softAssertionsExamples.first().shouldHave(text(jUnit5Code));
    }
}
