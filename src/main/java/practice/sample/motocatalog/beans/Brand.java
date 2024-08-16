package practice.sample.motocatalog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * �o�C�N���[�J�[�u�����h
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    //ブランドhID
    private String brandId;
    //ブランド名
    private String brandName;
}
