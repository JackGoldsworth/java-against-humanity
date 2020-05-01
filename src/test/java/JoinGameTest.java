import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class JoinGameTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driverF = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    //starts game on chrome, joins on firefox
    //may or may not actually work, couldn't test it myself
    @Test
    public void test2() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("User1");
        driver.findElement(By.cssSelector(".is-success")).click();
        driver.findElement(By.id("basepack")).click();
        driver.findElement(By.id("nsfwpack")).click();
        driver.findElement(By.id("cspack")).click();
        driver.findElement(By.cssSelector(".is-success")).click();

        String gameCode = driver.findElement(By.id("joinCode")).getAttribute("value") - "Join Code: ";

        driver.findElement(By.cssSelector(".is-info")).click();
        driver.findElement(By.cssSelector(".playerName > input")).click();

        //start firefox driver
        driverF.get("http://localhost:8080/");
        driverF.findElement(By.id("username")).click();
        driverF.findElement(By.id("username")).sendKeys("User2");
        driverF.findElement(By.cssSelector(".is-info")).click();
        driverF.findElement(By.id("partyId")).click();
        driverF.findElement(By.id("partyId")).sendKeys(gameCode);
        driverF.findElement(By.cssSelector(".button")).click();
        {
            String val = driverF.findElement(By.cssSelector(".level-item:nth-child(1) .playerName > input")).getAttribute("value");
            assertThat(value, is("Name: User1"));
        }

        driver.close();
        driverF.close();
    }
}