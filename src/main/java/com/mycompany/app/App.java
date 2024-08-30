
package com.mycompany.app;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bitget.openapi.common.client.BitgetRestClient;
import com.bitget.openapi.common.domain.ClientParameter;
import com.bitget.openapi.common.enums.SupportedLocaleEnum;

@SpringBootApplication
public class App implements CommandLineRunner {

    //@Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //orderService.placeStopBuyOrder("BTCUSDT", "buy", "limit", "GTC", "77012.1", "0.001");
        // Initialize Dotenv and BitgetRestClient directly
        Dotenv dotenv = Dotenv.configure().directory(System.getProperty("user.dir")).load();
        BitgetRestClient bitgetRestClient = createBitgetRestClient(dotenv);
        
        // Initialize OrderService with the manually created BitgetRestClient
        orderService = new OrderService(bitgetRestClient);
        //orderService.stopBuyDemoFutures();
        //orderService.placeLimitOrder("SBTCSUSDT", "buy", "limit", "GTC", "37012.1", "0.001");
        orderService.limitBuyDemoFutures();
    }
    private BitgetRestClient createBitgetRestClient(Dotenv dotenv) throws Exception {
        String apiKey = dotenv.get("APIKEY");
        String secretKey = dotenv.get("SECRETKEY");
        String passphrase = dotenv.get("PASSPHRASE");

        ClientParameter parameter = ClientParameter.builder()
            .apiKey(apiKey)
            .secretKey(secretKey)
            .passphrase(passphrase)
            .baseUrl("https://api.bitget.com")
            .locale(SupportedLocaleEnum.EN_US.getName()).build();
        return BitgetRestClient.builder().configuration(parameter).build();
    }
}