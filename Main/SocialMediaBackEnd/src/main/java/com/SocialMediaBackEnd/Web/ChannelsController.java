package com.SocialMediaBackEnd.Web;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SocialMediaBackEnd.Domain.Channel;
import com.SocialMediaBackEnd.Domain.User;
import com.SocialMediaBackEnd.Service.ChannelService;

@RestController
@RequestMapping("/api/channels")
public class ChannelsController {
	
	@Autowired
	private ChannelService channelService;

	@PostMapping("")
	public ResponseEntity<?> creatChannel(@AuthenticationPrincipal User user) {
		Channel channel = channelService.save(user);
		return ResponseEntity.ok(channel.getId());
	}
	@GetMapping
	public ResponseEntity<?> showChannels(@AuthenticationPrincipal User user){
		Set<Channel> channels = channelService.findByUser(user);	
		return ResponseEntity.ok(channels);
	}
}
