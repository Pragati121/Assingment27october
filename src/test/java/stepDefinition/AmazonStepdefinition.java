package stepDefinition;

import EnumPack.addTocratEnum;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonStepdefinition extends BaseCLass {
    String searchBar = "//input[@id='%s']";
    By clickOnMobile = By.xpath("//span[contains(text(),'Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)')]");
    String productColourXpath = "//div[@id='variation_color_name']//ul//li";
    By productColourValueDisplayed = By.xpath("//div[@id='variation_color_name']//label[@class='a-form-label']//following::span[1]");
    By clickOnSeeQuestionAnswers = By.xpath("//span[@class='celwidget']");
    By seeMoreQuestionAnswers = By.xpath("//div[@id='question-Tx10SL5IBR948GP']");
    By addProductToCart = By.xpath("//input[@name='submit.add-to-cart']");
    By clickOnCart = By.xpath("(//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce'])[1]");
    By verifyingCartItems = By.xpath("(//span[contains(text(),'Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)')])[2]");
    By dropDown = By.xpath("//span[@class='a-button-text a-declarative']");
    By printingPriceOfItem = By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]");

    @Given("User is in the Home Page")
    public void user_is_in_the_home_page() throws IOException {
        Setup();
    }

    @And("Go to search bar and search for mobiles")
    public void go_to_search_bar_and_search_for_mobiles(DataTable table) {
        List<List<String>> data = Collections.singletonList(table.values());
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchInput.getResourcesName()))).sendKeys(data.get(0).get(0));;
        driver.findElement(By.xpath(String.format(searchBar, addTocratEnum.SearchButton.getResourcesName()))).click();
    }

    @And("Select one mobile and console its name")
    public void select_one_mobile_and_console_its_name() {
        driver.findElement(clickOnMobile).click();
    }

    @And("Check and console size,color")
    public void check_and_console_size_color() {
        String actual = driver.findElement(clickOnMobile).getText();
        System.out.println(actual);
    }

    @And("Go to customer question & answer section and print top three question and answers")
    public void go_to_customer_question_answer_section_and_print_top_question_and_answers() {
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
    @And("Add item to cart and also verify it in the cart")
    public void add_item_to_cart_and_also_verify_it_in_the_cart() throws InterruptedException {
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

    @When("Go to shopping cart and increase the quantity")
    public void go_to_shopping_cart_and_increase_the_quantity() throws InterruptedException {
       wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSeeQuestionAnswers));
        driver.findElement(clickOnSeeQuestionAnswers).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreQuestionAnswers));
        String actual = driver.findElement(seeMoreQuestionAnswers).getText();
        System.out.println(actual);
        driver.findElement(addProductToCart).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnCart));
        driver.findElement(clickOnCart).click();
    }
    @Then("Verify the item in the cart and console the total amount of product")
    public void verify_the_item_in_the_cart_and_console_the_total_amount_of_product() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyingCartItems));
        String actual = driver.findElement(verifyingCartItems).getText();
        System.out.println(actual);
        Assert.assertEquals("Samsung Galaxy M32 Prime Edition (Light Blue, 6GB RAM, 128GB)",actual);
        driver.findElement(dropDown).click();
        String actual1 = driver.findElement(printingPriceOfItem).getText();
        System.out.println("total price is"+actual1);
    }
}


