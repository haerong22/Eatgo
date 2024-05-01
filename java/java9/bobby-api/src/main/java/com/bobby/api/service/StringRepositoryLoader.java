package com.bobby.api.service;

import com.bobby.domain.service.StringRepository;

import java.util.ServiceLoader;

public class StringRepositoryLoader {

    private static final String DEFAULT = "com.bobby.domain.service.DatabaseStringRepository";

    public static StringRepository getDefaultRepository() {
        return getRepository(DEFAULT);
    }

    public static StringRepository getRepository(String name) {

        for (StringRepository repository : ServiceLoader.load(StringRepository.class)) {
            if (repository.getClass().getName().equals(name)) {
                return repository;
            }
        }

        throw new IllegalArgumentException("원하는 서비스를 찾을 수 없습니다!");
    }
}
