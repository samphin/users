package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysRoleDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysRoleDtoChecktor {
    public static void check(SysRoleDto sysRoleDto) {
        if (null == sysRoleDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysRoleDto.getName())) {
            throw MyErrorEnum.errorParm.getMyException("角色名称不能为空");
        }
    }

    public static void check(SysRoleDto sysRoleDto, Integer id) {
        check(sysRoleDto);
        if (null == id) {
            throw MyErrorEnum.errorParm.getMyException("角色ID不能为空");
        }
    }
}
