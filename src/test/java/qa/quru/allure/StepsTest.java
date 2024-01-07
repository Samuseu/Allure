package qa.quru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;


public class StepsTest  {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 84;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide()); // подключение селенид для allure
        //лямбда функция сокращает вызов, кр если есть класс и в нем 1 метод, то можно ее использовать вот так ()->{}
        step("Открываем главную страницу ", () -> {
            open("https://github.com/");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();

        });
        step("Кликаем по ссылке " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issies с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps
                .openMainPage()
                .searchForRepository(REPOSITORY)
                .clickOnRepositoryLink(REPOSITORY)
                .openIssueTab()
                .shouldSeeIssueWithNumber(ISSUE);
    }
}
