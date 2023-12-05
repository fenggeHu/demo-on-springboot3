package common.exception;

/**
 * @description: 分组分类错误码
 * @author max.hu  @date 2021-10-25
 **/
public enum ErrorCode {
    /**
     * 0~99 用于一些常见的错误
     */
    SUCCESS(0, "success"),
    ERROR(1, "error"),
    SYSTEM_ERROR(2, "System Error"),
    API_ERROR(3, "Api Error"),
    WALLET_ERROR(4, "Wallet Error"),
    SIGN_ERROR(5, "Sign Error"),
    PRIVKEY_ERROR(6, "Privkey Error"),
    CHAIN_ERROR(7, "Chain Error"),
    COIN_ERROR(8, "Coin Error"),
    NOT_WHITE_IP_LIST(10, "Not In White Ip"),
    LOGIN_TOKEN_ERROR(11, "need.login"),
    VERIFY_GA_ERROR(12, "verify.google.ga.error"),
    NO_PERMISSION(13, "Hasn't.permission"),
    WRONG_PASSWORD(14, "change.password.wrong"),


    /**
     * 100 ~ 511 Http状态 - from HttpStatus
     */
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    ALREADY_REPORTED(208, "Already Reported"),
    IM_USED(226, "IM Used"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),

    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),

    URI_TOO_LONG(414, "URI Too Long"),

    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Requested range not satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    I_AM_A_TEAPOT(418, "I'm a teapot"),

    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    TOO_EARLY(425, "Too Early"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    PRECONDITION_REQUIRED(428, "Precondition Required"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable For Legal Reasons"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported"),
    VARIANT_ALSO_NEGOTIATES(506, "Variant Also Negotiates"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "Bandwidth Limit Exceeded"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),
    /**
     * 1000 ~ 9999 Request参数错误
     */
    REQUEST_ERROR(1000, "request.error"),
    ERR_REQUEST_PARAMETER(1002, "request.parameter.error"),
    REQUEST_PARAMETER_VALIDATE_FAIL(1007, "request parameter validate fail"),

    NEED_LOGIN(1100, "need.login"),
    LOGIN_INFO_ERR(1101, "login.info.wrong"),
    ACCOUNT_LOCKED(1102, "account.be.locked"),
    UNBIND_GA_ERROR(1103, "unbind.ga.error"),
    UNSUPPORTED_FILE_TYPE(1104, "Unsupported file type"),
    RECAPTCHA_INVALID(1105, "reCaptcha verification failed"),
    HAS_BIND_GA_ERROR(1106, "has.bind.ga.error"),
    UNBIND_GA_OVER_MAX_TIME(1107, "unbind.ga.over.maxTime"),


    /**
     * 10000 ~  业务规则等错误
     */

    ROLE_CREATE_FAIL(10011, "role.create.fail"),
    ROLE_EXISTED(10012, "role.existed"),
    ROLE_NOT_EXISTED(10013, "role.not.existed"),
    USER_NOT_EXISTED(10014, "user.not.existed"),
    PARENT_RES_DISABLED(10015, "parent.res.disabled"),

    BROKER_TOKEN_EXISTED(11001, "broker.token.existed"),
    ONE_MINUTE_DUPLICATE(11002, "one.minute.duplicate"),
    CAPTCHA_ERROR(11003, "captcha.error");

    private final int value;
    private final String reasonPhrase;

    ErrorCode(int value, String reason) {
        this.value = value;
        this.reasonPhrase = reason;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}
