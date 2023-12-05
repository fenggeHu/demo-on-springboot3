package common.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页查询结果
 *
 * @author max.hu  @date 2023/11/29
 **/
@Data
public class PageResult<T> extends ErrorResult implements Serializable {

    private static final long serialVersionUID = 12349079235167634L;

    /**
     * 当前页码，从1开始
     */
    private int current = 1;
    /**
     * 每页数据条数
     */
    private int pageSize = 20;
    /**
     * 总条数
     */
    private long total;

    /**
     * 业务数据
     */
    private List<T> data;

    public PageResult() {
    }

    public PageResult(Long total, List<T> list) {
        this.total = total;
        this.data = list;
    }

    public PageResult(int current, int pageSize, Long total, List<T> list) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
        this.data = list;
    }

    public static <T> PageResult of(List<T> list, Long total, Integer current, Integer pageSize) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCurrent(current);
        pageResult.setPageSize(pageSize);
        pageResult.setTotal(total);
        pageResult.setData(list);
        return pageResult;
    }
}
