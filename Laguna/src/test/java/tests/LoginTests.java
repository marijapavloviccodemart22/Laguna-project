package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePages;
import pages.LoginPage;
import pages.Strings;

public class LoginTests extends BaseTest {

    /* Login with valid credentials
    1.Navigate to Base Page(home page)
    2.Click cookies
    3.Click prijava field
    4.Navigate to Login Page
    5.Enter valid korisnički broj
    6.Enter valid lozinka
    7.Click on the prijava button

    Expected results:
    Verify that the user is login with member name(Marija Nikolić)

     */

    @Test
    public void loginWithValidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try {

         print("Navigate to Base Pages");
         BasePages basePages=new BasePages(driver);
         print("click on cookeis");
         basePages.clickCookeis();
            print("Click on the prijavaField");
            basePages.clickPrijavaField();
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);
            print("Enter korisnički broj ili mejl");
            loginPage.enterkorisničkibrojiliimejl(Strings.VALID_KORISNIČKI_BROJ_ILI_MEJL);
            print("Enter lozinka");
            loginPage.enterlozinka(Strings.VALID_LOZINKA);
            print("Click on the prijavabutton");
            loginPage.clickPrijavaButton();
            print("Get name of member");
             String actualNameOfMember=loginPage.getText();
             print("Verify that the name of member is Marija Nikolić");
          assert actualNameOfMember.equals(Strings.NAME_OF_MEMBER):"Wrong name.Expected" + Strings.NAME_OF_MEMBER + "Actual: " + actualNameOfMember;

        } finally {

            driver.quit();



        }

    }
    /* Login with invalid credentials
    1. Navigate to Base Page(home page)
    2.Click cookies(slažem se)
    3.Click prijava field
    4.Navigate to Login Page
    5.Enter valid korisnički broj
    6.Enter invalid lozinka
    7,Click on the prijava button

    Expected results:
    Verify that the user is not login(there is no welcome message only prijava field)

     */
    @Test
    public void loginWithInvalidCredentials() {
        ChromeDriver driver = openChromeDriver();
        try {
            print("Navigate to Base Pages");
            BasePages basePages=new BasePages(driver);
            print("Click on cookies");
            basePages.clickCookeis();
            print("Click on the prijava field");
            basePages.clickPrijavaField();
            print("Navigate to login page");
            LoginPage loginPage = new LoginPage(driver);
            print("Enter korisnički broj ili Imejl");
            loginPage.enterkorisničkibrojiliimejl(Strings.VALID_KORISNIČKI_BROJ_ILI_MEJL);
            print("Enter lozinka");
            loginPage.enterlozinka(Strings.INVALID_LOZINKA);
            print("Click on the prijava button");
            loginPage.clickPrijavaButton();
            print("Get text from prijava field");
            String actualTextFromPrijavaField=basePages.getText();
            print("Verify that the text is Prijava");
            assert actualTextFromPrijavaField.equals(Strings.PRIJAVA_FIELD_TEXT):"Wrong text.Expected" + Strings.PRIJAVA_FIELD_TEXT + "Actual:" + actualTextFromPrijavaField;
        } finally {
            driver.quit();


        }
        }

    /* Login with valid credentials and logout
    1.Login With valid credentials
    2.Click logout button

    Expected results:
    Verify that the url is correct

     */
       @Test
    public void logout(){
     ChromeDriver driver=openChromeDriver();
     try{
     print("Navigate to login page");
      login(driver);
      print("Navigate to base page");
      BasePages basePages=new BasePages(driver);
      print("Click  on the odjava field");
      basePages.clickodjavaField();
      print("Verify that the url is correct");
      assert driver.getCurrentUrl().equals(Strings.BASE_PAGES_URL):"Wrong url. Expected:" + Strings.BASE_PAGES_URL +"Actual:" + driver.getCurrentUrl();


     }finally {

         driver.quit();

     }
       }

    }





















