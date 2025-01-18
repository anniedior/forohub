package com.forohub.foro.controller;

import com.forohub.foro.topic.Topic;
import com.forohub.foro.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    @Autowired
    private TopicService service;

    @GetMapping
    public List<Topic> getAllTopics() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Topic topic = service.findById(id);
        if (topic != null) {
            return ResponseEntity.ok(topic);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return service.save(topic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topicDetails) {
        Topic updatedTopic = service.update(id, topicDetails);
        if (updatedTopic != null) {
            return ResponseEntity.ok(updatedTopic);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
