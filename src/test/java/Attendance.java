import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


    public class Attendance {

        public static WebDriver webdriver=null;
        @BeforeSuite
        public void suit1(){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aadivya\\Downloads\\chromedriver_win32\\chromedriver.exe");
            webdriver= new ChromeDriver();

        }

        @Test
        public void suit2() throws InterruptedException{
            webdriver.get("http://newers-world.qa2.tothenew.net");
            webdriver.manage().window().maximize();
            webdriver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("rohit.ojha@tothenew.com");
            webdriver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("newer@123");
            webdriver.findElement(By.xpath("//*[@type='submit']")).click();
            webdriver.findElement(By.linkText("Attendance")).click();  // click on Attendance Tab

            try {
                JavascriptExecutor jse = (JavascriptExecutor) webdriver;
                jse.executeScript("window.scrollBy(0,900)", "");
            } catch (Exception e) {
                //
            }

            Thread.sleep(4000);

            WebElement drop=webdriver.findElement(By.id("availableTimeType"));
            drop.findElements(By.tagName("option"));
            System.out.println(drop.getSize());
            Select sel = new Select(drop);
            sel.selectByIndex(3);

            Thread.sleep(2000);
            webdriver.findElement(By.id("startDate")).click();
            webdriver.findElement(By.xpath("//div[8]//tr[2]/td[4]")).click();
            // webdriver.findElement(By.id("startDate")).sendKeys("13-Nov-2018");
            //webdriver.findElement(By.id("endDate")).sendKeys("13-Nov-2018");

            Thread.sleep(5000);

            webdriver.findElement(By.id("endDate")).click();
            webdriver.findElement(By.xpath("//div[8]//tr[2]//td[6]")).click();

//        WebElement scroll = webdriver.findElement(By.xpath("//*[@id=\"applyForm\"]/div"));
//        JavascriptExecutor js = (JavascriptExecutor)webdriver;
//        js.executeScript("window.scrollBy(250,0)", "");

            Thread.sleep(1000);
            webdriver.findElement(By.xpath("//*[@id=\"applyForm\"]//td[7]//input")).sendKeys("Forget To Punch Inn");

            Thread.sleep(2000);

            webdriver.findElement(By.xpath("//*[@id=\"applyForm\"]//strong")).click();

            Thread.sleep(2000);

            webdriver.findElement(By.xpath("//*[@id=\"applyLeavesTab\"]//a")).click();


            webdriver.quit();



        }
    }


