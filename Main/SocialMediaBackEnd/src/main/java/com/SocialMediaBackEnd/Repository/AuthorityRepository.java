package com.SocialMediaBackEnd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SocialMediaBackEnd.Domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
