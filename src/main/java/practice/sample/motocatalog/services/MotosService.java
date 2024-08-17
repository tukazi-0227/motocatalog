package practice.sample.motocatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import practice.sample.motocatalog.beans.Brand;
import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.beans.SearchForm;
import practice.sample.motocatalog.mappers.BrandMapper;
import practice.sample.motocatalog.mappers.MotorcycleMapper;

@Service
public class MotosService {
    
    @Autowired
    MotorcycleMapper motorcycleMapper;

    @Autowired
    BrandMapper brandMapper;

    public List<Motorcycle> getMotos(SearchForm condition) {

        return motorcycleMapper.selectByCondition(condition);
    }

    public Motorcycle getMotos(int motoNo) {

        return motorcycleMapper.selectByPK(motoNo);
    }

    public List<Brand> getBrands() {

        return brandMapper.selectAll();
    }

    /**
     * バイク情報の更新
     * @param moto
     * @return
     */
    public int save(Motorcycle moto) {
        int cnt = motorcycleMapper.update(moto);
        if (cnt == 0) {
            throw new OptimisticLockingFailureException("楽観的排他エラー");
        }
        return cnt;
    }
}
