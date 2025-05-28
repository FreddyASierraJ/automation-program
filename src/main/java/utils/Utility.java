package utils;

import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utility {

    public static void printElementInfo(String name, WebElement element) {

        String marker = "------------------------------";

        System.out.println(marker);

        System.out.println("Element meta-data: " + name);

        System.out.println(marker);

        System.out.println("WebElement object:: " + element);

        System.out.println("Outer HTML:: " + element.getAttribute("outerHTML"));

        System.out.println("Inner HTML:: " + element.getAttribute("innerHTML"));

        System.out.println("Text:: " + element.getText());

        System.out.println("Value::" + element.getAttribute("value"));

        System.out.println("Tag:: " + element.getTagName());

        System.out.println("Displayed?:: " + element.isDisplayed());

        System.out.println("Selected?:: " + element.isSelected());

        System.out.println("Enabled?:: " + element.isEnabled());

        System.out.println(marker);

    }
    public static boolean compareDates(String date1, String format1, String date2, String format2) {

        try {
            // "dd/MM/yyyy"
            DateTimeFormatter date1Formatter = DateTimeFormatter.ofPattern(format1);
            LocalDate date1LocalDate = LocalDate.parse(date1, date1Formatter);

            // "yyyy-MM-dd"
            DateTimeFormatter date2Formatter = DateTimeFormatter.ofPattern(format2);
            LocalDate date2LocalDate = LocalDate.parse(date2, date2Formatter);

            // Comparing dates
            return date1LocalDate.equals(date2LocalDate);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing dates: " + e.getMessage());
            return false;
        }

    }

    public static boolean waitForNewFile(File folder, int timeoutInSeconds, int originalFileCount) {
        System.out.println("originalFileCount:"+originalFileCount);
        int elapsed = 0;
        while (elapsed < timeoutInSeconds) {
            File[] files = folder.listFiles();
            if (files != null && files.length > originalFileCount) {
                System.out.println("new file count:"+files.length);
                return true; // New file appeared
            }
            try {
                Thread.sleep(1000); // poll every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsed++;
        }
        return false; // timeout reached
    }
    public static void clearDownloadFolder(String downloadPath) {
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    boolean deleted = file.delete();
                    if (!deleted) {
                        System.out.println("File couldn't be deleted: " + file.getName());
                    }
                }
            }
        }
    }
}
