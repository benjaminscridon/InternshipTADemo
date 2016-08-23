package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bscridon on 23.08.2016.
 */
public class AmazonSteps {

    private WebDriver driver;


    @Before("@chrome")
    public void startChrome() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @After("@chrome")
    public void stopChrome(){
        //driver.quit();
    }


    @Given("^the following page is displayed \"([^\"]*)\"$")
    public void theFollowingIsDisplayed(String baseUrl){

    }

}
