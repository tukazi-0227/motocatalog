package practice.sample.motocatalog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * バイクメーカーブランド
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    //ブランドID
    private String brandId;
    //ブランド名
    private String brandName;
}
