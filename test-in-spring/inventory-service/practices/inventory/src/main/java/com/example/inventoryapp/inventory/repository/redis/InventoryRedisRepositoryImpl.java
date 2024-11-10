package com.example.inventoryapp.inventory.repository.redis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRedisRepositoryImpl implements InventoryRedisRepository {
    private final StringRedisTemplate redisTemplate;

    public InventoryRedisRepositoryImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addStock(@NotNull String itemId, @NotNull Long stock) {


        return;
    }

    @Override
    public @Nullable Long getStock(@NotNull String itemId) {
        final String stockStr = redisTemplate.opsForValue().get(key(itemId));
        if (stockStr == null) {
            return null;
        }
        return Long.parseLong(stockStr);
    }

    @Override
    public @NotNull Long decreaseStock(@NotNull String itemId, @NotNull Long quantity) {
        return redisTemplate.opsForValue().decrement(key(itemId), quantity);
    }

    @Override
    public @NotNull Boolean deleteStock(@NotNull String itemId) {
        return redisTemplate.delete(key(itemId));
    }

    @Override
    public @NotNull Long setStock(@NotNull String itemId, @NotNull Long stock) {
        redisTemplate.opsForValue().set(key(itemId), stock.toString());
        return stock;
    }
}
