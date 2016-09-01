package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bscridon on 23.08.2016.
 */
public class AmazonSteps {

    private WebDriver driver;
    //Hello


    @Before("@chrome")
    public void startChrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After("@chrome")
    public void stopChrome() {
        //driver.quit();
    }


    @Given("^the following page is displayed \"([^\"]*)\"$")
    public void theFollowingIsDisplayed(String baseUrl) {
        driver.get(baseUrl);
    }

    @When("^\"([^\"]*)\" is entered in search bar$")
    public void isEnteredInSearchBar(String searchTerm) throws Throwable {
        WebElement mainSearchBar = driver.findElement(By.id("twotabsearchtextbox"));
        mainSearchBar.clear();
        mainSearchBar.sendKeys(searchTerm);
    }

    @When("^Search button is pressed$")
    public void searchButtonIsPressed() throws Throwable {
        WebElement mainSearchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        mainSearchButton.click();
    }

    @Then("^the \"([^\"]*)\" result title should be \"([^\"]*)\"$")
    public void theResultTitleShouldBe(int resultPosition, String expectedResultTitle) throws Throwable {
        String actualResultTitle = buildSearchResultLocator(resultPosition).getText();
        Assert.assertEquals(expectedResultTitle,actualResultTitle);
    }

    public WebElement buildSearchResultLocator(int searchResultPosition) {
        String searchResultXpath = "//*[@id='result_" + (searchResultPosition - 1) + "']//h2";
        WebElement searchResult = driver.findElement(By.xpath(searchResultXpath));
        return searchResult;
    }
}
