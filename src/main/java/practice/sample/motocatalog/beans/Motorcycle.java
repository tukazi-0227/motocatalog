package practice.sample.motocatalog.beans;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * �o�C�N
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motorcycle {
    //バイクナンバー
    private Integer motoNo;
    //バイク名
    private String motoName;
    //シート高
    private Integer seatHeight;
    //シリンダー
    private Integer cylinder;
    //冷却
    private String cooling;
    //価格
    private Integer price;
    //コメント
    private String comment;
    //ブランド
    private Brand brand;
    //バージョン
    private Integer version;
    //日時
    private LocalDateTime insDt;
    //更新日時
    private LocalDateTime updDt;

}
