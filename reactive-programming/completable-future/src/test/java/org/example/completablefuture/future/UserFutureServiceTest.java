package org.example.completablefuture.future;

import org.example.completablefuture.common.User;
import org.example.completablefuture.future.repository.ArticleFutureRepository;
import org.example.completablefuture.future.repository.FollowFutureRepository;
import org.example.completablefuture.future.repository.ImageFutureRepository;
import org.example.completablefuture.future.repository.UserFutureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class UserFutureServiceTest {
    UserFutureService userFutureService;
    UserFutureRepository userRepository;
    ArticleFutureRepository articleRepository;
    ImageFutureRepository imageRepository;
    FollowFutureRepository followRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserFutureRepository();
        articleRepository = new ArticleFutureRepository();
        imageRepository = new ImageFutureRepository();
        followRepository = new FollowFutureRepository();

        userFutureService = new UserFutureService(
                userRepository, articleRepository, imageRepository, followRepository
        );
    }

    @Test
    void getUserEmptyIfInvalidUserIdIsGiven() throws ExecutionException, InterruptedException {
        // given
        String userId = "invalid_user_id";

        // when
        Optional<User> user = userFutureService.getUserById(userId).get();

        // then
        assertTrue(user.isEmpty());
    }

    @Test
    void testGetUser() throws ExecutionException, InterruptedException {
        // given
        String userId = "1234";

        // when
        Optional<User> optionalUser = userFutureService.getUserById(userId).get();

        // then
        assertFalse(optionalUser.isEmpty());
        var user = optionalUser.get();
        assertEquals(user.getName(), "bobby");
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