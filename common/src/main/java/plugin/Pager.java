package plugin;

import lombok.Getter;

import java.io.Serializable;

/**
 * 简单的计算分页
 * @author Jinfeng.hu  @date 2021-11-01
 **/
public class Pager implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 页码
     */
    @Getter
    private int pageNum;
    /**
     * 页size
     */
    @Getter
    private int pageSize;
    /**
     * 起始行
     */
    @Getter
    private int startRow;
    /**
     * 结束行
     */
    @Getter
    private int endRow;

    /**
     * constructor
     * @param pageNum
     * @param pageSize
     */
    public Pager(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.calculateStartAndEndRow();
    }

    private void calculateStartAndEndRow() {
        this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
        this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
    }

    /**
     * Create a pager Object
     * @param pageNum
     * @param pageSize
     * @return pager
     */
    public static Pager getPager(int pageNum, int pageSize) {
        return new Pager(pageNum, pageSize);
    }

}
