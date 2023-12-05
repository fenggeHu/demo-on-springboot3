package api.main;

import common.response.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * api 测试
 *
 * @author max.hu  @date 2023/11/30
 **/
@RestController
@RequestMapping("/api/v1")
public class MainController {

    @PostMapping("/post")
    public Result post() {
        return Result.ofSuccess();
    }
}
