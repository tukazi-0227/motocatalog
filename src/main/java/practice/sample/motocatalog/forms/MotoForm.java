package practice.sample.motocatalog.forms;

import java.time.LocalDateTime;

import lombok.Data;
import practice.sample.motocatalog.beans.Brand;

/**
 * 更新画面の入力内容
 */
@Data
public class MotoForm {
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
}
