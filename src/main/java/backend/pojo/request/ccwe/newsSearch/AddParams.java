package backend.pojo.request.ccwe.newsSearch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddParams {

    private Integer titleSize;
    private Integer contentSize;

}
