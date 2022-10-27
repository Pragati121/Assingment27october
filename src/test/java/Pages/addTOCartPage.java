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
    By prinitngQuestions = By.xpath("(//div[contains(@class,'a-fixed-left-grid')])[10]");
    By addProductToCart = By.xpath("//input[@name='submit.add-to-cart']");
    By clickOnCart = By.xpath("(//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce'])[1]");
    By verifyingCartItems = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By dropDown = By.xpath("//span[contains(@class,'a-button-text ')]");
    addTOCartPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,Duration.ofSeconds(90));
    }

    public void clickOnSearchBar() {
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchInput.getResourcesName()))).sendKeys("mobile");
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchButton.getResourcesName()))).click();
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
        String actual = driver.findElement(prinitngQuestions).getText();
        System.out.println(actual);
    }
        public void addProductInTheCart() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,7630)", "");
            driver.findElement(addProductToCart).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCart));
            driver.findElement(clickOnCart).click();
    }

    public void verifyProductInTheCart() {
        String actual = driver.findElement(verifyingCartItems).getText();
        Assert.isTrue(actual.equals("Shopping Cart"), "Expected result does not match with actual result");
    }
    public void goToTheCart() {
    driver.findElement(clickOnCart).click();
        driver.findElement(dropDown).click();
        }
    }





