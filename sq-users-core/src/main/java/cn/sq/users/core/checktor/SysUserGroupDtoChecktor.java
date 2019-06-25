package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysUserGroupDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysUserGroupDtoChecktor {

    public static void check(SysUserGroupDto sysGroupDto) {
        if (null == sysGroupDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysGroupDto.getName())) {
            throw MyErrorEnum.errorParm.getMyException("组名不能为空");
        }
    }

    public static void check(SysUserGroupDto sysGroupDto,Integer id) {
        check(sysGroupDto);
        if (null == id) {
            throw MyErrorEnum.errorParm.getMyException("用户组ID不能为空");
        }
    }
}
