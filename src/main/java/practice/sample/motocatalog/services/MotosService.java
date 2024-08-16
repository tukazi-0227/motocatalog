package practice.sample.motocatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practice.sample.motocatalog.beans.Brand;
import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.mappers.BrandMapper;
import practice.sample.motocatalog.mappers.MotorcycleMapper;

@Service
public class MotosService {
    
    @Autowired
    MotorcycleMapper motorcycleMapper;

    @Autowired
    BrandMapper brandMapper;

    public List<Motorcycle> getMotos() {

        return motorcycleMapper.selectAll();
    }

    public List<Brand> getBrands() {

        return brandMapper.selectAll();
    }
}
