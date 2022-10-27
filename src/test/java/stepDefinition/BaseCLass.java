package stepDefinition;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseCLass {
    static WebDriver driver;
    public PageFactory pageFactory;
    @Parameters("browserName")
    @BeforeClass
    public void setUpDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://www.amazon.in/");
            driver.manage().window().maximize();
            pageFactory = new PageFactory();

        }
        else if (browserName.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://www.amazon.in/");
            driver.manage().window().maximize();
            pageFactory = new PageFactory();
        }
    }
}

