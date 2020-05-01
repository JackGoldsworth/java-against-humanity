import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class JoinGameTest {

    private WebDriver driver;
    private WebDriver driverF;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        driverF = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterAll
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

        String gameCode = driver.findElement(By.id("joinCode")).getAttribute("value").replace("Join Code: ", "");

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
            Assertions.assertEquals(val, "Name: User1");
        }

        driverF.close();
        driver.close();
    }
}