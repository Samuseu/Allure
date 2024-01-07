package qa.quru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;


public class SelenideTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // подключение селенид для allure
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#84")).should(Condition.exist);


    }
}
