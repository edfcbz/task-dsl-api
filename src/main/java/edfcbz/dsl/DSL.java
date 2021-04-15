package edfcbz.dsl;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.List;

//import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * * DSL class This API define a couple of methods for Functional Text, in
 * Mobile (ANDROID) and Web environment.
 * 
 * @author Eduardo Carneiro
 * @version 1.00
 * @since 2020/03/01
 */

public class DSL {

	public AndroidDriver<MobileElement> driver;

	public DSL(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void closeConnection() {
		driver.close();
	}

	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}

	public void clickById(By by) {
		driver.findElement(by).click();
	}

	/**
	 * <b> Definition:      </b> This method verify if a component with id and text informed exist                         <p>
	 * <b> Scenery:         </b> It necessary verify if a Label or TextField 'Login' component, exist on the screen        <p>
	 * <b> Use tip:         </b> Boolean existComponent = findElementByIdAndSubstring("login_component_ID", "Type login"); <p>
	 * <b> Expected result: </b> TRUE or FALSE                                                                             <p> 
	 * @author Eduardo Carneiro										
	 * @param id   component's verified on the source code          
	 * @param text expected in the component. Example: "Type login" 
	 * @return Boolean TRUE or FALSE								
	 * @version 1.00												
	 * @since 2020/03/01 											
	 */
	public boolean findElementByIdAndSubstring(String id, String text) {
		return driver.findElement(By.id(id)).getText().contains(text);
	}

	/**
	 * <b> Definition:      </b> This method click in component id informed as string <p>
	 * <b> Scenery:         </b> It necessary select a button       <p>
	 * <b> Use tip:         </b> clickByIdAsString(String id);      <p>
	 * <b> Expected result: </b> Chance a page or Show a message    <p> 
	 * @author Eduardo Carneiro										
	 * @param id component's verified on the source code            
	 * @version 1.00												
	 * @since 2020/03/01										
	 */	
	public void clickByIdAsString(String id) {
		driver.findElement(By.id(id)).click();
	}

	/**
	 * <b> Definition:      </b> This method verify if radio button or other are checked <p>
	 * <b> Scenery:         </b> It necessary verify if component are selected       <p>
	 * <b> Use tip #1:      </b> isChecked(By by); If you knoe the component      <p>
	 * <b> Use tip #2:      </b> isChecked( findElementById("element_id"));       <p>
	 * <b> Expected result: </b> TRUE or FALSE                      <p> 
	 * @author Eduardo Carneiro										
	 * @param by component's verified on the source code            
	 * @return Boolean	    	         						
	 * @version 1.00												
	 * @since 2020/03/01 											
	 */		
	public boolean isChecked(By by) {
		return driver.findElement(by).getAttribute("checked").equals("true");
	}

	/**
	 * <b> Definition:      </b> This method verify if radio button or other are checked <p>
	 * <b> Scenery:         </b> It necessary verify if component are selected       <p>
	 * <b> Use tip #1:      </b> isChecked(By by); If you knoe the component      <p>
	 * <b> Use tip #2:      </b> isChecked( findElementById("element_id"));       <p>
	 * <b> Expected result: </b> TRUE or FALSE                      <p> 
	 * @author Eduardo Carneiro										<p>
	 * @param text component's verified on the source code            <p>
	 * @return No return	    	         						<p>
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */		
	public boolean existElementByText(String text) {
		return driver.findElements(By.xpath("//*[@text='" + text + "']")).size() > 0;
	}
	
	/**
	 * <b> Definition:      </b> This method write in the text component <p>
	 * <b> Scenery:         </b> It necessary fill login or password       <p>
	 * <b> Use tip #1:      </b> locate the component by findElementById("element_id") or findElementByText("Fill your password") methods   <p>
	 * <b> Use tip #2:      </b> Using the prior method (tip #1) as parameter writeText(findElementById("component_id"), String text);       <p>
	 * <b> Expected result: </b> Fill field text                    <p> 
	 * @author Eduardo Carneiro										<p>
	 * @param by - Is a component returner                          <p>
	 * @param text - Text in the component                          <p>
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */		
	public void writeText(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}

	
	/**
	 * <b> Definition:      </b> This method write in the text component <p>
	 * <b> Scenery:         </b> It necessary fill login or password     <p>
	 * <b> Use tip:         </b> Fill text in component text using: writeTextById("component_id", "text")  <p>
	 * <b> Tip:             </b> The DSL API will search a component according id informed and fill text field with parameter <p>
	 * <b> Expected result: </b> Filled field text                    <p> 
	 * @author Eduardo Carneiro										<p>
	 * @param id - Is a component id                                <p>
	 * @param text - Text in the component                          <p>
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */		
	public void writeTextById(String id, String text) {
		driver.findElementById(id).sendKeys(text);
	}

	
	/**
	 * <b> Definition:      </b> This method search an Mobile element according text as parameter <p>
	 * <b> Scenery:         </b> It necessary search and capture a component in the screen  <p>
	 * <b> Use tip:         </b> Fill the parameter with text in the component target findElementByText("Fill your password")   <p>
	 * <b> Expected result: </b> Returned Mobile Component                    <p> 
	 * @author Eduardo Carneiro										<p>
	 * @param elementText - Text in the component                          <p>
	 * @return MobileElement
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */	
	public MobileElement findElementByText(String elementText) {
		return driver.findElement(By.xpath("//*[@text='" + elementText + "']"));
	}

	
	/**
	 * <b> Definition:      </b> This method search an Mobile element according text as parameter <p>
	 * <b> Scenery:         </b> It necessary search and capture a component in the screen  <p>
	 * <b> Use tip:         </b> Fill the parameter with text in the component target findElementByText("Fill your password")   <p>
	 * <b> Expected result: </b> Returned Mobile Component                    <p> 
	 * @author Eduardo Carneiro		
	 * @param classe - Class of component                          <p>
	 * @param elementText - Text in the component                          <p>
	 * @return MobileElement
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */	
	public MobileElement findElementByClassAndText(String classe, String elementText) {
		return driver.findElement(By.className(classe + "[@text='" + elementText + "']"));
	}

	/**
	 * <b> Definition:      </b> This method search an Mobile element according component class <p>
	 * <b> Scenery:         </b> It necessary search and capture a component in the screen  <p>
	 * <b> Use tip:         </b> Fill the parameter with component class target findElementByClass("component_class")   <p>
	 * <b> Expected result: </b> Returned Mobile Component                    <p> 
	 * @author Eduardo Carneiro		
	 * @param elementClass - Text in the component 
	 * @return MobileElement
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */		
	public MobileElement findElementByClass(String elementClass) {
		return driver.findElement(By.className(elementClass));
	}

	/**
	 * <b> Definition:      </b> This method search an Mobile element according text <p>
	 * <b> Scenery:         </b> It necessary search and capture a component in the screen  <p>
	 * <b> Use tip:         </b> Fill the parameter with text findElementByTextUP("Text Target")   <p>
	 * <b> Expected result: </b> Returned Mobile Element                    <p> 
	 * @author Eduardo Carneiro		
	 * @param elementText - Text in the component 
	 * @return MobileElement
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */		
	public MobileElement findElementByTextUP(String elementText) {
		return driver.findElement(By.xpath("//*[@text='" + elementText + "']/.."));
	}

	
	/**
	 * <b> Definition:      </b> Advanced feature: This method search an Mobile element according xpath <p>
	 * <b> Scenery:         </b> It necessary search and capture a component path in the screen  <p>
	 * <b> Use tip:         </b> Fill the parameter with path findElementByPath("Text path")   <p>
	 * <b> Expected result: </b> Returned Mobile Element                    <p> 
	 * @author Eduardo Carneiro		
	 * @param path - Text in the component 
	 * @return MobileElement
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */	
	public MobileElement findElementByPath(String path) {
		return driver.findElement(By.xpath(path));
	}

	
	/**
	 * <b> Definition:      </b> This method hide a keyboard showed on the screen <p>
	 * <b> Scenery:         </b> It necessary close the keyboard on th screen  <p>
	 * <b> Use tip:         </b> call DSL method hideKeyboard()   <p>
	 * <b> Expected result: </b> Close keyborad 
	 * @author Eduardo Carneiro		
	 * @version 1.00												<p>
	 * @since 2020/03/01 											
	 */	
	public void hideKeyboard() {
		driver.hideKeyboard();
	}

	/**
	 * <b> Definition:      </b> This method select one item in comboBox component <p>
	 * <b> Scenery:         </b> Selecting specific item in combobox Component   <p>
	 * <b> Use tip:         </b> selectComboBox(findElementById( "elemento_id" ), "Brazil")   <p>
	 * <b> Expected result: </b> String target selected 
	 * @author Eduardo Carneiro		
	 * @param by - Mobile Component 
	 * @param comboItem - Text in comboBox   
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void selectComboBox(By by, String comboItem) {
		driver.findElement(by).click();
		clickByText(comboItem);
	}

	/**
	 * <b> Definition:      </b> This method select Mobile Component by id <p>
	 * <b> Scenery:         </b> Selecting specific component from screen   <p>
	 * <b> Use tip:         </b> findElementById("element_Id")  <p>
	 * <b> Expected result: </b> Founding element 
	 * @author Eduardo Carneiro		
	 * @param id - Element_id 
	 * @return MobileElement
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public MobileElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	/**
	 * <b> Definition:      </b> This method find MobileElement if exist <p>
	 * <b> Scenery:         </b> testing if element exist in the screen   <p>
	 * <b> Use tip:         </b> existElementById(String id)  <p>
	 * <b> Expected result: </b> Founding element 
	 * @author Eduardo Carneiro		
	 * @param id - Element_id 
	 * @return boolean
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public boolean existElementById(String id) {
		MobileElement element = driver.findElement(By.id(id));
		if (!element.equals(null))
			return true;
		else
			return false;
	}

	/**
	 * <b> Definition:      </b> This method search and return a List <p>
	 * <b> Scenery:         </b> Find a list of Countries, Menu options etc   <p>
	 * <b> Use tip:         </b> getListByClass("className")  <p>
	 * <b> Expected result: </b> Founding element 
	 * @author Eduardo Carneiro		
	 * @param className - Class Name
	 * @return String[]
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public String[] getListByClass(String className) {
		List<MobileElement> elements = driver.findElements(By.className(className));
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
		}
		return retorno;
	}

	/**
	 * <b> Definition:      </b> This method tap on the screen <p>
	 * <b> Scenery:         </b> Touch on the screen   <p>
	 * <b> Use tip:         </b> tap()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void tap() {
		Dimension size = driver.manage().window().getSize();
		int x = (int) (size.height * 0.1);
		int y = (int) (size.width * 0.1);
		new TouchAction<>(driver).tap(PointOption.point(new Point(x, y))).perform();
	}
	
	/**
	 * <b> Definition:      </b> This method move the screen to left <p>
	 * <b> Scenery:         </b> Move screen   <p>
	 * <b> Use tip:         </b> swipeScreenLeft()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void swipeScreenLeft() {
		Dimension size = driver.manage().window().getSize();
		int start_x = (int) (size.width * 0.1);
		int end_x = (int) (size.width * 0.9);
		int y = (int) (size.height + size.height) / 3;
		new TouchAction<>(driver).press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y))).release().perform();
	}

	/**
	 * <b> Definition:      </b> This method move the screen to Right <p>
	 * <b> Scenery:         </b> Move screen   <p>
	 * <b> Use tip:         </b> swipeScreenRight()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void swipeScreenRight() {
		Dimension size = driver.manage().window().getSize();
		int start_x = (int) (size.width * 0.9);
		int end_x = (int) (size.width * 0.1);
		int y = (int) (size.height + size.height) / 3;
		new TouchAction<>(driver).press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y))).release().perform();
	}

	/**
	 * <b> Definition:      </b> This method search element by text and write inside it <p>
	 * <b> Scenery:         </b> Locate a element by text and write inside   <p>
	 * <b> Use tip:         </b> findElementByTextAnsWriteInside("Fill your login", "My login")  <p>
	 * <b> Expected result: </b> Filled text inside component 
	 * @author Eduardo Carneiro		
	 * @param elementText - Text inside component
	 * @param text - Text to fill
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void findElementByTextAnsWriteInside(String elementText, String text) {
		findElementByText(elementText).sendKeys(text);
	}

	/**
	 * <b> Definition:      </b> This method click in element on the screen <p>
	 * <b> Scenery:         </b> Locate a Save button on the screen   <p>
	 * <b> Use tip:         </b> clickByText("Save")  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param text - Text in the component
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void clickByText(String text) {
		clickById(By.xpath("//*[@text='" + text + "']"));

	}

	/**
	 * <b> Definition:      </b> This method click Android Element <p>
	 * <b> Scenery:         </b> Locate a Android element   <p>
	 * <b> Use tip:         </b> clickByTextAndroidComponent("10:00")  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param hour - Hour in the element
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void clickByTextAndroidComponent(String hour) {
		clickById(MobileBy.AccessibilityId(hour));
	}

	/**
	 * <b> Definition:      </b> This method write text in Andoid Element <p>
	 * <b> Scenery:         </b> Locate a Android element and write inside it   <p>
	 * <b> Use tip:         </b> writeText(findElementByClass("AndroidClass"), String text)  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param element - Android Element
	 * @param text - Text
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void writeText(MobileElement element, String text) {
		element.sendKeys(text);
	}

	/**
	 * <b> Definition:      </b> This method move text from origin position to destiny position <p>
	 * <b> Scenery:         </b> Move text from to   <p>
	 * <b> Use tip:         </b> grag("textOrigin","textDestiny" )  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param from - Initial Position
	 * @param to - Final Position
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void grag(String from, String to) {
		MobileElement startPosition = findElementByTextUP(from);
		MobileElement endPosition = findElementByTextUP(to);
		new TouchAction<>(driver).longPress(longPressOptions().withElement(element(startPosition)))
				.moveTo(PointOption.point(endPosition.getCenter())).release().perform();
	}

	/**
	 * <b> Definition:      </b> This method move scroll <p>
	 * <b> Scenery:         </b> Move scroll to show all options from screen   <p>
	 * <b> Use tip:         </b> scroll( inicialPosition , finalPosition )  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param start - Initial Position on the screen
	 * @param end - Final Position on the screen
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void scroll(double start, double end) {
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int start_y = (int) (size.height * start);
		int end_y = (int) (size.height * end);
		new TouchAction<>(driver).press(PointOption.point(new Point(x, start_y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(x, end_y))).release().perform();

	}

	/**
	 * <b> Definition:      </b> This method move screen <p>
	 * <b> Scenery:         </b> Move screen to specific position   <p>
	 * <b> Use tip:         </b> swipe( start,  end)  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param start - Initial Position on the screen
	 * @param end - Final Position on the screen
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void swipe(double start, double end) {
		Dimension size = driver.manage().window().getSize();
		int y = size.height / 2;
		int start_x = (int) (size.width * start);
		int end_x = (int) (size.width * end);
		new TouchAction<>(driver).press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y))).release().perform();

	}

	/**
	 * <b> Definition:      </b> This method move specific element on the screen <p>
	 * <b> Scenery:         </b> Move element on the screen to specific position   <p>
	 * <b> Use tip:         </b> swipeElement(findElementByClass("ElementClass"))  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param element - Mobile Element
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void swipeElement(MobileElement element) {
		double inicio = 0.0;
		double fim = 0.0;
		int y = element.getLocation().y + element.getSize().height / 2;
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		new TouchAction<>(driver).press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y))).release().perform();

	}

	/**
	 * <b> Definition:      </b> This method move specific element on the screen <p>
	 * <b> Scenery:         </b> Move element on the screen to specific position   <p>
	 * <b> Use tip:         </b> swipeElement(findElementByClass("ElementClass"))  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param element - Movile Element
	 * @param start - Initial Position
	 * @param end - Final Position
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void swipeElement(MobileElement element, double start, double end) {
		int y = element.getLocation().y + element.getSize().height / 2;
		int start_x = (int) (element.getSize().width * start);
		int end_x = (int) (element.getSize().width * end);
		new TouchAction<>(driver).press(PointOption.point(new Point(start_x, y)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(end_x, y))).release().perform();

	}

	/**
	 * <b> Definition:      </b> This method locate by text and write inside it <p>
	 * <b> Scenery:         </b> Locate element with specific text and write inside it   <p>
	 * <b> Use tip:         </b> findElementByTextAndWriteInside("Fill your email", "my_email")  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @param elementText - Text in the component
	 * @param text - Text to fill
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void findElementByTextAndWriteInside(String elementText, String text) {
		writeText(findElementByText(elementText), text);
	}

//	public void screenShot(SkipAPP path, TestName testName, String detailsFileName) {
//		try {
//			File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(image, new File(path + testName.getMethodName() + detailsFileName + ".jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * <b> Definition:      </b> This method move down the screen <p>
	 * <b> Scenery:         </b> Move down screen   <p>
	 * <b> Use tip:         </b> scrollDown()  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	/**
	 * <b> Definition:      </b> This method move up the screen by scroll <p>
	 * <b> Scenery:         </b> Move up screen   <p>
	 * <b> Use tip:         </b> scrollUp()  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}

	/**
	 * <b> Definition:      </b> This method wait until component with specific text be showed <p>
	 * <b> Scenery:         </b> Wait for text to be showed on the screen   <p>
	 * <b> Use tip:         </b> waitUntilShowFieldOnTheScreen("Order saved")  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro	
	 * @param fieldName - Expected text on the component	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void waitUntilShowFieldOnTheScreen(String fieldName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + fieldName + "']")));
	}

	/**
	 * <b> Definition:      </b> This method wait until component with specific text desapear <p>
	 * <b> Scenery:         </b> Wait for text desapear from screen   <p>
	 * <b> Use tip:         </b> waitUntilDesapearFieldOnTheScreen("Connecting in progress")  <p>
	 * <b> Expected result: </b> Event start 
	 * @author Eduardo Carneiro	
	 * @param fieldName - Expected text on the screen desapear	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void waitUntilDesapearFieldOnTheScreen(String fieldName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + fieldName + "']")));
	}

	/**
	 * <b> Definition:      </b> This method wait until component with specific text desapear, during specific time  <p>
	 * <b> Scenery:         </b> Wait for text desapear from screen   <p>
	 * <b> Use tip:         </b> waitUntilDesapearFieldOnTheScreen("Connecting in progress", 10)  <p>
	 * <b> Expected result: </b> Text desapear until 10 seconds 
	 * @author Eduardo Carneiro	
	 * @param fieldName - Expected text on the screen desapear	
	 * @param time - Time limit
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void waitUntilDesapearFieldOnTheScreen(String fieldName, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='" + fieldName + "']")));
	}

	/**
	 * <b> Definition:      </b> This method wait until component with specific text be showed on the screen, during specific time  <p>
	 * <b> Scenery:         </b> Wait for text be showed from screen   <p>
	 * <b> Use tip:         </b> waitUntilShowFieldOnTheScreen("Connected", 10)  <p>
	 * <b> Expected result: </b> Text will be show until 10 seconds 
	 * @author Eduardo Carneiro	
	 * @param fieldName - Expected text on the screen	
	 * @param time - Time limit
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void waitUntilShowFieldOnTheScreen(String fieldName, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='" + fieldName + "']")));
	}
	
	
	
	public void taph() {
		Dimension size = driver.manage().window().getSize();
		int x = (int) (size.height * 0.1);
		int y = (int) (size.width * 0.1);
		new TouchAction<>(driver).tap(PointOption.point(new Point(x, y))).perform();
	}	
	
	/**
	 * <b> Definition:      </b> This method return the height screen<p>
	 * <b> Scenery:         </b> Know the height screen  <p>
	 * <b> Use tip:         </b> heightScreen()  <p>
	 * <b> Expected result: </b> Height screen 
	 * @author Eduardo Carneiro	
	 * @return int	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public int heightScreen() {
		return  (int) (driver.manage().window().getSize().height);
	}
	
	/**
	 * <b> Definition:      </b> This method return the width screen<p>
	 * <b> Scenery:         </b> Know the width screen  <p>
	 * <b> Use tip:         </b> widthScreen()  <p>
	 * <b> Expected result: </b> Width screen 
	 * @author Eduardo Carneiro	
	 * @return int	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public int widthScreen() {
		return  (int) (driver.manage().window().getSize().width);
	}	
	
	/**
	 * <b> Definition:      </b> This method tap on the screen in specific position <p>
	 * <b> Scenery:         </b> Touch on the screen   <p>
	 * <b> Use tip:         </b> tap(heightScreen() * 0.5, widthScreen() * 0.5)  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro	
	 * @param x - axis position
	 * @param y - axis position	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */
	public void tap(int x, int y) {
		new TouchAction<>(driver).tap(PointOption.point(new Point(x, y))).perform();
	}

	/**
	 * <b> Definition:      </b> This method move the screen from to <p>
	 * <b> Scenery:         </b> Move screen   <p>
	 * <b> Use tip:         </b> swipeRight()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void swipeRight() {
		swipe(0.1, 0.9);
	}

	/**
	 * <b> Definition:      </b> This method move the screen from to <p>
	 * <b> Scenery:         </b> Move screen   <p>
	 * <b> Use tip:         </b> swipeLeft()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro		
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public void swipeLeft() {
		swipe(0.9, 0.1);
	}

	/**
	 * <b> Definition:      </b> This method capture message <p>
	 * <b> Scenery:         </b> Get Message Alert component   <p>
	 * <b> Use tip:         </b> getTitleFromAlert()  <p>
	 * <b> Expected result: </b> Get message 
	 * @author Eduardo Carneiro	
	 * @return string	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public String getTitleFromAlert() {
		return getText(By.id("android:id/alertTitle"));
	}

	/**
	 * <b> Definition:      </b> This method capture message <p>
	 * <b> Scenery:         </b> Get Message box message   <p>
	 * <b> Use tip:         </b> getMessageFromMessageBox()  <p>
	 * <b> Expected result: </b> Get message 
	 * @author Eduardo Carneiro	
	 * @return string	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public String getMessageFromMessageBox() {
		return getText(By.id("android:id/message"));
	}

	
	/**
	 * <b> Definition:      </b> This method return MobileElement <p>
	 * <b> Scenery:         </b> Return MobileElement to find different attributes   <p>
	 * <b> Use tip:         </b> getElementByText("Fill your password")  <p>
	 * <b> Expected result: </b> Get message 
	 * @author Eduardo Carneiro	
	 * @param elementText = Text on the component
	 * @return MobileElement	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */		
	public MobileElement getElementByText(String elementText) {
		return findElementByText(elementText);
	}

	/**
	 * <b> Definition:      </b> This method capture message <p>
	 * <b> Scenery:         </b> Get Alert message   <p>
	 * <b> Use tip:         </b> getMessageFrtomAlert()  <p>
	 * <b> Expected result: </b> Event 
	 * @author Eduardo Carneiro	
	 * @return string	
	 * @version 1.00						
	 * @since 2020/03/01 											
	 */	
	public String getMessageFrtomAlert() {
		return getText(By.id("android:id/message"));
	}

}
