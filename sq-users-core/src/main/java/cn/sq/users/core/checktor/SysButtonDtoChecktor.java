package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysButtonDtoChecktor {

    public static void check(SysButtonDto sysButtonDto) {
        if (null == sysButtonDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysButtonDto.getName())) {
            throw MyErrorEnum.errorParm.getMyException("按钮名称不能为空");
        }

        if (StringUtils.isEmpty(sysButtonDto.getMenuId())) {
            throw MyErrorEnum.errorParm.getMyException("按钮所属菜单ID不能为空");
        }
    }

    public static void check(SysButtonDto sysButtonDto, Integer id) {
        check(sysButtonDto);
        if (null == id) {
            throw MyErrorEnum.errorParm.getMyException("按钮ID不能为空");
        }
    }

}
