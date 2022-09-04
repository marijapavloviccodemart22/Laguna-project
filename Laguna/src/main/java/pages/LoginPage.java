package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePages {


//    Lokatori:

    @FindBy(xpath = "//input[@id='broj-f']")
    WebElement korisničkibrojiliimejlField;

    @FindBy(xpath = "//input[@id='lozinka-f']")
    WebElement lozinkaField;

    @FindBy(xpath = "//a[@id='form-prijava-s']")
    WebElement prijavaButton;

    @FindBy(xpath = "//a[@href='profil_clana.html']")
    WebElement nameofMember;



 //   konstruktor:

    public LoginPage(ChromeDriver driver){
       super(driver);
       print("Driver get url");
       driver.get("https://www.laguna.rs/prijava.html");
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

//       metode:


    public void enterkorisničkibrojiliimejl(String korisničkibrojiliimejl){
        print("Click on the korisnički broj ili imajl field");
        korisničkibrojiliimejlField.click();
        print("Enter the valid korisnički broj in the field ");
        korisničkibrojiliimejlField. sendKeys(korisničkibrojiliimejl);

    }

    public void enterlozinka(String lozinka){
        print("Click on the lozinka field");
        lozinkaField.click();
        print("Enter lozinka in the field");
        lozinkaField.sendKeys(lozinka);

    }

    public void clickPrijavaButton(){
        print("Click on the prijava button");
        prijavaButton.click();

    }





     public String getText(){

        return nameofMember.getText();
     }

     }


















