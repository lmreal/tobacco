package com.lm.tobacco.web.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author liming39
 *
 * EnableWebSocketMessageBroker注解开启STOMP协议来传输基于代理的消息，此时控制器支持使用@MessageMapping
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //topic用来广播，user用来实现p2p
        config.enableSimpleBroker("/topic", "/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册两个STOMP的endpoint，分别用于广播和点对点
        registry.addEndpoint("/webServer").withSockJS();
        registry.addEndpoint("/queueServer").withSockJS();
    }

}
