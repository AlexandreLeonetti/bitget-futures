package com.mycompany.app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final Dotenv dotenv;

    @Autowired
    public MyService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public void printApiKey() {
        String apiKey = dotenv.get("API_KEY");
        System.out.println("API Key: " + apiKey);
    }
}
