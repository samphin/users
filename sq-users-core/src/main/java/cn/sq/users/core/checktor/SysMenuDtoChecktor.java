package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.dto.SysRoleDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysMenuDtoChecktor {
    public static void check(SysMenuDto sysMenuDto) {
        if (null == sysMenuDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysMenuDto.getName())) {
            throw MyErrorEnum.errorParm.getMyException("菜单名称不能为空");
        }
    }

    public static void check(SysMenuDto sysMenuDto, Integer id) {
        check(sysMenuDto);
        if (null == id) {
            throw MyErrorEnum.errorParm.getMyException("菜单ID不能为空");
        }
    }

}
