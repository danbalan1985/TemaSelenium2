import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTests {

    public static void firstAlertTest() {
        ChromeDriver driver=null;
        try {
            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            WebElement firstButton = driver.findElement(By.id("alertexamples"));
            firstButton.click();
            Alert firstAlert = driver.switchTo().alert();
            System.out.println(firstAlert.getText());
            firstAlert.accept();

            System.out.println("is alert opened after is has been closed: "+isAlertOpened(driver));
        } finally {
            if(driver != null) {
                driver.quit();
            }

        }
    }

    public static boolean isAlertOpened(ChromeDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch(NoAlertPresentException e) {
            return false;
        }

    }

    public static void secondAlertTest() {
        ChromeDriver driver=null;
        try {
            driver = BrowserManager.getChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

            for(int i=0 ;i<=1;i++) {
                driver.findElement(By.id("confirmexample")).click();
                System.out.println("is alert opened after button click: " + isAlertOpened(driver));
                Alert alert = driver.switchTo().alert();
                if(i==0) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                System.out.println(driver.findElement(By.id("confirmexplanation")).getText());
                System.out.println("is alert opened after is has been closed: "+isAlertOpened(driver));

            }



        } finally {
            if(driver != null) {
                driver.quit();
            }

        }
    }
    public static void main(String[] args) {
        secondAlertTest();
    }

}
