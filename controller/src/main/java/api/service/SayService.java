package api.service;

import org.springframework.stereotype.Service;

/**
 * @author max.hu  @date 2023/12/04
 **/
@Service
public class SayService {

    public String hello(String name) {
        return "Hello, " + name;
    }
}
