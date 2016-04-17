package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static WebDriver driver;

    public static void main(String[] args) {
        //WebDriver driver = new HtmlUnitDriver();
        driver = new FirefoxDriver();

        loginTest("pekka", "akkep");
        loginTest("pekka", "väärä");
        newUserTest("pekka2", "12345678");
        newUserAndLogout("pekka3", "12345678");
    }

    public static void loginTest(String username, String password) {
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println("==");

        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();

        System.out.println("==");
        System.out.println(driver.getPageSource());
    }

    public static void newUserTest(String username, String password) {
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println("==");

        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("add"));
        element.submit();

        System.out.println("==");
        System.out.println(driver.getPageSource());
    }

    public static void newUserAndLogout(String username, String password) {
        newUserTest(username, password);
        WebElement element
            = driver.findElement(By.linkText(
                "continue to application mainpage"));
        element.click();
        element
            = driver.findElement(By.linkText(
                "logout"));
        element.click();
        
    }
}

