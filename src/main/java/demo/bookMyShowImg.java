package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bookMyShowImg {
    ChromeDriver driver;
    public bookMyShowImg()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        // Navigate to url  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Locate all image URLs under "Recommended movies" Using Locator "XPath" //div[contains(@class,'sc-lnhrs7-4 bmyqGC')]/div/a
        List<WebElement> allImgLeft = driver.findElements(By.xpath("//div[contains(@class,'sc-lnhrs7-4 bmyqGC')]/div/a"));
        for(WebElement leftimg : allImgLeft){
            System.out.println("Img Links :"+leftimg.getAttribute("href"));
        }
        driver.findElement(By.xpath("//div[contains(@class,'sc-133848s-1 sc-lnhrs7-6 sc-lnhrs7-8 kzTtJF')][1]")).click();
        Thread.sleep(2000);
        List<WebElement> allImgRight = driver.findElements(By.xpath("//div[contains(@class,'sc-lnhrs7-4 fmmlKL')]/div/a"));
        for(WebElement rightimg : allImgRight){
            System.out.println("Img Links :"+rightimg.getAttribute("href"));
        }
        // JavascriptExecutor js = (JavascriptExecutor) driver; 
        // // Locate Name of the 2nd item in the “Premiere” list Using Locator "XPath" //div[contains(@class,'sc-lnhrs7-4 hgSytF')]/a[2]/div/div[3]/div/div[1] | getText
        // WebElement itemName = driver.findElement(By.xpath("//div[contains(@class,'sc-lnhrs7-4 hgSytF')]/a[2]/div/div[3]/div/div[1]"));
        // js.executeScript("arguments[0].scrollIntoView();", itemName);
        // Thread.sleep(3000);
        // System.out.println("Name :"+itemName.getText());
        // // Locate Language of the 2nd item in the “Premiere” list Using Locator "XPath" //div[contains(@class,'sc-lnhrs7-4 hgSytF')]/a[2]/div/div[3]/div/div[2] | getText
        // WebElement itemLanguage = driver.findElement(By.xpath("//div[contains(@class,'sc-lnhrs7-4 hgSytF')]/a[2]/div/div[3]/div/div[2]"));
        // js.executeScript("arguments[0].scrollIntoView();", itemLanguage);
        // Thread.sleep(3000);
        // System.out.println("Language :"+itemLanguage.getText());
    }
}
