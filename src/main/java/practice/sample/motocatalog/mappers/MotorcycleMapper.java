package practice.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import practice.sample.motocatalog.beans.Motorcycle;

@Mapper
public interface MotorcycleMapper {
    
    /**
     * �o�C�N����S������
     * @return �o�C�N��񃊃X�g
     */
    public List<Motorcycle> selectAll();
}
