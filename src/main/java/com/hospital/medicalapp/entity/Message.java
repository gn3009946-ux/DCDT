package com.hospital.medicalapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data // Anotation của thư viện Lombok, tự động tạo Getter/Setter cho bạn
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "NVARCHAR(MAX)")
    private String content; // Nội dung tin nhắn (Dùng NVARCHAR để lưu tiếng Việt)

    @Column(name = "sender_id", nullable = false)
    private Long senderId; // ID của Bác sĩ hoặc Bệnh nhân

    @Column(name = "room_id", nullable = false)
    private String roomId; // Mã phòng chat (VD: "room_bacsi_benhnhan_01")

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Hàm này sẽ tự động lấy thời gian hệ thống ngay trước khi lưu vào DB
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}