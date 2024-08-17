package practice.sample.motocatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public int save(Motorcycle moto) {
        return motorcycleMapper.update(moto);
    }
}
