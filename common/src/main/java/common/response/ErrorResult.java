package common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 错误结果
 * @author max.hu  @date 2023/11/29
 **/
@Data
public class ErrorResult implements Serializable {

    /**
     * 默认成功码
     */
    protected static final String DEFAULT_SUCCESS_CODE = "0";

    /**
     * 默认错误码
     */
    protected static final String DEFAULT_ERROR_CODE = "-1";
    /**
     * 错误码
     */
    protected String code;

    /**
     * 错误提示语
     */
    protected String message;

    public ErrorResult() {
    }

    public ErrorResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 失败，自定义错误码和信息
     *
     * @param errorCode 错误码
     * @param errorMsg  错误提示
     * @return response
     */
    public static ErrorResult of(String errorCode, String errorMsg) {
        return new ErrorResult(errorCode, errorMsg);
    }
}
