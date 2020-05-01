import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateGameTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeAll
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("TestUser");
        driver.findElement(By.cssSelector(".is-success")).click();
        driver.findElement(By.id("basepack")).click();
        driver.findElement(By.id("nsfwpack")).click();
        driver.findElement(By.id("cspack")).click();
        driver.findElement(By.cssSelector(".is-success")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("joinCode"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.cssSelector(".is-info")).click();
        driver.findElement(By.cssSelector(".playerName > input")).click();
        {
            String value = driver.findElement(By.cssSelector(".playerName > input")).getAttribute("value");
            Assertions.assertEquals(value, "Name: TestUser");
        }
        driver.findElement(By.cssSelector(".textarea")).click();
        driver.findElement(By.cssSelector(".playerScore > input")).click();
        {
            String value = driver.findElement(By.cssSelector(".playerScore > input")).getAttribute("value");
            Assertions.assertEquals(value, "Score: 0");
        }
        driver.findElement(By.cssSelector(".level-left")).click();
        driver.close();
    }
}
