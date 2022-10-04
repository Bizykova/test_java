package org.bizykova;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.dns-shop.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sleep(2000);

        Actions act= new Actions(driver);

        WebElement element = driver.findElement(By.xpath("//header//nav[@id='header-search']//input[@type='search']"));
        element.sendKeys("Смартфоны", Keys.ENTER);
        sleep(2000);
        WebElement price = driver.findElement(By.xpath("//div[@class = 'ui-input-small ui-input-small_list'][2]//input"));
        price.sendKeys("20000",Keys.ENTER);
        sleep(2000);
        List<WebElement> brandList =driver.findElements(By.xpath("//div[@data-id ='brand']//div[@class='ui-checkbox-group ui-checkbox-group_list']//label[@class='ui-checkbox ui-checkbox_list']"));
        System.out.println("element");
        System.out.println(brandList.size());
        sleep(2000);
        for(int i=0; i<brandList.size(); i++){
            String key = brandList.get(i).getText();
            sleep(200);
            if(brandList.get(i).isDisplayed()){
                System.out.println(key);
                WebElement checkBox = brandList.get(i).findElement(By.className("ui-checkbox__input"));
                boolean isSelected = checkBox.isSelected();
                if(checkBox != null && isSelected == false){
                    act.moveToElement(checkBox).click().build().perform();
                }
            }
        }
        //System.out.println("element99");
        sleep(4000);


       // JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       // int count = 0;


       //List<WebElement> diagonalList = driver.findElements(By.cssSelector(".ui-collapse.ui-collapse_list"));
       //for(int s =0; s<diagonalList.size(); s++){
       //    if(diagonalList.get(s).isDisplayed()){
       //        act.moveToElement(diagonalList.get(s)).click().build().perform();
       //    }
       //}

        // WebElement diagonal = driver.findElement(By.xpath("//*[text() ='Количество ядер']"));
        // act.moveToElement(diagonal).build().perform();
        // diagonal.clik();


        driver.quit();

    }

}