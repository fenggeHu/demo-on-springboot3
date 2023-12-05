package admin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author max.hu  @date 2023/12/04
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoVO {
    private Long id;
    private String name;
    private Integer age;
    private Boolean valid;
}
