package com.hospital.medicalapp.repository;

import com.hospital.medicalapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Spring Data JPA siêu việt ở chỗ: bạn chỉ cần đặt tên hàm chuẩn,
    // nó sẽ tự động sinh ra câu SQL tương ứng.
    // Ví dụ: Lấy toàn bộ tin nhắn của một phòng chat, sắp xếp theo thời gian cũ đến mới
    List<Message> findByRoomIdOrderByCreatedAtAsc(String roomId);
}