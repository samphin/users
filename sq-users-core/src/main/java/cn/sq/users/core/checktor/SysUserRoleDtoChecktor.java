package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysGroupRolePkDto;
import cn.sq.users.core.dto.SysUserRolePkDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysUserRoleDtoChecktor {
    public static void check(SysUserRolePkDto dto) {
        if (null == dto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(dto.getRoleIds())) {
            throw MyErrorEnum.errorParm.getMyException("组分配的角色信息不能为空");
        }

        if (null == dto.getUserId()) {
            throw MyErrorEnum.errorParm.getMyException("用户不能为空");
        }
    }
}
