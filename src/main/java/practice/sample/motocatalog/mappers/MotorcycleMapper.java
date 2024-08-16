package practice.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import practice.sample.motocatalog.beans.Motorcycle;

@Mapper
public interface MotorcycleMapper {
    
    /**
     * バイク情報を全権検索
     * @return バイク情報リスト
     */
    public List<Motorcycle> selectAll();
}
