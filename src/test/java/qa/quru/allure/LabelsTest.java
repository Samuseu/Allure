package qa.quru.allure;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {


    @Test
    @Feature("Issue в репозитории")  // feature + story это подход
    @Story("Создание Issue")
    @Owner("Vlad S")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing",url = "https://github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLabels() {
    }

    @Test
    public void testDynamiclabels() {
        Allure.getLifecycle().updateTestCase(t ->t.setName("Создание Issue для авторизованного пользователя") );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner","Vlad S");
        Allure.label("severity",SeverityLevel.BLOCKER.value());
        Allure.link("Testing", "https://github.com");
    }
}
