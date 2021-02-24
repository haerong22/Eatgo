package com.example.apptest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("tag test")
    @Tag("fast")
    void test_14() {
        System.out.println("fast");
        Study study = new Study(10);
        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
    }

    @Test
    @DisplayName("tag test")
    @Tag("slow")
    void test_13() {
        System.out.println("slow");
        Study study = new Study(10);
        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
    }

//    @Test
//    @DisplayName("DisabledIfEnvironmentVariable test")
//    @DisabledIfEnvironmentVariable(named = "TEST_ENV", matches = "KIM")
//    void test_12() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }
//
//    @Test
//    @DisplayName("EnabledIfEnvironmentVariable test")
//    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "KIM")
//    void test_11() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }

//    @Test
//    @DisplayName("EnabledOnJre test")
//    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
//    void test_10() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }
//
//    @Test
//    @DisplayName("DisabledOnJre test")
//    @DisabledOnJre(JRE.JAVA_11)
//    void test_9() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }
//
//    @Test
//    @DisplayName("EnabledOnOs test")
//    @EnabledOnOs({OS.WINDOWS, OS.MAC})
//    void test_8() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }
//
//    @Test
//    @DisplayName("DisabledOnOs test")
//    @DisabledOnOs(OS.WINDOWS)
//    void test_7() {
//        System.out.println("테스트");
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }

//    @Test
//    @DisplayName("assumingThat test")
//    void test_6() {
//        String test_env = System.getenv("TEST_ENV");
//        Assumptions.assumingThat(test_env.equals("KIM"), () -> {
//            System.out.println("env_kim");
//            Study study = new Study(10);
//            assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//        });
//
//        Assumptions.assumingThat(test_env.equals("LEE"), () -> {
//            System.out.println("env_lee");
//            Study study = new Study(10);
//            assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//        });
//    }
//
//    @Test
//    @DisplayName("assumeTrue test")
//    void test_5() {
//        String test_env = System.getenv("TEST_ENV");
//        System.out.println(test_env);
//        Assumptions.assumeTrue("kim".equalsIgnoreCase(test_env));
//
//        Study study = new Study(10);
//        assertTrue(study.getLimit() > 0, () -> "limit 는 0보다 커야한다.");
//    }
//
//    @Test
//    @DisplayName("assertTimeout test")
//    void test_4() {
//        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            Thread.sleep(300);
//            new Study(10);
//        });
//
//        // assertTimeout( 시간, 실행구문 )
//        // 실행 구문이 끝날 때 까지 기다렸다가 결과를 출력한다.
//        assertTimeout(Duration.ofMillis(100), () -> {
//            Thread.sleep(300);
//            new Study(10);
//        });
//    }
//
//    @Test
//    @DisplayName("assertThrows test")
//    void test_3() {
//        // 리턴 값은 해당 예외 타입이다.
//        IllegalArgumentException exception =
//                assertThrows(IllegalArgumentException.class, () -> new Study(-10));
//
//        // 에러 메시지 확인도 가능하다
//        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
//    }
//
//    @Test
//    @DisplayName("assertAll test")
//    void test_2() {
//        Study study = new Study(-10);
//
//        assertAll(
//                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다."),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 status가 DRAFT 이어야 한다.")
//        );
//    }
//
//    @Test
//    @DisplayName("assertTrue test")
//    void test_1() {
//        Study study = new Study(10);
//        // assertTrue( 조건, 실패시 출력 메시지 )
//        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");
//    }
//
//    @Test
//    @DisplayName("assertEquals test")
//    void test() {
//        Study study = new Study();
//        // assertEquals( 기대값, 실제값, 실패시 메시지 )
//
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 status가 DRAFT 이어야 한다.");
//    }
//
//    @Test
//    void create_new_study() {
//        Study study = new Study();
//        assertNotNull(study);
//        System.out.println("create 테스트");
//    }
//
//    @Test
//    @DisplayName("스터디 생성하기!! 💖")
//    void create_new_study_2() {
//        System.out.println("create1 테스트");
//    }
//
//    // @Disabled : 모든 테스트 실행 시 테스트 제외
//    @Test
//    @Disabled
//    void create2() {
//        System.out.println("create2 테스트");
//    }
//
//    /**
//     * 모든 테스트 실행 전에 한번 실행
//     * 반드시 static 메소드 사용해야 하며 리턴타입은 void
//     * private 은 사용 불가, default 는 가능
//     */
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("before all");
//    }
//
//    /**
//     * 모든 테스트 실행 후에 한번 실행
//     * 반드시 static 메소드 사용해야 하며 리턴타입은 void
//     */
//    @AfterAll
//    static void afterAll() {
//        System.out.println("after all");
//    }
//
//    /**
//     * 각 테스트 실행 전에 한번씩 실행
//     */
//    @BeforeEach
//    void beforeEach() {
//        System.out.println("before each");
//    }
//
//    /**
//     * 각 테스트 실행 후에 한번씩 실행
//     */
//    @AfterEach
//    void afterEach() {
//        System.out.println("after each");
//    }
}