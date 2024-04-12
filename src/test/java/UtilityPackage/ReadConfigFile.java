package UtilityPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

    FileInputStream fileInputStream ;
    Properties properties ;

    public ReadConfigFile(){
        try{
            fileInputStream = new FileInputStream("C:\\Users\\rajat\\IdeaProjects\\UI_TestAutomationProject_Selenium\\src\\test\\resources\\config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public String getValueFromConfigFile(String value){

        return properties.getProperty(value);
    }


}
