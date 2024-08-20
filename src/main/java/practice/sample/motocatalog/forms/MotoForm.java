package practice.sample.motocatalog.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import practice.sample.motocatalog.beans.Brand;

/**
 * 更新画面の入力内容
 */
@Data
public class MotoForm {
    // バイクナンバー
    private Integer motoNo;
    // バイク名
    @NotBlank
    @Size(min=1, max=50)
    private String motoName;
    // シート高
    @Min(0)
    @Max(1000)
    private Integer seatHeight;
    // シリンダー
    private Integer cylinder;
    // 冷却
    private String cooling;
    // 価格
    private Integer price;
    // コメント
    @Size(min=1, max=200)
    private String comment;
    // ブランド
    @Valid
    private Brand brand;
    // バージョン
    private Integer version;
}
