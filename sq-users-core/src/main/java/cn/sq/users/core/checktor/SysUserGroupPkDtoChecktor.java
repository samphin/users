package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysUserGroupPkDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysUserGroupPkDtoChecktor {
    public static void check(SysUserGroupPkDto dto) {
        if (null == dto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(dto.getUserIds())) {
            throw MyErrorEnum.errorParm.getMyException("用户信息不能为空");
        }

        if (null == dto.getGroupId()) {
            throw MyErrorEnum.errorParm.getMyException("用户组不能为空");
        }
    }
}
