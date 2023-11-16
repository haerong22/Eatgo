package com.example.test_demo.mock;

import com.example.test_demo.post.domain.Post;
import com.example.test_demo.post.service.port.PostRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakePostRepository implements PostRepository {

    private final AtomicLong autoGeneratedId = new AtomicLong();
    private final List<Post> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Optional<Post> findById(long id) {
        return data.stream().filter(item -> item.getId().equals(id)).findAny();
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == null || post.getId() == 0) {
            Post newPost = Post.builder()
                    .id(autoGeneratedId.incrementAndGet())
                    .content(post.getContent())
                    .createdAt(post.getCreatedAt())
                    .modifiedAt(post.getModifiedAt())
                    .writer(post.getWriter())
                    .build();
            data.add(newPost);
            return newPost;
        } else {
            data.removeIf(item -> item.getId().equals(post.getId()));
            data.add(post);
            return post;
        }
    }
}
