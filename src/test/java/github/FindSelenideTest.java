package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class FindSelenideTest {

    @Test
    void shouldFindSelenideOnGithub() {

        /*SCENARIO
        //OPEN github.com
        //TYPE selenide in search and press ENTER
        //FIND selenide/selenide link and CLICK
        //CHECK that selenide/selenide contain in the header
        //FIND wiki and CLICK
        //FIND soft assertion and CLICK
        //FIND in the Example "Using JUnit5"
        */

        Configuration.startMaximized = true;

        //OPEN github.com
        open("https://github.com");

        //TYPE selenide in search and press ENTER
        $("[name=q").setValue("selenide").pressEnter();

        //FIND selenide/selenide link and CLICK
        //$$ - поиск массива
        $$("ul.repo-list").first().$("a").click();

        //CHECK that selenide/selenide contain in the header
        $("h1").shouldHave(text("selenide / selenide"));

        //FIND wiki and CLICK
        $("[data-tab-item=i4wiki-tab").click();

        //FIND Soft assertion and CLICK
        $("[href=/selenide/selenide/wiki/SoftAssertions").shouldHave(text("Soft assertions")).click();

        sleep(5000);


        // ARRANGE - подготовка
        // ACT
        // ASSERT
        // ACT
        // ASSERT
        // ACT
        // ASSERT
    }
}
