//package com.coldeye.coldgateway.common;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//public class TokenFilter implements Ordered, GlobalFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        if (!exchange.getRequest().getPath().value().equals("cold/sys/user/login")) {
//            String token = exchange.getRequest().getHeaders().getFirst("token");
//            if (token == null || token.isEmpty()) {
//                System.out.println("token is empty");
//                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                return exchange.getResponse().setComplete();
//            }
//        }
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder() {
//        return -100;
//    }
//}
