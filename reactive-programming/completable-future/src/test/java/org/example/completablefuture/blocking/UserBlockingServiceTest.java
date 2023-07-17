package org.example.completablefuture.blocking;

import org.example.completablefuture.blocking.repository.ArticleRepository;
import org.example.completablefuture.blocking.repository.FollowRepository;
import org.example.completablefuture.blocking.repository.ImageRepository;
import org.example.completablefuture.blocking.repository.UserRepository;
import org.example.completablefuture.common.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserBlockingServiceTest {
    UserBlockingService userBlockingService;
    UserRepository userRepository;
    ArticleRepository articleRepository;
    ImageRepository imageRepository;
    FollowRepository followRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        articleRepository = new ArticleRepository();
        imageRepository = new ImageRepository();
        followRepository = new FollowRepository();

        userBlockingService = new UserBlockingService(
                userRepository, articleRepository, imageRepository, followRepository
        );
    }

    @Test
    void getUserEmptyIfInvalidUserIdIsGiven() {
        // given
        String userId = "invalid_user_id";

        // when
        Optional<User> user = userBlockingService.getUserById(userId);

        // then
        assertTrue(user.isEmpty());
    }

    @Test
    void testGetUser() {
        // given
        String userId = "1234";

        // when
        Optional<User> optionalUser = userBlockingService.getUserById(userId);

        // then
        assertFalse(optionalUser.isEmpty());
        var user = optionalUser.get();
        assertEquals(user.getName(), "taewoo");
        assertEquals(user.getAge(), 32);

        assertFalse(user.getProfileImage().isEmpty());
        var image = user.getProfileImage().get();
        assertEquals(image.getId(), "image#1000");
        assertEquals(image.getName(), "profileImage");
        assertEquals(image.getUrl(), "https://dailyone.com/images/1000");

        assertEquals(2, user.getArticleList().size());

        assertEquals(1000, user.getFollowCount());
    }
}