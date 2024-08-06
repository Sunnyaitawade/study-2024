package com.study.sb_transaction_managment.repository;

import com.study.sb_transaction_managment.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
