package practice.sample.motocatalog.beans;

import lombok.Data;

@Data
public class SearchForm {
    
    //ブランドID
    private String brandId;
    //キーワード
    private String keyword;
}
