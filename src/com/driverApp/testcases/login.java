package com.driverApp.testcases;
import com.drivervms.apicalls.*;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

//import static org.junit.Assert.assertEquals;

public class login {
    AppiumDriver driver;
@BeforeTest
public void testCaseSetup()throws  Exception
        {
	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/app");
	File app = new File(appDir, "app-qa.apk");
	System.out.println(app.getAbsolutePath());
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
     // cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        cap.setCapability(MobileCapabilityType.APP, app);
     // cap.setCapability("noReset", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
          /*  Location loc =new Location(20.0,12.5,1000);
            driver.setLocation(loc);


            MobileElement myDynamicElement = (MobileElement) (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));*/
        }
        @Test(priority=1)   // driver not found message
        public void invalidPnumber() throws InterruptedException, IOException {
     //  apitestcall.updateDriverReportimes();
        	driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270000");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String getButtonText=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        System.out.println("printing screen");
   //     AssertEquals(getButtonText,"SIGN UUP");
        Assert.assertEquals(getButtonText, "SIGN UUP");
        }
       @Test(priority=2)
        public void ivrConfirmationTrue() throws InterruptedException {
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
            driver.hideKeyboard();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
            Thread.sleep(10000);
            String VehicleToSelect="RJ5TA0004";
            driver.scrollToExact(VehicleToSelect).click();
            Thread.sleep(5000);
            ScreenOrientation orientation;
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
            String loginSuccessText="Your reporting schedule";
            WebDriverWait wait=new WebDriverWait(driver,120);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
            String loginSuccessTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text").getText();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
            driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_image").click();
     //       assertEquals(loginSuccessText,loginSuccessTextMobile);
            Assert.assertEquals(loginSuccessText, loginSuccessTextMobile);
       }

    @Test (priority=3) // login with IVR confirmation false
    public void ivrConfirmationFalse() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
     //   assertEquals(signUpButtonTextMobile,signUpButtonText);
      Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }

       @Test(priority=4)// change vehicle ivr confirmation true
    public void changeVehicleIvrConfirmationTrue() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/rep_schedule_text")));
        String vehicleNumberTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/toolbar_subtitle").getText();
        //assertEquals(vehicleNumberTextMobile,VehicleToSelect);
     Assert.assertEquals(vehicleNumberTextMobile,VehicleToSelect);
       }

     @Test(priority=5) // change vehicle ivr confirmation false
    public void changeVehicleIvrConfirmationFalse() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="RJ5TA0004";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        System.out.println("here before");
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
        System.out.println("here1 : "+ signUpButtonTextMobile);
      //  assertEquals(signUpButtonTextMobile,signUpButtonText);
          Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }
   // 9935828842

    @Test(priority=6)    // vehicle is already assigned to some other driver (pass vehicle that is already allocated trip)
    public void changeVehicleVehicleAlreadyAssigned() throws InterruptedException, IOException {
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
        driver.hideKeyboard();
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
        Thread.sleep(10000);
        String VehicleToSelect="SHUTTL0000";
        driver.scrollToExact(VehicleToSelect).click();
        Thread.sleep(5000);
        driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
        WebDriverWait wait=new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
        String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
        String signUpButtonText="SIGN UP";
        System.out.println("here1 : "+ signUpButtonTextMobile);
     //   assertEquals(signUpButtonTextMobile,signUpButtonText);
        Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
    }

     @Test(priority=7)    // driver cannot access vehicle that is mark as absent (pass vehicle name that is already allocated trip)
      public void vehicleMarkAsAbsent() throws InterruptedException, IOException {
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/edit_mobile_no").sendKeys("9540270015");
          driver.hideKeyboard();
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").click();
          Thread.sleep(10000);
          String VehicleToSelect="SHUTTL0000";
          driver.scrollToExact(VehicleToSelect).click();
          Thread.sleep(5000);
          driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_in_button").click();
          WebDriverWait wait=new WebDriverWait(driver,120);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.id("app.goplus.in.myapplication.driver.qa:id/sign_up_button")));
          String signUpButtonTextMobile=driver.findElementById("app.goplus.in.myapplication.driver.qa:id/sign_up_button").getText();
          String signUpButtonText="SIGN UP";
          System.out.println("here1 : "+ signUpButtonTextMobile);
    //    assertEquals(signUpButtonTextMobile,signUpButtonText);
         Assert.assertEquals(signUpButtonTextMobile,signUpButtonText);
      }
    @AfterTest
public void testCaseTearDown()
        {
           driver.quit();
        }
    }
