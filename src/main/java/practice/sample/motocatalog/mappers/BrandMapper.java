package practice.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import practice.sample.motocatalog.beans.Brand;

@Mapper
public interface BrandMapper {
    /**
     * ブランド情報を全権検索
     * @return ブランドリスト
     */
    public List<Brand> selectAll();
}
