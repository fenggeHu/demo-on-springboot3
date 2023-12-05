package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author max.hu  @date 2023/11/29
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyTestDO {
    Long id;
    String name;
    boolean bool;
    List<String> tags;
}
