package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Book;

public class BookKletvaPage extends BasePages {

 // lokatori:

 @FindBy(xpath ="//a[@id='dugme-zelje']")
 WebElement zeljaButton;






 // konstruktor:

 public BookKletvaPage(ChromeDriver driver){
        super(driver);
        print("Driver get url");
        driver.get("https://www.laguna.rs/n5482_knjiga_kletva_laguna.html");
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }

    //metode:

    public void clickzeljaButton(){
     print("Click on the Želja button ");
     zeljaButton.click();
    }






    }


