package com.flipkart.pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flipkart_pagination {

	static String nextclassname;

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver","C:\\Users\\manik\\Downloads\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com/search?q=apple+mobiles&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_1_5_na_na_ps&otracker1=AS_QueryStore_OrganicAutoSuggest_1_5_na_na_ps&as-pos=1&as-type=RECENT&suggestionId=apple+mobiles%7CMobiles&requestId=66d30181-7125-4edc-b93e-15c8a59725ca&as-backfill=on&page=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		

		int numberofpages = driver.findElements(By.xpath("//a[@class='ge-49M']")).size();
		System.out.println(numberofpages);

		List<WebElement> productnames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<String> product = new ArrayList<String>();

		for (WebElement products : productnames) {

			product.add(products.getText());
			System.out.println(products.getText());
		}

		System.out.println("********************************************************************");

		while (true) {
			
			WebElement nextbutton = driver.findElement(By.xpath("/html/body/div/div/div[3]/div[1]/div[2]/div[26]/div/div/nav/a[11]"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			nextbutton.click();
			productnames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

			for (WebElement products : productnames) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				product.add(products.getText());
				System.out.println(products.getText());
			}

			System.out.println("********************************************************************");

			try {
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				nextbutton.click();

			}

			catch (Exception e) {

				System.out.println("NO More Pages");
				break;
			}
			
		}

		System.out.println("********************************************************************");
		System.out.println("No of products are : " + productnames.size());
		System.out.println("No of displayed products are : " + numberofpages);
		
	}
}
