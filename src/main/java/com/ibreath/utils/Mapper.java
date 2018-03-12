package com.ibreath.utils;

public interface Mapper<E, D> {

    /**
     * Map the dto to the corresponding entity
     * @param dto
     * @return the entity
     */
    E mapDtoToEntity(D dto);

    /**
     * Map the entity to the corresponding dto
     * @param entity
     * @return the dto
     */
    D mapEntityToDto(E entity);

    /**
     * Map only the entity's Id to the corresponding dto
     * @param entity
     * @return the dto
     */
    D mapEntityIdToDto(E entity);

}
