package frontend.unauthorized;

import backend.endpoint.Endpoint;
import backend.helpers.JsonMapper;
import backend.pojo.request.ccwe.newsSearch.PojoReqNewsPublishedList;
import backend.pojo.response.ccwe.newsPublishedList.PojoResNewsPublishedList;
import backend.service.ApiServiceNoAuth;
import frontend.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Epic("UI тесты")
@Feature("Тесты открытой части сайта")
@Story("Тесты поиска сущностей")
public class UnauthorizedSearchTests extends BaseTest {

    @Test(description = "Поиск новости")
    public void testNewsSearch() {
        open("/home/news");
        var body = JsonMapper.mapJsonToPojo("searchNews.json", PojoReqNewsPublishedList.class);
        $("#filterInput").setValue(body.getSearch());
        $("[ng-click*='searchStart']").click();
        var newsList = ApiServiceNoAuth.postToListPojoJsonPathItems(
                Endpoint.Ccwe.Post.newsPublishedList(),
                body,
                PojoResNewsPublishedList.class);

        $(".newsHeader").$(byText(newsList.get(0).getTitle())).should(appear);
    }
}
