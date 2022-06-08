package projectphaseone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class products {
	

	
	
	WebDriver driver;
	String url ="https://www.amazon.com/";
    
	public products(WebDriver driver)
    {this.driver = driver;}

    
    
    public void searchproduct(String strname) throws InterruptedException
    {
     
   	 driver.get(url);
   	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(strname);
   	 Thread.sleep(2000);
   	 driver.findElement(By.id("nav-search-submit-button")).click();
   	
   	
   	   	 
    }
    public void insertdb(Connection conn,String strname) throws InterruptedException, ClassNotFoundException, SQLException
    {
    	
    	/**/
    	
    	/**/
    driver.get(url);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(strname);
  //  Thread.sleep(2000);
    driver.findElement(By.id("nav-search-submit-button")).click();
   	 
   	List<WebElement> wlist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	System.out.println(wlist.size());
   //	Thread.sleep(5000);
	int i=0;
	for(WebElement lks : wlist)
   	{
		i=i+1;
	//	System.out.println(i);
	//	System.out.println(lks.getText());
		String qry = "insert into valproducts values("+i+",'"+lks.getText()+"')";
		Statement statement = conn.createStatement();
		statement.executeUpdate(qry);	
	//	System.out.println("\n");
		
	}
	System.out.println("Records Inserted to Valproducts table");
		
    }
    public void validateproducts(Connection conn,String strname) throws SQLException
    {   /**/
    	String qry = "select * from valproducts";
//		Statement
		Statement statement = conn.createStatement();
//		Execute Query
	//	ResultSet rs = statement.executeQuery(qry);
		 /**/
		  driver.get(url);
		    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(strname);
		  //  Thread.sleep(2000);
		    driver.findElement(By.id("nav-search-submit-button")).click();
		   	 
		   	List<WebElement> wlist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//	System.out.println(wlist.size());
		 /**/
		 /**/
			int k=0;
			String str;
		 /**/
//		for(WebElement lks : wlist)
		for(int j=0;j<wlist.size();j++)	
		   	{
			str = wlist.get(j).getText().toString();
			ResultSet rs = statement.executeQuery(qry);
			while (rs.next()==true)
			{
		//	System.out.println(rs.next());
		//	System.out.println(str);
		//	System.out.println(rs.getString(2));
				if(rs.getString(2).equals(str))
					{k=k+1;}
			}
			
		}
		 /*Result*/
		System.out.println(k+" validation number items matched with data base");
    }
    public void deletetab(Connection conn) throws SQLException
    {   /**/
    	String qry = "delete from valproducts";
//		Statement
		Statement statement = conn.createStatement();
//		Execute Query
		statement.executeUpdate(qry);
		System.out.println("Records Deleted from Valproducts table");
    }
    public void clickproduct(String lname) throws InterruptedException
    {
    	
    	driver.get(url);
    	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(lname);
       	 Thread.sleep(2000);
       	 driver.findElement(By.id("nav-search-submit-button")).click();
       	Thread.sleep(2000);
       	driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();
   	 
    }
    public void end() throws InterruptedException
    {
     
   	 driver.quit();
    }
   
}
