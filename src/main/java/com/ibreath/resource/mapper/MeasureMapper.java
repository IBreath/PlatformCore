package com.ibreath.resource.mapper;

import com.ibreath.resource.dto.MeasureDto;
import com.ibreath.resource.model.entity.MeasureEntity;
import com.ibreath.utils.Mapper;
import org.springframework.stereotype.Component;

@Component
public class MeasureMapper implements Mapper<MeasureEntity, MeasureDto> {

    @Override
    public MeasureEntity mapDtoToEntity(MeasureDto dto) {
        MeasureEntity measureEntity = new MeasureEntity();
        if (dto.getId() != null)
            measureEntity.setId(dto.getId());
        measureEntity.setValue(dto.getValue());
        if (dto.getDateTime() != null)
            measureEntity.setDateTime(dto.getDateTime());
        return measureEntity;
    }

    @Override
    public MeasureDto mapEntityToDto(MeasureEntity entity) {
        MeasureDto measureDto = new MeasureDto();
        if (entity.getId() != null)
            measureDto.setId(entity.getId());
        measureDto.setDateTime(entity.getDateTime());
        measureDto.setValue(entity.getValue());
        measureDto.setDecreaseTime(entity.getDecreaseTime());
        return measureDto;
    }

    @Override
    public MeasureDto mapEntityIdToDto(MeasureEntity entity) {
        return null;
    }
}
