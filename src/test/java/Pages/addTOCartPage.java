package Pages;
import EnumPack.addTocratEnum;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class addTOCartPage {
    WebDriver driver;
    WebDriverWait wait;
    String searchBar = "//input[@id='%s']";
    By clickOnMobile = By.xpath("//span[contains(text(),'Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)')]");
    String productColourXpath = "//div[@id='variation_color_name']//ul//li";
    By productColourValueDisplayed = By.xpath("//div[@id='variation_color_name']//label[@class='a-form-label']//following::span[1]");
    By clickOnSeeQuestionAnswers = By.xpath("//span[@class='celwidget']");
  //  By seeMoreQuestionAndAnswers = By.
    By addProductToCart = By.xpath("//input[@name='submit.add-to-cart']");
    By clickOnCart = By.xpath("(//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce'])[1]");
    By verifyingCartItems = By.xpath("(//span[contains(text(),'Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)')])[1]");
    By dropDown = By.xpath("//i[@class='a-icon a-icon-dropdown']");
    addTOCartPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(90));
    }

    public void clickOnSearchBar() {
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchInput.getResourcesName()))).sendKeys("mobile");
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchButton.getResourcesName()))).click();
    }
    public void clickOnMobile(){
    driver.findElement(clickOnMobile).click();
    }

    public void displayingProducts() {
        String actual = driver.findElement(clickOnMobile).getText();
        System.out.println(actual);
    }

    public void searchedProductColour() {
        String mainWindow = driver.getWindowHandle();
        ArrayList<String> childTabWindow = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(String.valueOf(childTabWindow.get(1)));
        List<WebElement> productColour;
        productColour = driver.findElements(By.xpath(String.valueOf(productColourXpath)));
        int numberOfProductColour = productColour.size();
        System.out.println(numberOfProductColour);
        for (int j = 0; j < numberOfProductColour; j++) {
            Actions action = new Actions(driver);
            action.moveToElement(productColour.get(j)).perform();
            String productColourValue = driver.findElement(productColourValueDisplayed).getText();
            System.out.println(productColourValue);
        }
    }

        public void addProductInTheCart() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(clickOnSeeQuestionAnswers).click();
           // JavascriptExecutor js = (JavascriptExecutor) driver;
            //js.executeScript("window.scrollBy(120,7630)", "");
            driver.findElement(addProductToCart).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCart));
            driver.findElement(clickOnCart).click();
    }

    public void verifyProductInTheCart() {
        String actual = driver.findElement(verifyingCartItems).getText();
        System.out.println(actual);
        Assert.isTrue(actual.equals("Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB"), "Expected result does not match with actual result");
    }
    public void goToTheCart() {
        driver.findElement(dropDown).click();
        }
    }





