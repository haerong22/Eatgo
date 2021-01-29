package com.example.jpablog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@DynamicInsert // insert 시 null 인 필드 제거하고 insert
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트 에서 연결된 DB의 넘버링 전략 사용
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("'USER'")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private LocalDateTime createDate;
}
