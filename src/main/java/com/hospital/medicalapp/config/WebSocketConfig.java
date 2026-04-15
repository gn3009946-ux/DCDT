package com.hospital.medicalapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Đây là "cửa chính" để Frontend (Web/Mobile) kết nối vào hệ thống
        registry.addEndpoint("/ws-medical")
                .setAllowedOriginPatterns("*") // Cho phép mọi domain gọi tới (Fix lỗi CORS)
                .withSockJS(); // Fallback nếu browser client không hỗ trợ chuẩn WebSocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Tiền tố cho các kênh Broadcast (Server đẩy tin nhắn về Client)
        registry.enableSimpleBroker("/group");

        // Tiền tố cho các request gửi lên Server
        registry.setApplicationDestinationPrefixes("/app");
    }
}
