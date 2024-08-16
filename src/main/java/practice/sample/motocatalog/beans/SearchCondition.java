package practice.sample.motocatalog.beans;

import lombok.Data;

@Data
public class SearchCondition {
    
    //ブランドID
    private String brandId;
    //キーワード
    private String keyword;
}
