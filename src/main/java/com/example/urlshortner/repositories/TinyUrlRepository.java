package com.example.urlshortner.repositories;

import com.example.urlshortner.entities.TinyUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyUrlRepository extends JpaRepository<TinyUrl, Long> {

}
