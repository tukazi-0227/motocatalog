package practice.sample.motocatalog.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import practice.sample.motocatalog.beans.Brand;

//import org.springframework.test.context.ActiveProfiles;

import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.beans.SearchForm;

@SpringBootTest
public class MotosServiceTest {

    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    
    @Autowired
    MotosService service;

     @Test
     void バイク情報を全件検索() {
         SearchForm condition = new SearchForm();
         List<Motorcycle> motos = service.getMotos(condition);
          // 検索結果の件数確認
        //assertThat(motos.size()).isEqualTo(2);
        // 検索結果の各項目確認
         Motorcycle moto = motos.get(0);
         assertThat(moto.getMotoNo()).isEqualTo(1);
         assertThat(moto.getMotoName()).isEqualTo("GB350");
         assertThat(moto.getPrice()).isEqualTo(550000);
     }

     @ParameterizedTest
     @CsvSource({"01, Honda", "02, Kawasaki", "03, Yamaha"})
     @DisplayName("バイク一覧取得 条件: ブランドID")
     void test001(String brandId, String brandName) {
         SearchForm condition = new SearchForm();
         condition.setBrandId(brandId); // Honda

         List<Motorcycle> motos = service.getMotos(condition);
         assertThat(motos.size()).isGreaterThanOrEqualTo(1);
         for (Motorcycle moto : motos) {
             assertThat(moto.getBrand().getBrandName()).isEqualTo(brandName);
         }
     }

    // ブランドID該当なし
    @Test
    @DisplayName("バイク一覧取得 条件: ブランドID 該当なし")
    void test002() {
        SearchForm condition = new SearchForm();
        condition.setBrandId("99"); //Honda

        List<Motorcycle> motos = service.getMotos(condition);
        assertThat(motos.size()).isEqualTo(0);
    }

    //バイク一覧取得: バイク名完全一致
    @ParameterizedTest
     @CsvSource({"Z900RS", "YZF-R1", "Rebel250"})
     @DisplayName("バイク一覧取得 条件: バイク名完全一致")
     void test003(String motoName) {
         SearchForm condition = new SearchForm();
         condition.setKeyword(motoName);

         List<Motorcycle> motos = service.getMotos(condition);
         assertThat(motos.size()).isGreaterThanOrEqualTo(1);
         for (Motorcycle moto : motos) {
             assertThat(moto.getMotoName()).isEqualTo(motoName);
         }
     }

    //バイク一覧取得: バイク名前方一致
    //バイク一覧取得: バイク名後方一致
    //バイク一覧取得: バイク名部分一致
    @ParameterizedTest
     @CsvSource({"Z900R, Z900RS", "F-R1, YZF-R1", "bel25, Rebel250"})
     @DisplayName("バイク一覧取得 条件: バイク名部分一致")
     void test004(String keyword, String motoName) {
         SearchForm condition = new SearchForm();
         condition.setKeyword(keyword);

         List<Motorcycle> motos = service.getMotos(condition);
         assertThat(motos.size()).isGreaterThanOrEqualTo(1);
         for (Motorcycle moto : motos) {
             assertThat(moto.getMotoName()).isEqualTo(motoName);
         }
     }

    //バイク情報取得 条件: バイク番号
    @ParameterizedTest
    @CsvSource({"1, GB350", "2, Z900RS"})
    @DisplayName("バイク一覧取得 条件: バイク番号")
    void test005(int motoNo, String motoName) {

        Motorcycle moto = service.getMotos(motoNo);
        assertThat(moto.getMotoName()).isEqualTo(motoName);
    }

    //バイク情報取得 条件: 全項目確認
    @DisplayName("バイク一覧取得 条件: 全項目確認")
    @Test
    void test006() {

        Motorcycle moto = service.getMotos(1);
        assertThat(moto.getMotoNo()).isEqualTo(1);
        assertThat(moto.getMotoName()).isEqualTo("GB350");
        assertThat(moto.getSeatHeight()).isEqualTo(800);
        assertThat(moto.getCylinder()).isEqualTo(1);
        assertThat(moto.getCooling()).isEqualTo("空冷");
        assertThat(moto.getPrice()).isEqualTo(550000);
        assertThat(moto.getComment()).isEqualTo("音がいい");
        assertThat(moto.getBrand().getBrandId()).isEqualTo("01");
        assertThat(moto.getVersion()).isEqualTo(1);
        assertThat(moto.getInsDt().format(dtFormatter)).isEqualTo(LocalDateTime.now().format(dtFormatter));
        assertThat(moto.getUpdDt()).isNull();
    }
    //バイク情報更新
    @DisplayName("バイク情報更新")
    @Test
    @Transactional
    @Rollback
    void test007() {

        Motorcycle before = service.getMotos(1);
        before.setMotoName("motomoto");

        service.save(before); //更新

        Motorcycle after = service.getMotos(1); //変更後の情報取得
        assertThat(after.getMotoName()).isEqualTo("motomoto");
        assertThat(after.getVersion()).isEqualTo(before.getVersion() + 1);
    }

    //バイク情報登録
    @DisplayName("バイク情報登録")
    @Test
    @Transactional
    @Rollback
    void test008() {
        Motorcycle before = new Motorcycle();
        //バイク名
        before.setMotoName("もともと");
        //シート高
        before.setSeatHeight(500);
        //シリンダー
        before.setCylinder(3);
        //冷却
        before.setCooling("空冷");
        //価格
        before.setPrice(1000);
        //コメント
        before.setComment("いいね");
        //ブランド
        before.setBrand(new Brand("01", "Honda"));

        service.save(before); //更新

        Motorcycle after = service.getMotos(10); //変更後の情報取得
        assertThat(after.getMotoName()).isEqualTo("もともと");
        assertThat(after.getSeatHeight()).isEqualTo(500);
        assertThat(after.getCylinder()).isEqualTo(3);
        assertThat(after.getCooling()).isEqualTo("空冷");
        assertThat(after.getPrice()).isEqualTo(1000);
        assertThat(after.getComment()).isEqualTo("いいね");
        assertThat(after.getVersion()).isEqualTo(1);
        assertThat(after.getInsDt().format(dtFormatter)).isEqualTo(LocalDateTime.now().format(dtFormatter));
        assertThat(after.getUpdDt()).isNull();
    }
}
