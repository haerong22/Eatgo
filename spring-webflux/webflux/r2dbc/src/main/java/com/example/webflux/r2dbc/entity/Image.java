package com.example.webflux.r2dbc.entity;

import lombok.Data;

@Data
public class Image {
    private final String id;
    private final String name;
    private final String url;
}