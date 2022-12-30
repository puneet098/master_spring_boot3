package com.demo.kafka.models;

import org.springframework.stereotype.Component;

@Component
public record User(String name, int age) {}
