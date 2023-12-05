package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author max.hu  @date 2023/11/29
 **/
public class JsonUtilTests {
    /**
     * json util 转换测试
     */
    @Test
    public void testJson() {
        MyTestDO testDO = MyTestDO.builder()
                .id(123L).name("howName").bool(true).tags(List.of("t1", "t2"))
                .build();
        String json = JsonUtil.toStr(testDO);
        MyTestDO getTestDO = JsonUtil.toObj(json, MyTestDO.class);
        getTestDO.setId(234L);
        List<MyTestDO> list = List.of(testDO, getTestDO);
        String listStr = JsonUtil.toStr(list);
        List<MyTestDO> getList = JsonUtil.toList(listStr, MyTestDO.class);
        Assert.assertNotNull(getList);

        Map<String, MyTestDO> map = Map.of("o", testDO, "n", getTestDO);
        String mapStr = JsonUtil.toStr(map);
        Map<String, MyTestDO> getMap = JsonUtil.toMap(mapStr, String.class, MyTestDO.class);
        Assert.assertNotNull(getMap);
    }


}
