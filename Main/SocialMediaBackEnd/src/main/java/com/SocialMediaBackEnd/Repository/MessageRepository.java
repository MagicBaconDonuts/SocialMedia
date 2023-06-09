package com.SocialMediaBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocialMediaBackEnd.Domain.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
