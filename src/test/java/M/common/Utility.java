package M.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class Utility {
  public   WebDriver driver;
    @Parameters({"browsers"})
    @BeforeClass
    public  void beforeClass(String window) throws InterruptedException {
        if (window.equalsIgnoreCase("Chrome")){
             System.setProperty("webdriver.chrome.driver", "C:\\Users\\fwzna\\eclipse-workspace\\AutomationRiview\\Drivers\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.navigate().to("Https://www.facebook.com");
            driver.manage().window().maximize();
            Thread.sleep(6000);
        }else if (window.equalsIgnoreCase("Firefox")){
             System.setProperty("webdriver.gecko.driver", "C:\\Users\\fwzna\\IdeaProjects\\Mentoring\\src\\Drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
            driver.navigate().to("Https://www.facebook.com");
            driver.manage().window().maximize();
            Thread.sleep(6000);
        }else if(window.equalsIgnoreCase("Edge")) {
             System.setProperty("webdriver.edge.driver", "C:\\Users\\fwzna\\IdeaProjects\\Mentoring\\src\\Drivers\\msedgedriver.exe");
            driver= new EdgeDriver();
            driver.navigate().to("Https://www.facebook.com");
            driver.manage().window().maximize();
            Thread.sleep(6000);
        }

    }
    @AfterClass
    public void afterClass() {

        driver.close();
    }

    // This for take screen shot

    public void Pictures() throws IOException {
        Date dt=new Date();
        String sk=dt.toString().replace(" ", "_").replace(":", "_");
        System.out.println(sk);
        System.out.println(dt);
        File screenshorts= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshorts,  new File("C:\\Users\\fwzna\\IdeaProjects\\Mentoring\\Pictures\\PicturesMon"+sk+"ShotOfPage.jpg"));
    }

}
