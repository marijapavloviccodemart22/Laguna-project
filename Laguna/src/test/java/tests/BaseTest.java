package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePages;
import pages.InventoryPage;
import pages.LoginPage;
import pages.Strings;

import java.sql.SQLOutput;

public class BaseTest {
      ChromeDriver driver;
      ChromeDriver openChromeDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
  //      options.addArguments(new String[]{"--incognito"});/       options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;


    }

    public void scrollIntoVieW(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[o].scrollIntoView(true");
    }

      public void  print(String s){
          System.out.println(s);
      }

     public void login(ChromeDriver driver){
         print("navigate to Base Pages");
         BasePages basePages=new BasePages(driver);
         print("click on cookeis");
         basePages.clickCookeis();
         print("Click on the PrijavaField");
         basePages.clickPrijavaField();
         print("Navigate to login page");
         LoginPage loginPage = new LoginPage(driver);
         print("Enter korisnički broj ili mejl");
         loginPage.enterkorisničkibrojiliimejl(Strings.VALID_KORISNIČKI_BROJ_ILI_MEJL);
         print("Enter Lozinka");
         loginPage.enterlozinka(Strings.VALID_LOZINKA);
         print("Click on the Prijava Button");
         loginPage.clickPrijavaButton();

     }


     }


