package com.mycompany.app;
import io.github.cdimascio.dotenv.Dotenv;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bitget.openapi.common.client.BitgetRestClient;
import com.bitget.openapi.common.domain.ClientParameter;
import com.bitget.openapi.common.enums.SupportedLocaleEnum;

@Configuration
@EnableAsync
public class SdkConfig {

    @Bean
    public BitgetRestClient bitgetRestClient() throws Exception {
        String apiKey = "";// dotenv.get("APIKEY");
        String secretKey = "";//dotenv.get("SECRETKEY");
        String passphrase = "";//dotenv.get("PASSPHRASE");

        System.out.println("BitGet Rest Client");
        ClientParameter parameter = ClientParameter.builder()
            .apiKey(apiKey)
            .secretKey(secretKey) 
            .passphrase(passphrase)
            .baseUrl("https://api.bitget.com")
            .locale(SupportedLocaleEnum.EN_US.getName()).build();
        return BitgetRestClient.builder().configuration(parameter).build();
    }

    public void printApiKey() {
        String apiKey = "";//dotenv.get("APIKEY");
        System.out.println("API Key: " + apiKey);
    }
}

