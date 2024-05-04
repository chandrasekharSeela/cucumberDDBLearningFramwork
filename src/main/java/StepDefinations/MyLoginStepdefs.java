package StepDefinations;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.List;


public class MyLoginStepdefs {
    WebDriver driver = new ChromeDriver();

    @Given("^Open the Application URL$")
    public void openTheApplicationURL() {
        driver.manage().window().maximize();
        driver.get("https://reed.co.uk/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //driver.switchTo().alert().accept();
    }

    @When("^Click on Login button$")
    public void clickOnLoginButton() {
        driver.findElement(By.cssSelector(".sign-in.gtmGlobalResponsiveSignIn.header-block-link")).click();
    }

    @And("^Enter the valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterTheValidCredentials(String username, String password) {
        driver.findElement(By.id("signin_email")).sendKeys(username);
        driver.findElement(By.id("signin_password")).sendKeys(password);
        driver.findElement(By.id("signin_button")).click();
    }

    @Then("verify the landed on home page or not")
    public void verifyTheLandedOnHomePageOrNot() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("chandrasekhar", driver.findElement(By.cssSelector(".username.hidden-xs.hidden-sm")).getText().toLowerCase());
    }

    @When("^Enter job \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterJobDetailsAndCityNameToSearch(String jobTitle, String CityOrPostCode){
        driver.findElement(By.id("keywords")).sendKeys(jobTitle);
        driver.findElement(By.id("location")).sendKeys(CityOrPostCode);
        sampleActionMethod();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @And("signOut and close the browser")
    public void signOutAndCloseTheBrowser()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'chandra')]")));
        driver.findElement(By.xpath("//span[contains(.,'chandra')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Sign out')]")));
        driver.findElement(By.xpath("//a[contains(.,'Sign out')]")).click();
        driver.quit();
    }

    public void sampleActionMethod(){
        Actions act = new Actions(driver);
        List<WebElement> ele = driver.findElements(By.cssSelector("div.gtmSearchLocationSuggestionListClick.tt-suggestion.tt-selectable"));
        act.moveToElement(ele.getFirst()).click().perform();
        }

}
