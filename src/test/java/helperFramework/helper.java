package helperFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class helper {

    static String pathSelectLanguage = "/html/body/div/div/section/nav/section/div/div/ul/li[1]/a" ;

	/*
	 * The purpose of this function is to select in web site a language
	 *
	 * @Param driver
	 *
	 * @Param languageLocator
	 *
	 * @throws InterruptedException
	 */

    public  void SelectLanguageMenu(WebDriver driver, By languageLocator) throws InterruptedException {
        boolean elementNotFound = false;
        try{
            WebElement selectLanguage = driver.findElement(By.xpath(pathSelectLanguage));
            Actions builder = new Actions(driver);
            Action mouseOverselectLanguage = builder.moveToElement(selectLanguage).build();
            mouseOverselectLanguage.perform();
            waitElementVisibleOnPage(driver,languageLocator,1,"Element Language not visible");
            driver.findElement(languageLocator).click();
        } catch (Exception e) {
            elementNotFound = true;
            Assert.assertFalse(elementNotFound,"Element Language not visible");
        }
    }

 	/*
	 * The purpose of this function is wait till element visible on page is as bellow.
	 * It will wait max xx seconds for element.
	 *
	 * @Param driver
	 *
	 * @Param elementLocator
	 *
	 * @Param timer(seconds)
	 */

    public  void waitElementVisibleOnPage(WebDriver driver,By elementLocator,int timer,String messageFault){
        boolean elementNotFound = false;
        WebDriverWait waitElement = new WebDriverWait(driver, timer);
        try{
        WebElement element = waitElement.until(
                ExpectedConditions.visibilityOfElementLocated(elementLocator));
        }catch(Exception e){
            elementNotFound = true;
            Assert.assertFalse(elementNotFound,messageFault+" "+ elementLocator);
        }
    }

  	/*
	 * The purpose of this function is to execute the login of a registered user
	 *
	 * @Param driver
	 *
	 * @Param username
	 *
	 * @Param password
	 *
	 * @Param loginLocator
	 *
	 * @Param usernameLocator
	 *
	 * @Param passwordLocator
	 *
	 * @Param loginFormLocator
	 *
	 * @Param messageLocator
	 *
	 * @Throws Exception
	 */

    public void loginUser(WebDriver driver, String username, String password, By loginLocator,

                      By usernameLocator, By passwordLocator, By loginFormLocator,

                      By messageLocator) throws Exception{

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.equals("http://tartu.test.ridango.com/buy")){ // Tartu Webclient

            // Select Login
            driver.findElement(loginLocator).click();

            // Username field
            waitElementVisibleOnPage(driver, usernameLocator ,1,"Element Username not visible");
            driver.findElement(usernameLocator).sendKeys(username);

            // Password field
            driver.findElement(passwordLocator).sendKeys(password);

            // Login
            driver.findElement(loginFormLocator).submit();

            /* Check that the user authentication works correctly,
            the message "Login successful" have to be displayed */
            String messageLogin = driver.findElement(messageLocator).getText();
            messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message

            Assert.assertEquals("Login successful", messageLogin);
        }else if (currentUrl.equals("http://vl.test.ridango.com/login")){ // VL Webclient

            // Select Login
            driver.findElement(loginLocator).click();

            // Username field
            waitElementVisibleOnPage(driver, usernameLocator ,1,"Element Username not visible");
            driver.findElement(usernameLocator).sendKeys(username);

            // Password field
            driver.findElement(passwordLocator).sendKeys(password);

            // Login
            driver.findElement(loginFormLocator).submit();

            /* Check that the user authentication works correctly,
            the message "Login successful" have to be displayed */
            String messageLogin = driver.findElement(messageLocator).getText();
            messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message
            Assert.assertEquals("Login successful", messageLogin);

        }else if(currentUrl.equals("http://bussii.test.ridango.com/login")){ // Nuup Bussii Webclient

            // Select Login
            driver.findElement(loginLocator).click();

            // Username field
            waitElementVisibleOnPage(driver, usernameLocator ,1,"Element Username not visible");
            driver.findElement(usernameLocator).sendKeys(username);

            // Password field
            driver.findElement(passwordLocator).sendKeys(password);

            // Login
            driver.findElement(loginFormLocator).submit();

            /* Check that the user authentication works correctly,
            the message "Login successful" have to be displayed */
            String messageLogin = driver.findElement(messageLocator).getText();
            messageLogin = messageLogin.trim(); // Remove the blank space before and after the string message

            Assert.assertEquals("Login successful", messageLogin);
        }
    }

    /*
	 * The purpose of this function is to veify if a element is present or not on the page
	 * the function return a boolean value.
	 *
	 * @Param driver
	 *
	 * @Param locator
	 * return false (element not present)
	 *        true  (element present)
	 */

    public boolean isElementPresent(WebDriver driver,By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
