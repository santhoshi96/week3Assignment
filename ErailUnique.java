package Week3.day2.assignment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		Map<Integer,String> trainNamesMap = new LinkedHashMap<Integer,String>();
		
		WebElement table = driver.findElement(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']"));
		
		List<WebElement> trainNames = table.findElements(By.xpath("//table[@class = 'DataTable TrainList TrainListHeader']//tr/td[2]"));
		
		int sizeoftrainNames = trainNames.size();
		
		for (int i = 0; i < sizeoftrainNames; i++) {
			trainNamesMap.put(i+1, trainNames.get(i).getText());
			
		}
		System.out.println("Map size - "+trainNamesMap.size());
		System.out.println(trainNamesMap);

		
	}

}
