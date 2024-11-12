package org.HRMFwk.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TableHelper {
    private WebDriver driver;

    public TableHelper(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTableRows(By tableLocator) {
        return driver.findElements(tableLocator);
    }

    public String getCellValue(WebElement row, int cellIndex) {
        return row.findElements(By.tagName("td")).get(cellIndex).getText();
    }

    public List<String> getColumnValues(By tableLocator, int columnIndex) {
        return getTableRows(tableLocator).stream()
                .map(row -> getCellValue(row, columnIndex))
                .collect(Collectors.toList());
    }
}