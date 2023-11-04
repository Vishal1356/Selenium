import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class qaClick {

    public static  void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@id='checkbox-example']//fieldset/label[2]/input")).click();
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        Select s=new Select(dropdown);
        s.selectByVisibleText(opt);
        driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys("Vishal");
       driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.cssSelector("input[id='confirmbtn']")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(By.xpath(""));
    }
}
