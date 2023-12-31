package api.controller;

import api.service.SayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author max.hu  @date 2023/12/04
 **/
@Slf4j
@RestController
@RequestMapping("/api")
@Tag(name = "api demo", description = "测试spring boot3 web")
public class DemoController {
    @Autowired
    private SayService sayService;

    @GetMapping("/hello")
    public String hello(String name) {
        log.info("===========test=============");
        return sayService.hello(name);
    }
}
