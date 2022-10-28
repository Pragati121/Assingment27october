package Pages;
import org.openqa.selenium.WebDriver;

public class PageFactory
{
   private addTOCartPage HomeMethod;

    WebDriver driver;

    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }

   public addTOCartPage getCartPage() {
        if (HomeMethod == null) {
           HomeMethod = new addTOCartPage(driver);
       }
       return HomeMethod;
    }

}

