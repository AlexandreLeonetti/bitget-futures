package com.mycompany.app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bitget.openapi.common.client.BitgetRestClient;
import com.bitget.openapi.common.domain.ClientParameter;
import com.bitget.openapi.common.enums.SupportedLocaleEnum;

@Configuration
@EnableAsync
public class SdkConfig {

    private final Dotenv dotenv;

    @Autowired
    public SdkConfig(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                .directory(System.getProperty("user.dir"))
                .load();
    }

    @Bean
    public BitgetRestClient bitgetRestClient() throws Exception {
        String apiKey = dotenv.get("API_KEY");
        String secretKey = dotenv.get("SECRET_KEY");
        String passphrase = dotenv.get("PASSPHRASE");

        System.out.println("BitGet Rest Client");
        ClientParameter parameter = ClientParameter.builder()
            .apiKey(apiKey)
            .secretKey(secretKey) // 如果是RSA类型则设置为RSA私钥
            .passphrase(passphrase)
            .baseUrl("https://api.bitget.com")
            // .signType(SignTypeEnum.RSA) // 如果你的apikey是RSA类型则主动设置签名类型为RSA
            .locale(SupportedLocaleEnum.EN_US.getName()).build();
        return BitgetRestClient.builder().configuration(parameter).build();
    }

    public void printApiKey() {
        String apiKey = dotenv.get("API_KEY");
        System.out.println("API Key: " + apiKey);
    }
}

