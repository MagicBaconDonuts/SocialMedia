package com.SocialMediaBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocialMediaBackEnd.Domain.Channel;
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
