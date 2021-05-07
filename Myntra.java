package Week3.day2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//a[text() = 'Women']"));
		actions.moveToElement(women).perform();
		driver.findElement(By.linkText("Jackets & Coats")).click();
		WebElement totalCount = driver.findElement(By.xpath("//h1[text()='Coats & Jackets For Women']/following-sibling::span"));
		System.out.print(totalCount.getText());
		String jackets = driver.findElement(By.xpath("//label[text()='Jackets']")).getText();
		jackets = jackets.replaceAll("\\D", "");
		String coats = driver.findElement(By.xpath("//label[text()='Coats']")).getText();
		coats = coats.replaceAll("\\D", "");
		int sumOfCategories = Integer.parseInt(jackets) + Integer.parseInt(coats);
		System.out.println(jackets + " + " + coats + " = " + sumOfCategories);
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[2]")).click();
		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		driver.findElement(By.xpath("//span[@class='FilterDirectory-count']/following-sibling::div[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		Thread.sleep(2000);
		String Mango = driver.findElement(By.xpath("(//div[@class='filter-summary-filter'])[2]")).getText();
		if (Mango.equalsIgnoreCase("MANGO")) {
			System.out.println("All the coats are belongs to MANGO brand");
		} else {
			System.out.println("Need to check");
		}
		WebElement sortBy = driver.findElement(By.className("sort-sortBy"));
		WebElement LowtoHigh=driver.findElement(By.xpath("//label[text()='Price: Low to High']"));
		actions.moveToElement(sortBy).moveToElement(LowtoHigh).click().perform();
		System.out.println("Sorted to Low to High");
		String rs = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("Price of first displayed item: " + rs);
		WebElement firstitem = driver.findElement(By.xpath("(//div[@class='product-price']//span)[2]"));
	    WebElement wishList = driver.findElement(By.xpath("//span[contains(@class,'product-wishlistFlex product-actionsButton')]"));
				actions.moveToElement(firstitem).moveToElement(wishList).click().perform();
			
				driver.close();
		
	}

}
