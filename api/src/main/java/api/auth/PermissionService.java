package api.auth;

import api.request.RequestContext;
import com.google.common.base.Strings;
import common.exception.BizException;
import common.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

/**
 *  权限/校验服务
 * @author max.hu  @date 2021-11-15
 **/
@Slf4j
//@Service
//@ConditionalOnBean(annotation = Permission.class)
public class PermissionService {
    /**
     * 鉴权
     *
     * @param userId 用户id
     * @param value  需要权限
     * @return
     */
    public boolean verify(Long userId, String value) {
        if (null == userId) {
            throw new BizException(ErrorCode.NEED_LOGIN);
        }
        if (Strings.isNullOrEmpty(value)) {
            return true;
        }
        // TODO 注入 PermissionRequest

        return false;
    }

    public boolean verify(final SessionInfo session, String value) {
        if (null == session) {
            throw new BizException(ErrorCode.NEED_LOGIN);
        }
        return verify(session.getId(), value);
    }

    /**
     * 鉴权 - 从Request中取SessionInfo
     *
     * @param value permission value -- 为null时，只需要用户登录即可
     * @return
     */
    public boolean verify(String value) {
        return verify(RequestContext.getContext().getSession(), value);
    }

    /**
     * 注入数据权限 -- 应用中拿到权限的orgId注入到请求的Request
     */
//    public void initDataPermission(Collection<DataPermission> pps) {
//        // TODO
//    }
}
