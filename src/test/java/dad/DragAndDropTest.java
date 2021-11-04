package dad;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }

    String url = "https://the-internet.herokuapp.com/drag_and_drop";

    private final SelenideElement columnA = $("[id=column-a]");
    private final SelenideElement columnB = $("[id=column-b]");

    @Test
    public void dragAndDropShortTest() {
        open(url);
        columnA.dragAndDropTo(columnB);
        columnA.shouldHave(exactText("B"));
        columnB.shouldHave(exactText("A"));
    }

    @Test
    public void dragAndDropLongTest() {
        open(url);
        actions()
                .moveToElement(columnA,1,1)
                .clickAndHold()
                .moveByOffset(142,-72)
                .release()
                .perform();
        columnA.shouldHave(exactText("B"));
        columnB.shouldHave(exactText("A"));
    }
}
