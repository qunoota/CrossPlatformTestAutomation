package util;

import java.io.FileReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static Base.TestBase.confReader;

public class TestData {
    private JsonObject testData;

    public TestData() {
        try {
            FileReader reader = new FileReader(confReader.getTestDataPath());
            testData = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return testData.getAsJsonObject("login").get("username").getAsString();
    }

    public String getPassword() {
        return testData.getAsJsonObject("login").get("password").getAsString();
    }
}

