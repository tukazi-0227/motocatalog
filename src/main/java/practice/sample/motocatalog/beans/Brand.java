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
    //�u�����hID
    private String brandId;
    //�u�����h��
    private String brandName;
}
