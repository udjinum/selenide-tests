package dad;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.event.MouseEvent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    public static void setUpBeforeAll() {
        Configuration.headless = false;
        Configuration.startMaximized = true;
    }

    private final SelenideElement columnA = $("[id=column-a]");
    private final SelenideElement columnB = $("[id=column-b]");

    @Test
    public void dragAndDropShortTest() {
        String url = "https://the-internet.herokuapp.com/drag_and_drop";

        open(url);
        columnA.dragAndDropTo(columnB);
        columnB.shouldHave(exactText("A"));
    }

    @Test
    public void dragAndDropLongTest() {
        String url = "https://the-internet.herokuapp.com/drag_and_drop";

        open(url);
        actions()
                .moveToElement(columnA,1,1)
                .clickAndHold()
                .moveByOffset(142,-72)
                .release()
                .perform();
        columnB.shouldHave(exactText("A"));
    }
}
