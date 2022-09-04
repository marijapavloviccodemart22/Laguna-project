package tests;

import org.omg.CORBA.Current;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.StringJoiner;

public class InventoryTests extends BaseTest {
    /* Searching for non-existent book and verify that the book is not exist

    1.Login with valid credentials
    2.Enter name of non-existent book in search field
    4.Click search field button

    Expected result:
    1.Verify that the url is correct
    2.Verify the message is no book found

     */

    @Test
    public void searchForInvalidItem() {
        ChromeDriver driver = openChromeDriver();
        try {
            print(" Navigate to Login Page");
            login(driver);
            print("Navigate to the Inventory Page");
            InventoryPage inventoryPage = new InventoryPage(driver);
            print("Enter invalid name in the search field ");
            inventoryPage.enterknjigeokojimasepriča(Strings.INVALID_NAME);
            print("Click the search button");
            inventoryPage.clicksubmitButton();
            print("Get error message");
            String actualErrorMessageText=inventoryPage.getText();
            print("Verify that error message is no book found");
            assert actualErrorMessageText.equals(Strings.NO_BOOK_FOUND):"Wrong message.Expected" +Strings.NO_BOOK_FOUND + "Actual:" + actualErrorMessageText;
            print("Verify that url is correct");
            assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "Wrong url.Expected" + Strings.INVENTORY_PAGE_URL + "Actual:" + driver.getCurrentUrl();


        } finally {
            driver.quit();

        }
    }
    /* Searching for non-existent book and verify returning to main page
    1.Login with valid credentials
    2.Enter the name of non-existent book in search field
    3.Click search field button
    4.Click return button

    Expected result:
    1. Verify that the url is correct

     */
      @Test
      public void searchForInvalidItemAndReturnToMainPage(){
      ChromeDriver driver=openChromeDriver();
      try{

          print(" Navigate to Login Page");
          login(driver);
          print("Navigate to the Inventory Page");
          InventoryPage inventoryPage = new InventoryPage(driver);
          print("Enter invalid name in the search field ");
          inventoryPage.enterknjigeokojimasepriča(Strings.INVALID_NAME);
          print("Click the search button");
          inventoryPage.clicksubmitButton();
          print("Click on the početna button");
          inventoryPage.clickpočetnaButton();
          print("Verify that the url is correct");
          assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL1) :"Wrong url.Expected " + Strings.INVENTORY_PAGE_URL1 + "Actual:" + driver.getCurrentUrl();


      }finally {
         driver.quit();
      }
      }
     /* Searching for the book and verify choosing the book
      1.Login with valid credentials
      2.Enter the name of book in search field
      3.Click the search button
      4.Click on the book

      Expected result:
      1.Verify that the url is correct

      */

      @Test
    public void searchForValidItem() {
          ChromeDriver driver = openChromeDriver();
          try {
              print("Navigate to the Login Page");
              login(driver);
              print("Navigate to the Inventory Page");
              InventoryPage inventoryPage = new InventoryPage(driver);
              print("Enter Valid name in the search field");
              inventoryPage.enterknjigeokojimasepriča(Strings.VALID_NAME);
              print("Click on the search button");
              inventoryPage.clicksubmitButton();
              print("Click on the book Kletva");
              inventoryPage.clickbookKletva();
              print("Verify that the url is correct");
              assert driver.getCurrentUrl().equals(Strings.BOOK_KLETVA_PAGE):"Wrong url.Expected:" +Strings.BOOK_KLETVA_PAGE + "Actual:" + driver.getCurrentUrl();
          } finally {
              driver.quit();
          }
      }
      /*Putting the Book on the wish list and verify the number of book in list
      1.Login with valid credentials
      2.Enter the name of book in search field
      3.Click on search button
      4.Choose the book
      5. Click on the wish button

      Expected result:
      Verify that the one book is in the wish list

       */
        @Test
        public void putItemToTheWishList() {
            ChromeDriver driver=openChromeDriver();
              try {
             print("Navigate to Base Page");
             BasePages basePages=new BasePages(driver);
             print("Navigate to Login Page");
                  login(driver);
              print("Navigate to Inventory Page");
              InventoryPage inventoryPage=new InventoryPage(driver);
              print("Enter ValidName in the search field");
              inventoryPage.enterknjigeokojimasepriča(Strings.VALID_NAME);
              print("Click on the search button");
              inventoryPage.clicksubmitButton();
              print("Click on Book Kletva");
              inventoryPage.clickbookKletva();
              print("Navigate to Book Kletva Page");
                  BookKletvaPage bookKletvaPage=new BookKletvaPage(driver);
                  print("Click on the Zelja button");
                  bookKletvaPage.clickzeljaButton();
                  print("Get number from wish button");
                  String actualNumberFromnumberwishButton=basePages.getNumber();
                  print(" Verify that The number in wish list is correct");
                  assert actualNumberFromnumberwishButton.equals(Strings.VALID_NUMBER_OF_WISH_LIST):"Wrong number in wish cart.Expected:"+Strings.VALID_NUMBER_OF_WISH_LIST + "Actual:" + actualNumberFromnumberwishButton;

              }finally {
                  driver.quit();
              }
          }
          }



