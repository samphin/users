package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysGroupRolePkDto;
import cn.sq.users.core.dto.SysUserGroupPkDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysGroupRoleDtoChecktor {

    public static void check(SysGroupRolePkDto dto) {
        if (null == dto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(dto.getRoleIds())) {
            throw MyErrorEnum.errorParm.getMyException("组分配的角色信息不能为空");
        }

        if (null == dto.getGroupId()) {
            throw MyErrorEnum.errorParm.getMyException("用户组不能为空");
        }
    }
}
