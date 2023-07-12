package com.SocialMediaBackEnd.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocialMediaBackEnd.Domain.Channel;
import com.SocialMediaBackEnd.Domain.User;
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

	Set<Channel> findByUser(User user);
}
