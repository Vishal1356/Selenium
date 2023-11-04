import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class addToCart {
        public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");
            WebDriver driver=new ChromeDriver();
            String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/seleniumPractise/");
            Thread.sleep(3000);
            addItems(driver,itemsNeeded);
            driver.findElement(By.xpath("//img[@alt='Cart']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
            driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
            WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
            w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.promoBtn")));
            driver.findElement(By.cssSelector("button.promoBtn")).click();


        }
        public static  void addItems(WebDriver driver,String[] itemsNeeded)
        {
            int j=0;
            List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
            for(int i=0;i<products.size();i++)
            {
                String[] name=products.get(i).getText().split("-");
                String formattedName=name[0].trim();
//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-
                List itemsNeededList = Arrays.asList(itemsNeeded);
                if(itemsNeededList.contains(formattedName))
                {
                    j++;
//click on Add to cart
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    if(j==itemsNeeded.length)
                    {
                        break;
                    }
                }
            }
        }

    }