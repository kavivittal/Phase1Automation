package projectphaseone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class menus {
	WebDriver driver;
    String url ="https://www.amazon.com/";
   
    
    
    public menus(WebDriver driver){this.driver = driver;}


	public void selectmenuBestSeller() throws InterruptedException
    {
   	 driver.get(url);
   	 driver.findElement(By.xpath("//a[text()='Best Sellers']")).click();
   	 Thread.sleep(2000);
 	 }
    public void selectmenuAmazonBasics() throws InterruptedException
    {
   	 driver.get(url);
   	 driver.findElement(By.xpath("//a[text()='Amazon Basics']")).click();
   	 Thread.sleep(2000);
 	 }
    public void selectmenuNewRelases() throws InterruptedException
    {
   	 driver.get(url);
   	 driver.findElement(By.xpath("//a[text()='New Releases']")).click();
   	 Thread.sleep(2000);
 	 }

}
