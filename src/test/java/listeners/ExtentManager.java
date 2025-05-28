package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    public static ExtentReports createInstance(String fileName){

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setReportName(fileName);
        extent= new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Organization ", "QualityStream");

        return  extent;
    }

    private static String detectEnvironment(){
        if(System.getenv("JENKINS_HOME")!=null){
            return "JenkinsCI";
        }else{
            return "local";
        }
    }
    public static String getDefaultReportPath(){

        String baseDir = System.getProperty("user.dir");
        String reportDir = baseDir + "/reports";

        File directory= new File(reportDir);

        if(!directory.exists()){
            directory.mkdir();
        }
        return reportDir;
    }

    public static String screenShotName;

    public static void captureScreenShot(){
        //linea fija cuando se quiere hacer capturas de patanlla
        File srcFile = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.FILE);
        Date date = new Date();

        screenShotName = date.toString().replace(":","_")
                .replace(" ","_")+".jpg";

        try {
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\reports\\"+screenShotName));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void clearScreenShotFolder(){
        File folder = new File(System.getProperty("user.dir")+"\\reports\\");
        if(folder.exists() && folder.isDirectory()){
            for(File file : folder.listFiles()){
                if(file.isFile() && file.getName().endsWith(".jpg")){
                    file.delete();
                }
            }
        }
    }
}
