package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysPermissionDto;
import cn.sq.users.core.dto.SysPermissionResourcePkDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysPermissionResourceDtoChecktor {
    public static void check(SysPermissionResourcePkDto pkDto) {
        baseCheck(pkDto);

        if (StringUtils.isEmpty(pkDto.getResourceType())) {
            throw MyErrorEnum.errorParm.getMyException("权限绑定的资源类型不能为空");
        }

        if (StringUtils.isEmpty(pkDto.getResourceIds())) {
            throw MyErrorEnum.errorParm.getMyException("权限绑定的资源信息不能为空");
        }
    }

    public static void baseCheck(SysPermissionResourcePkDto pkDto) {
        if (null == pkDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(pkDto.getPermissionId())) {
            throw MyErrorEnum.errorParm.getMyException("权限ID不能为空");
        }
    }
}
