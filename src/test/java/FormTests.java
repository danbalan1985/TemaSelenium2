import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FormTests {

    public static void fillFormDetails(){
        ChromeDriver driver = null;
        try {
            driver= BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

            WebElement username = driver.findElement(By.name("username"));
            WebElement password = driver.findElement(By.name("password"));
            WebElement comment = driver.findElement(By.name("comments"));
            WebElement fileUplade = driver.findElement(By.name("filename"));
            WebElement hiddenField = driver.findElement(By.name("hiddenField"));
            List<WebElement> checkboxes = driver.findElements(By.name("checkboxes[]"));
            List<WebElement> radiobuttons = driver.findElements(By.name("radioval"));
            Select select = new Select(driver.findElement(By.name("multipleselect[]")));
            Select dropdown = new Select(driver.findElement(By.name("dropdown")));
            WebElement cancelButton = driver.findElement(By.cssSelector("input[type='reset']"));
            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

            username.sendKeys("testdemo");
            password.sendKeys("passwd");
            comment.clear();
            comment.sendKeys("Un text introdus");
            fileUplade.sendKeys("d:\\testingJava\\test.png");
            System.out.println("hidden:"+hiddenField.getAttribute("value"));
            checkboxes.get(1).click();
            radiobuttons.get(2).click();
            select.deselectAll();
            select.selectByValue("ms1");
            select.selectByValue("ms2");
            dropdown.selectByIndex(2);
            submitButton.click();

        } catch (Exception | Error e) {
            e.printStackTrace();
            if(driver != null){
                File file =driver.getScreenshotAs(OutputType.FILE);
                File destFile = new File("D:\\testingJava\\temaSelenium.png");

                try {
                    FileUtils.copyFile(file,destFile);
                } catch (IOException ex){
                    System.out.println("Screenshot copy failed");
                }
            }

        } finally {
            if(driver!=null){
                driver.quit();
            }
        }
    }

    public static void main(String[] args) {
        fillFormDetails();
    }
}
