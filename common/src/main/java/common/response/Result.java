package common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * response result
 * @author max.hu  @date 2023/11/29
 * @param <T> Response Body
 **/
@Data
public class Result<T> extends ErrorResult implements Serializable {

    private static final long serialVersionUID = 1932582311952558987L;

    /**
     * 业务数据
     */
    private T data;


    public Result() {
    }

    /**
     * init result with params
     * @param code
     * @param message
     * @param data
     */
    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功，不用返回数据
     * @param <T> response object
     * @return response
     */
    public static <T> Result<T> ofSuccess() {
        return new Result<>(DEFAULT_SUCCESS_CODE, null, null);
    }

    /**
     * 成功，返回数据
     * @param <T> response object
     * @return response
     */
    public static <T> Result<T> ofSuccess(T data) {
        return new Result<>(DEFAULT_SUCCESS_CODE, null, data);
    }

    /**
     * 失败，固定状态码
     * @param <T> response object
     * @return response
     */
    public static <T> Result<T> ofError(String errorMsg) {
        return new Result<>(DEFAULT_ERROR_CODE, errorMsg, null);
    }

    /**
     * 失败，自定义错误码和信息
     *
     * @param <T> response object
     * @param errorCode 错误码
     * @param errorMsg  错误提示
     * @return response
     */
    public static <T> Result<T> ofError(String errorCode, String errorMsg) {
        return new Result<>(errorCode, errorMsg, null);
    }

}
