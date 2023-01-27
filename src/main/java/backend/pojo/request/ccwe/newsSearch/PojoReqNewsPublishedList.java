package backend.pojo.request.ccwe.newsSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PojoReqNewsPublishedList {

    private Integer itemsPerPage;
    private Integer page;
    private String search;
    private Object searchByField;
    private AddParams addParams;

}
