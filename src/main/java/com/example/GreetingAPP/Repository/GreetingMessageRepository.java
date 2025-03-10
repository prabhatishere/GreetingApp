package com.example.GreetingAPP.Repository;

import com.example.GreetingAPP.Entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingMessageRepository extends JpaRepository<Greeting, Long> {

}

