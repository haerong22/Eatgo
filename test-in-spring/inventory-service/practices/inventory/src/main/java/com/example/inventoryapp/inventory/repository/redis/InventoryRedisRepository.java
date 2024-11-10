package com.example.inventoryapp.inventory.repository.redis;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface InventoryRedisRepository {
    @NotNull
    default String key(@NotNull String itemId) {
        return "inventory:" + itemId;
    }

    void addStock(@NotNull String itemId, @NotNull Long stock);

    @Nullable
    Long getStock(@NotNull String itemId);

    @NotNull
    Long decreaseStock(@NotNull String itemId, @NotNull Long quantity);

    @NotNull
    Boolean deleteStock(@NotNull String itemId);

    @NotNull Long setStock(@NotNull String itemId, @NotNull Long stock);
}
