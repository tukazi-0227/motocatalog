package practice.sample.motocatalog.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.beans.SearchForm;

@Mapper
public interface MotorcycleMapper {
    
    /**
     * バイク情報を検索条件
     * @param condition 検索条件
     * @return バイク情報リスト
     */

    public List<Motorcycle> selectByCondition(SearchForm condition);

    /**
     * バイク情報を主キー検索
     * @param motoNo バイク番号
     * @return バイク情報リスト
     */

     public Motorcycle selectByPK(int motoNo);

    /**
     * バイク情報の更新
     * @param moto
     * @return
     */
    @Update("UPDATE m_motorcycle SET moto_name = #{motoName} , seat_height = #{seatHeight} , cylinder = #{cylinder} , cooling = #{cooling} , price = #{price} , comment = #{comment} , brand_id = #{brand.brandId} , version = version+1, ins_dt = #{insDt} , upd_dt = #{updDt} WHERE moto_no = #{motoNo}")
    public int update(Motorcycle moto);
}
