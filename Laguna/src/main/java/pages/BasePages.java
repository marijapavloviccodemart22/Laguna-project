package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePages {
    ChromeDriver driver = null;
    // lokator
    @FindBy(xpath = "//a[@href='prijava.html']")
    WebElement prijavaField;

    @FindBy( xpath = "//a[text()='SLAŽEM SE']")
    WebElement cookies;

    @FindBy(xpath="//input[@id='pretraga_rec']")
    WebElement searchField;

    @FindBy(xpath = "//input[@id='pretraga_submit']")
    WebElement submitButton;

    @FindBy(xpath = "//a[@id='korpa_broj']")
    WebElement shoppingKorpa;

    @FindBy(xpath = "//a[@id='spisak_zelja.html']")
    WebElement spisakZeljaIcon;

    @FindBy(xpath = "//a[@href='odjava.html']")
    WebElement odjavaField;

    @FindBy(xpath = "//a[@id=\"zelje_broj\"]")
    WebElement numberWishButton;


    public void  print(String s){
        System.out.println(s);
    }




    //konstruktor:

    public BasePages(ChromeDriver driver){
        print("Get url");
       driver.get("https://www.laguna.rs/index.html");
        PageFactory.initElements(driver,this);
        this.driver=driver;
   }

    // metode

    public void clickPrijavaField() {
        print("Click on the prijava field");
        prijavaField.click();

    }

    public void  clickCookeis(){
        print("Click on the cookies");
        cookies.click();
    }

    public void clickodjavaField(){
        print("Click on the odjava field");
        odjavaField.click();
    }


     public String getNumber(){
        print("Get number from Wish cart");
        return numberWishButton.getText();
     }

     public String getText() {
        print("Get text from prijava field");
         return prijavaField.getText();


     }


     }


