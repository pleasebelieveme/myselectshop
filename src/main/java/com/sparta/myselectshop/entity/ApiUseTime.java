package com.sparta.myselectshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "api_use_time")
public class ApiUseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 1명이 1개를 가, 외래키는 여기서 관, 단방향 api_use_time -> user
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long totalTime;

    public ApiUseTime(User user, Long totalTime) {
        this.user = user;
        this.totalTime = totalTime;
    }

    public void addUseTime(long useTime) {
        this.totalTime += useTime;
    }
}