package Clase1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utility;

public class XpathStrategies_Test extends BaseTest2 {

    // Absolute XPath (Tag name)
    // No debemos usarlo
    @Test
    void testAbsoluteXPath() throws Exception {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/main/article/section/div[2]/div/div/div/div[1]/div/div/form/div[1]/input"));
        Utility.printElementInfo("Input Name", element);
    }

    // We stick to relative XPaths because absolute Xpaths are brittle
    //XPath (Tag name)
    @Test
    void testRelativeXPath() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath (Tag name and attr name)
    @Test
    void testTagAttr() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type]"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath (Tag name and attr value)
    @Test
    void testTagAttrValue() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='email']"));
        Utility.printElementInfo("Input Email", element);
    }

    //XPath (Tag name and attr value) - Id
    @Test
    void testAttrID() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@id='name']"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath (Tag name and attr value) - class
    @Test
    void testAttrClass() throws Exception {
        WebElement element = driver.findElement(By.xpath("//img[@class='thumbnail']"));
        Utility.printElementInfo("Image thumbnail", element);
    }

    // XPath (Tag name and attr value) - Name
    @Test
    void testAttrName() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@name='email']"));
        Utility.printElementInfo("Input email", element);
    }

    //Any Tag with attr value
    @Test
    void testAntTag() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@name='age']"));
        Utility.printElementInfo("Input Age", element);
    }

    //##--PARTE IMPORTANTE--##
    //text() function
    @Test
    void testFunctionText() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[text()='Java para Testers']"));
        Utility.printElementInfo("Label 'Java para Testers'", element);
    }

    // XPath - Relationships - Child
    @Test
    void testParentChild() throws Exception {
        WebElement element = driver.findElement(By.xpath("//div/table"));
        Utility.printElementInfo("Tabla", element);
    }

    // Relationships - Following Sibling
    @Test
    void testSiblings() throws Exception {
        WebElement element = driver.findElement(By.xpath("//form/following-sibling::table"));
        Utility.printElementInfo("Tabla", element);
    }

    //XPath - Partial Match - Attr value Contains
    @Test
    void testFunctionContains() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[contains(@id, 'ast')]"));
        Utility.printElementInfo("Input LastName", element);
    }

    //XPath - Partial Match - Attr value Starts With
    @Test
    void testFunctionStartsWith() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[starts-with(@id, 'nam')]"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath - Partial Match - Text contains
    @Test
    void testFunctionsContainsText() throws Exception {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'ppointment')]"));
        Utility.printElementInfo("Go to Appointment Link", element);
    }

    // XPath - Partial Match - Text starts with
    @Test
    void testFunctionsStartsWithText() throws Exception {
        WebElement element = driver.findElement(By.xpath("//a[starts-with(text(), 'Go to')]"));
        Utility.printElementInfo("Go to Appointment Link", element);
    }

    //XPath - Logical OR : Using or keyword
    @Test
    void testFunctionOR() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='text' or @id ='lastName']"));
        Utility.printElementInfo("Input Name", element);
    }

    //  XPath - Logical AND : Using and keyword
    @Test
    void testFunctionAND() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='text' and @name='lastName']"));
        Utility.printElementInfo("Input Last Name", element);
    }

    //  XPath - Logical Not : Using not() function
    @Test
    void testNotFunction() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type='text' and not(@id ='name')]"));
        Utility.printElementInfo("Input Last Name", element);
    }

    // XPath - Hierarchy (Axis) - Parent
    //CON EL PUNTO PUNTO ARRANCA DESDE EL HIJO SUBIENDO HASTA EL PADRE //label/../.. sucesivamente va subiendo
    @Test
    void testParent() throws Exception {
        WebElement element = driver.findElement(By.xpath("//label/.."));
        Utility.printElementInfo("Formulario -form-", element);
    }

    // XPath - Hierarchy (Axis) - Descendant (Using // instead of / between form and input)
    @Test
    void testDescendant() throws Exception {
        WebElement element = driver.findElement(By.xpath("//form//input"));
        Utility.printElementInfo("Input Name", element);
    }

    //XPath - Hierarchy (Axis) - Ancestor (Using /ancestor)
    @Test
    void testAncestor() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input/ancestor::form"));
        Utility.printElementInfo("Form", element);
    }

    // XPath - Hierarchy (Axis) - Preceding Sibling (starting from submit paragraph)
    @Test
    void testSibling() throws Exception {
        WebElement element = driver.findElement(By.xpath("//table/preceding-sibling::form"));
        Utility.printElementInfo("Form", element);
    }

    // XPath - Index (Index uses Human counting)
    // This variant looks at children of the same parent.
    // That is the reason //input[2] does not point to "LastName" field
    @Test
    void testXPathIndex1() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[1]"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath - Index (Index uses Human counting)
    // This variant looks at all elements across the DOM.
    // Here (//input)[2] would point to "Last Name" field
    @Test
    void testXPathIndex2() throws Exception {
        WebElement element = driver.findElement(By.xpath("(//input)[1]"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath - Multi attr names
    @Test
    void testMultAttr() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@type and @id]"));
        Utility.printElementInfo("Input Name", element);
    }

    // XPath - Multi attr names and values
    @Test
    void testMultAttrValue() throws Exception {
        WebElement element = driver.findElement(By.xpath("//input[@name='email' and @type='email']"));
        Utility.printElementInfo("Input Email", element);
    }
}
