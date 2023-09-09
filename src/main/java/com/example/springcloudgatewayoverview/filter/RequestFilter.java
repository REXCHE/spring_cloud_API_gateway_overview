package com.example.springcloudgatewayoverview.filter;

import com.example.springcloudgatewayoverview.model.Company;
import com.example.springcloudgatewayoverview.model.Student;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class RequestFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Object body = exchange.getAttribute("cachedRequestBodyObject");
        System.out.println("in request filter");
        if(body instanceof Student) {
            System.out.println("body:" + (Student) body);
        }
        else if(body instanceof Company) {
            System.out.println("body:" + (Company) body);
        }
        return chain.filter(exchange);
    }
    //ModifyRequestBodyGatewayFilterFactory {

   /* @Override
    public GatewayFilter apply(Config config) {
        config.setRewriteFunction(String.class, String.class,
                (exchange, originContent) -> {
                    System.out.println("originContent:"+originContent);
*/
    /*                    try {
                        ByteBuffer byteBuffer = Mono.from(exchange.getRequest().getBody()).toFuture().get().asByteBuffer();
                        byte[] bytes = new byte[byteBuffer.capacity()];
                        while (byteBuffer.hasRemaining()) {
                            byteBuffer.get(bytes);
                        }
                        System.out.println(new String(bytes, Charset.forName("UTF-8")));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }*//*
                    return Mono.just(originContent);
                });

        return super.apply(config);
    }*/
}
