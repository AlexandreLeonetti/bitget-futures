package com.mycompany.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitget.openapi.common.client.BitgetRestClient;
import com.bitget.openapi.dto.response.ResponseResult;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private BitgetRestClient bitgetRestClient;

    public void placeLimitOrder(String symbol, String side, String orderType, String force, String price, String size) throws Exception {
        //placeOrder(symbol, side, "limit", "GTC", price, size);
        
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("symbol", symbol);
        paramMap.put("side", side);
        paramMap.put("orderType", "limit");
        paramMap.put("force", "GTC");
        paramMap.put("price", price);
        paramMap.put("size", size);

        ResponseResult result = bitgetRestClient.bitget().v2().spotOrder().placeOrder(paramMap);
        System.out.println("From placeLimitOrder");
        System.out.println(JSON.toJSONString(result)); 
    }
    
    public void placeStopBuyOrder(String symbol, String side, String orderType, String force, String price, String size)throws Exception {
    	Map<String, String> paramMap = new HashMap<>();
    	paramMap.put("symbol", symbol);
    	paramMap.put("side", side);
    	paramMap.put("orderType", "limit");
    	paramMap.put("force", "GTC");
        paramMap.put("price", price);
        paramMap.put("size", size);	
        paramMap.put("triggerPrice", "75001");
        paramMap.put("tpslType", "tpsl");

        ResponseResult result = bitgetRestClient.bitget().v2().spotOrder().placeOrder(paramMap);
        System.out.println("From placeStopBuyOrder");
        System.out.println(JSON.toJSONString(result));  
    	
    }
    
    public void limitBuyDemoFutures() throws Exception { 
    	try {
    		String symbol 		= "SBTCSUSDT";
    		String productType 	= "SUSDT-FUTURES";
    		String side			= "buy";
    		String orderType	= "limit";
    		String marginMode	= "isolated";
    		String marginCoin	= "SUSDT";
    		String size			= "0.001";
    		String price		= "44444";
    	
    		 String force = "GTC"; 
    	
    		Map<String, String> paramMap = new HashMap<>();
    		paramMap.put("symbol", symbol);
    		paramMap.put("productType", productType);
    		paramMap.put("side",side);
    		paramMap.put("orderType", orderType);
    		paramMap.put("marginMode", marginMode);
    		paramMap.put("marginCoin", marginCoin);
    		paramMap.put("size", size);
    		paramMap.put("price", price);
    		paramMap.put("force", force);
    		
            ResponseResult result = bitgetRestClient.bitget().v2().mixOrder().placeOrder(paramMap);
            System.out.println("From place DEMO FUTURES ORDER");
            System.out.println(JSON.toJSONString(result));	
    	}catch(Exception e) {
            System.err.println("Error placing order: " + e.getMessage());
            throw e;
    	}
    		
    }
    
    public void stopBuyDemoFutures() throws Exception { 
    	try {
    		String planType		= "normal_plan";
    		String symbol 		= "SBTCSUSDT";
    		String productType 	= "SUSDT-FUTURES";
    		String side			= "buy";
    		String orderType	= "limit";
    		String marginMode	= "isolated";
    		String marginCoin	= "SUSDT";
    		String size			= "0.001";
    		String price		= "78000";
    		String force = "GTC"; 
    		String triggerPrice = "77000";
    		String triggerType	= "fill_price";
    		//String tradeSide	= "open";
    	
    		Map<String, String> paramMap = new HashMap<>();
    		paramMap.put("planType", planType);
    		paramMap.put("symbol", symbol);
    		paramMap.put("productType", productType);
    		paramMap.put("side",side);
    		paramMap.put("orderType", orderType);
    		paramMap.put("marginMode", marginMode);
    		paramMap.put("marginCoin", marginCoin);
    		paramMap.put("size", size);
    		paramMap.put("price", price);
    		paramMap.put("force", force);
    		paramMap.put("triggerPrice", triggerPrice);
    		paramMap.put("triggerType", triggerType);
    		//paramMap.put("tradeSide", tradeSide);
    		
            ResponseResult result = bitgetRestClient.bitget().v2().mixOrder().placePlanOrder(paramMap);
            System.out.println("From place DEMO FUTURES ORDER");
            System.out.println(JSON.toJSONString(result));	
    	}catch(Exception e) {
            System.err.println("Error placing order: " + e.getMessage());
            throw e;
    	}
    		
    }
        
   /* 
    public void placeOrder(String symbol, String side, String orderType, String force, String price, String size) throws Exception {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("symbol", symbol);
        paramMap.put("side", side);
        paramMap.put("orderType", orderType);
        paramMap.put("force", force);
        paramMap.put("price", price);
        paramMap.put("size", size);

        ResponseResult result = bitgetRestClient.bitget().v2().spotOrder().placeOrder(paramMap);
        System.out.println(JSON.toJSONString(result));
    }
    */
}
