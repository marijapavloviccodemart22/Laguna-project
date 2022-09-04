package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.soap.Text;

public class InventoryPage extends  BasePages {


    //lokatori:

    @FindBy(xpath="//input[@id='pretraga_rec']")
    WebElement searchField;

    @FindBy(xpath = "//input[@id='pretraga_submit']")
    WebElement submitButton;

    @FindBy(xpath = "//a[@class='dugme']")
    WebElement početnaButton;

    @FindBy(xpath ="//img[@alt='kletva laguna knjige']" )
    WebElement bookKletva;

    @FindBy(xpath = "//div[@class='naslov-font2']")
    WebElement errormessageText;

// konstruktor:

    public InventoryPage(ChromeDriver driver) {
        super(driver);
        print(" Driver get url");
        driver.get("https://www.laguna.rs/index.html");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
        //       metode:

        public void enterknjigeokojimasepriča (String text) {
        print("Click on the search field");
            searchField.click();
         print("Send text in the search field");
            searchField.sendKeys(text);
        }
        public void clicksubmitButton() {
        print("Click on the submit button");
            submitButton.click();
        }
         public void clickpočetnaButton(){
        print("Click on the početna button");
        početnaButton.click();
         }
         public void clickbookKletva(){
        print("Click on the book Kletva ");
        bookKletva.click();

         }
     public String getText(){
        print("Get the error message text");
        return errormessageText.getText();
     }


         }







