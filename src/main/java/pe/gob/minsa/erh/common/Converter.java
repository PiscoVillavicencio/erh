package pe.gob.minsa.erh.common;

import java.util.List;

public interface Converter<E,D> {

    D toDto(E entity);
    E toEntity(D dto);
    List<E> toListEntity(List<D> dtos);
    List<D> toListDto(List<E> entities);

}
