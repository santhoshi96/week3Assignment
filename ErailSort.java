package Week3.day2.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("MSB");
		fromStation.sendKeys(Keys.TAB);
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("KKDI");
		toStation.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("buttonFromTo")).click();
WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		
		List<WebElement> trainNames = table.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td[2]"));
		List<String> sortedTrainNames = new ArrayList<String>();
		
		for (int i = 0; i < trainNames.size(); i++) {
			sortedTrainNames.add(i,trainNames.get(i).getText());
		}
		Collections.sort(sortedTrainNames);
		System.out.println(sortedTrainNames);

	}

}
