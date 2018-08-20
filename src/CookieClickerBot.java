import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class CookieClickerBot {

    public static WebDriver driver;
    private boolean space = true;
    //private int MaxRatio = 0;
    //private HashMap<String, Integer> pricePerCookie = new HashMap<>();

    //WebElement cookieElement;
    WebElement bigCookie = driver.findElement(By.id("bigCookie"));
    WebElement advertisement = driver.findElement(By.className("cc_banner-wrapper"));
    WebElement goldenCookie = driver.findElement(By.id("goldenCookie"));
    WebElement notification = driver.findElement(By.id("notes" ));
    WebElement storeElement = driver.findElement(By.id("store"));
    WebElement upgradeElement = driver.findElement(By.id("upgrades"));
    List<WebElement> upgrades = new List<WebElement>(){
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<WebElement> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(WebElement webElement) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends WebElement> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends WebElement> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public WebElement get(int index) {
            return null;
        }

        @Override
        public WebElement set(int index, WebElement element) {
            return null;
        }

        @Override
        public void add(int index, WebElement element) {

        }

        @Override
        public WebElement remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<WebElement> listIterator() {
            return null;
        }

        @Override
        public ListIterator<WebElement> listIterator(int index) {
            return null;
        }

        @Override
        public List<WebElement> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    List<WebElement> productsList = new List<WebElement>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<WebElement> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(WebElement webElement) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends WebElement> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends WebElement> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public WebElement get(int index) {
            return null;
        }

        @Override
        public WebElement set(int index, WebElement element) {
            return null;
        }

        @Override
        public void add(int index, WebElement element) {

        }

        @Override
        public WebElement remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<WebElement> listIterator() {
            return null;
        }

        @Override
        public ListIterator<WebElement> listIterator(int index) {
            return null;
        }

        @Override
        public List<WebElement> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public void cookieClick() {
        while (space) {

            if (clickableGoldenCookie()){
                clickGoldenCookie();
            }
            if (clickableNotification()) {
                try{
                    clickNotification();
                }catch(NoSuchElementException e) {
                    e.printStackTrace();
                }
            }

            if (clickableUpgrade()) {
                clickUpgrade();
            }
            if (clickableProduct()) {
                clickProduct();
            }
            clickBigCookie();
        }
    }

    public void clickBigCookie() {
        bigCookie.click();
        System.out.println("click!");
    }

    public boolean clickableCookieWarning(){
        return advertisement.isDisplayed();
    }

    public void clickCookieWarning(){
        Actions acc = new Actions(driver);
        acc.moveToElement(advertisement).build().perform();
        advertisement.findElement(By.linkText("Got it!")).click();
        System.out.println("warning: this website uses cookies");
    }

    public void cyaCookieWarning(){
        if (clickableCookieWarning()){
            clickCookieWarning();
        }
    }

    public boolean clickableGoldenCookie(){
        return goldenCookie.isDisplayed();
    }

    public void clickGoldenCookie(){
        goldenCookie.click();
        System.out.println("golden cookie clicked!");
    }

    public boolean clickableNotification(){
        return notification.isDisplayed();
    }

    public void clickNotification(){
        Actions acc = new Actions(driver);
        acc.moveToElement(notification).build().perform();
        WebElement notificationElement = notification.findElement(By.className("close"));
        try{
            notificationElement.click();
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }System.out.println("notification closed!");
    }

    public boolean clickableUpgrade() {
        Actions acc = new Actions(driver);
        acc.moveToElement(upgradeElement).build().perform();
        upgrades = upgradeElement.findElements(By.className("enabled"));
        int listSize = upgrades.size();
        System.out.println(listSize);
        return listSize > 0;
    }

    public boolean clickableProduct() {
        Actions acc = new Actions(driver);
        acc.moveToElement(storeElement).build().perform();
        productsList = storeElement.findElements(By.className("enabled"));
        int size = productsList.size();
        System.out.print(size);
        return size > 0;
    }


    public void clickProduct(){
        Actions acc = new Actions(driver);
        acc.moveToElement(storeElement).build().perform();
        WebElement currentProduct = productsList.get(productsList.size() - 1);
        currentProduct.click();
        System.out.println(currentProduct.getAttribute("id") + "has been bought");
        //UNUSED FUNCTION THAT CLICKS THE MOST EFFICIENT PRODUCT
        /*for (WebElement product : productsList) {
            pricePerCookie.put(product.getAttribute("id"), computeEfficiency(product));
        }
        Map.Entry<String, Integer> entryWithMaxRatio = (Map.Entry<String, Integer>) new HashMap<String, Integer>();
        for (HashMap.Entry<String, Integer> entry : pricePerCookie.entrySet()) {
            if (entry.getValue() > MaxRatio) {
                MaxRatio = entry.getValue();
                entryWithMaxRatio = entry;
            }
        }
        driver.findElement(By.id(entryWithMaxRatio.getKey())).click();
        MaxRatio = 0;
        pricePerCookie.clear();
        productsList.clear();
*/
    }
/* // UNUSED FUNCTION -> cookieEfficiencyElement leads to nosuchelementException FUTURE TODO.
    public int computeEfficiency(WebElement product ) {
        Actions acc = new Actions(driver);
        acc.moveToElement(product).build().perform();
        String priceString = driver.findElement(By.xpath("//*[@id=\"" + product.getAttribute("id") + "\"]/*//*[@class=\"price\"]")).getText();
        long priceLong = Long.parseLong(priceString);

        acc.moveToElement(product).moveToElement(cookieElement = driver.findElement(By.xpath("//*[@id='tooltip']/div/div[7]/b[1]"))).build().perform();
        //WebElement cookieEfficiencyElement = driver.findElement(By.xpath("//*[@id='tooltip']/div/div[7]/b[1]"));
        String cookiesPerProduct = cookieElement.getText();
        long cookiesPerProductLong = Long.parseLong(cookiesPerProduct);
        return (int) (priceLong / cookiesPerProductLong);
    }
*/

    public void clickUpgrade() {
        Actions acc = new Actions(driver);
        acc.moveToElement(upgradeElement).build().perform();
        WebElement currentUpgrade = upgrades.get(upgrades.size() - 1);
        System.out.println(currentUpgrade.getAttribute("id")+ "purchased!");
        currentUpgrade.click();

    }
}


