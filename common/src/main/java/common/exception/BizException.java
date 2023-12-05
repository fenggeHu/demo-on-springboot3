package common.exception;

import lombok.Data;

/**
 *  业务异常
 * @author max.hu  @date 2021-10-25
 **/
@Data
public class BizException extends RuntimeException {
    private int code;
    private String reason;
    private String message;

    public static BizException get(ErrorCode err) {
        return new BizException(err);
    }

    /**
     * 给到用户端错误码
     */
    public BizException(ErrorCode err) {
        super(err.getReasonPhrase());
        this.code = err.getValue();
        this.reason = err.getReasonPhrase();
    }

    /**
     * @ErrorCode 错误码 - 显示给用户端
     * @message 异常信息 - 开发日志，用于排查问题
     */
    public BizException(ErrorCode err, String message) {
        super(message);
        this.code = err.getValue();
        this.reason = err.getReasonPhrase();
        this.message = message;
    }

    /**
     * 没有错误码 - 不推荐使用
     */
    public BizException(String message) {
        super(message);
        this.code = ErrorCode.ERROR.getValue();
        this.reason = message;
    }
}
