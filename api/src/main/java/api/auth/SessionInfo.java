package api.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 用户基本信息
 * @author max.hu  @date 2021-11-12
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SessionInfo implements Serializable {
    private static final long serialVersionUID = -4185523626408110835L;
    /**
     * 用户id - userId
     */
    private Long id;

    private String username;

    private Long orgId;

    private String orgName;

    private Boolean bindGA;

    private Boolean bindPhone;
    /**
     * sessionId
     */
    private String requestId;
}
