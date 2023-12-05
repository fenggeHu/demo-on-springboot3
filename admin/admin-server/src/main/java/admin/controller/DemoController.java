package admin.controller;

import admin.vo.DemoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author max.hu  @date 2023/12/01
 **/
@Slf4j
@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/get")
    public String get(@RequestParam(name = "name") String name) {
        return "hello: " + name;
    }

    @PostMapping("/post")
    public String post(DemoVO demo) {
        return "hello: " + demo;
    }
}
