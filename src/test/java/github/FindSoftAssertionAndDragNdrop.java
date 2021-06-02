package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class FindSoftAssertionAndDragNdrop {

    @BeforeEach
    void config() {
        Configuration.startMaximized = true;
    }

    //Lesson #4, homework #2
    //find "Using JUnit5 on github
    @Test
    void test01_findSelenideOnGithub() {

        /*SCENARIO
        //OPEN github.com
        //TYPE selenide in search and press ENTER
        //FIND selenide/selenide link and CLICK
        //CHECK that selenide/selenide contain in the header
        //FIND wiki and CLICK
        //FIND soft assertion and CLICK
        //FIND in the Example "Using JUnit5"
        */


        //OPEN github.com
        open("https://github.com");

        //TYPE selenide in search and press ENTER
        $("[name=q").setValue("selenide").pressEnter();

        //FIND selenide/selenide link and CLICK
        //$$ - поиск массива
        $$("ul.repo-list").get(0).$("a").click();

        //CHECK that selenide/selenide contain in the header
        $("h1").shouldHave(text("selenide / selenide"));

        //FIND wiki and CLICK
        $("[href=\"/selenide/selenide/wiki\"").click();

        //FIND Soft assertion and CLICK
        $("[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();

        //FIND in the Example "Using JUnit5"
        $("[start=\"3\"]").shouldHave(text("Using JUnit5 extend test class"));
    }


    //Lesson #4, homework #3
    //Simply drag'n'drop with selenide actions
    @Test
    void test02_simplyDragNdrop() {

        /*SCENARIO
        //OPEN https://the-internet.herokuapp.com/drag_and_drop
        //FIND box A and MOVE them to box B
        //CHECK exchange
        */


        //OPEN https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //FIND box A and MOVE them to box B
        $("#column-a").dragAndDropTo($("#column-b"));

        //CHECK exchange
        $("#column-a > header").shouldHave(text("B"));
        $("#column-b > header").shouldHave(text("A"));
    }
}