package dev.telegrambot.storage.web.mappers;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D dto);

    D toDTO(E entity);

    List<D> toDTO(List<E> entities);

    List<E> toEntities(List<D> dtoList);
}
