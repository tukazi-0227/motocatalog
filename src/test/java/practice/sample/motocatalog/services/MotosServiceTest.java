package practice.sample.motocatalog.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;

import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.services.MotosService;

@SpringBootTest
public class MotosServiceTest {
    
    @Autowired
    MotosService service;

    @Test
    void バイク情報を全件検索() {
        List<Motorcycle> motos = service.getMotos();
        // 検索結果の件数確認
        assertThat(motos.size()).isEqualTo(2);
        // 検索結果の各項目確認
        Motorcycle moto = motos.get(0);
        assertThat(moto.getMotoNo()).isEqualTo(1);
        assertThat(moto.getMotoName()).isEqualTo("GB350");
        //assertThat(moto.getPrice()).isEqualTo("GB350");
    }
}
