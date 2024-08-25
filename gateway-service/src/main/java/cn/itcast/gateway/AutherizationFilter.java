package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Order(-1)
@Component
public class AutherizationFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        //获取参数中的authorization参数
        String auth = params.getFirst("authorization");
        //判断参数值是否等于admin
        if ("admin".equals(auth)) {
            return chain.filter(exchange);//放行
        }
        //否，拦截设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        //
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;//数字越小优先级越高
    }
}
