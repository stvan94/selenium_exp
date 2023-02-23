package com.qa.libs;

import com.qa.pages.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Action {

    public static WebDriver driver;

    public void Sleep(int secons) throws InterruptedException, IOException {
        Thread.sleep(secons * 1000);
        writelog("log", "[Done] Sleep " + secons + " s");
    }
    String log_name_time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    Boolean IsNotcreateLog = true;
    public void writelog(String log_name, String log_string) throws IOException {

        String lognametxt = log_name + "_" + log_name_time + ".txt";


        // create log -- start
        if (IsNotcreateLog) {

            try {

                FileWriter fw = new FileWriter(lognametxt);
                BufferedWriter bw = new BufferedWriter(fw);
                String content = "----------";
                bw.write(content);
                bw.close();
                PrintString("Logfile has created");
            } catch (IOException e) {
                e.printStackTrace();
                PrintString("[Error] When create log file, please check: " + e);

            }
            IsNotcreateLog = false;
        }
        // create log -- end


        String Log_line = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Path path = Paths.get(lognametxt);

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        int position = lines.size();
        String log = "[" + Log_line + "]: " + log_string;

        lines.add(position, log);
        Files.write(path, lines, StandardCharsets.UTF_8);
        //--
        System.out.println(log);

    }
    public void PrintString(String content) {
        System.out.println(content);
    }
    public void Clickto_xpath(String xpath) throws IOException, InterruptedException {

        // WaitForPresence_id(driver, locator);
        Sleep(1);
        driver.findElement(By.xpath(xpath)).click();
        writelog("log", "[Done] Click to " + xpath);
    }
    public void InputString_xpath(WebElement driver, String xpath, String content) throws InterruptedException, IOException {
        Sleep(1);
        driver.findElement(By.id(xpath)).click();
        //driver.findElement(By.id(xpath)).clear();
        driver.findElement(By.id(xpath)).sendKeys(content);
        Sleep(3);
        writelog("log", "[Done] Input text: " + content);
    }
    public void CheckFocus_txt(String xpath) throws IOException, InterruptedException {

        // WaitForPresence_id(driver, locator);
        Sleep(1);
        if(xpath.equals(driver.switchTo().activeElement()))
            System.out.println("cursor is focus on "+xpath);
        else
            System.out.println("cursor is not focus on "+xpath);
        //writelog("log", "[Done] Click to " + xpath);
    }
}
