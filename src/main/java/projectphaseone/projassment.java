package projectphaseone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class projassment {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		
//		Register class
		Class.forName("com.mysql.jdbc.Driver");
//		Connection    url jdbc:mysql://localhost:3306/dbname
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poneass", "root", "root");

//     web driver and class		
		WebDriver driver = new ChromeDriver();
		products page = new products(driver);
		menus menu = new menus(driver); 
			
		// Search product first test case
			page.searchproduct("mobile");
			
		//Search and Click product second test case 
				page.clickproduct("dell labtop");
		
				
		//Menu selection next menu class
			Thread.sleep(2000);
			menu.selectmenuAmazonBasics();
			menu.selectmenuBestSeller();
			menu.selectmenuNewRelases();
			
	  //validate product from database third test case
			page.insertdb(conn,"dell Keyboard");
			page.validateproducts(conn,"dell Keyboard");
			page.deletetab(conn);			
		
		//Close the browser
			page.end();
	}
	
	
		
		
	

}
