package com.SocialMediaBackEnd.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SocialMediaBackEnd.Domain.Channel;
import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	@SuppressWarnings("unchecked")
	public Channel save(User user) {
		Channel channel = new Channel();
		channel.setName("default");
		List<User> users = new ArrayList<User>();
		users.add(user);
		channel.setUser(users);
		return channelRepo.save(channel);
	}

	public Set<Channel> findByUser(User user) {
		return channelRepo.findByUser(user);
	}

}
