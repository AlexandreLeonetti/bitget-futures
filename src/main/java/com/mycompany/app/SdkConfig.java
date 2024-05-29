package com.mycompany.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.bitget.openapi.common.client.BitgetRestClient;
import com.bitget.openapi.common.domain.ClientParameter;
import com.bitget.openapi.common.enums.SupportedLocaleEnum;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Configuration
@EnableAsync
public class SdkConfig {
  private final String apiKey = "";
  private final String secretKey = "";
  private final String passphrase = "";
  private final String baseUrl = "https://api.bitget.com";
  private final Dotenv dotenv;

  @Autowired
  public MyService(Dotenv dotenv) {
      this.dotenv = dotenv;
  }
  public void printApiKey() {
      String apiKey = dotenv.get("API_KEY");
      System.out.println("API Key: " + apiKey);
  }
  @Bean
  public BitgetRestClient bitgetRestClient() throws Exception {
    System.out.println("BitGet Rest Client");
    ClientParameter parameter = ClientParameter.builder()
        .apiKey(apiKey)
        .secretKey(secretKey) // 如果是RSA类型则设置为RSA私钥
        .passphrase(passphrase)
        .baseUrl(baseUrl)
        // .signType(SignTypeEnum.RSA) // 如果你的apikey是RSA类型则主动设置签名类型为RSA
        .locale(SupportedLocaleEnum.EN_US.getName()).build();
    return BitgetRestClient.builder().configuration(parameter).build();
  }
}
