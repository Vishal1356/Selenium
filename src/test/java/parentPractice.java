import com.sun.java.swing.plaf.windows.resources.windows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class parentPractice {
    public static  void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.partialLinkText("Multiple Windows")).click();
        driver.findElement(By.partialLinkText("Click Here")).click();
        Set<String>window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String chidlId = it.next();
        driver.switchTo().window(chidlId);
        String x = driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText();
        System.out.println(x);
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText());
        driver.quit();

    }


    }


