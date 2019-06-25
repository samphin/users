package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysPermissionDto;
import cn.sq.users.core.dto.SysPermissionStateDto;
import cn.sq.users.core.dto.SysRoleDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysPermissionDtoChecktor {
    public static void check(SysPermissionDto sysPermissionDto) {
        if (null == sysPermissionDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysPermissionDto.getName())) {
            throw MyErrorEnum.errorParm.getMyException("权限名称不能为空");
        }
    }

    public static void check(SysPermissionDto sysPermissionDto, Integer id) {
        check(sysPermissionDto);
        if (null == id) {
            throw MyErrorEnum.errorParm.getMyException("权限ID不能为空");
        }
    }

    public static void check(SysPermissionStateDto stateDto) {
        if (null == stateDto) {
            throw MyErrorEnum.errorParm.getMyException("权限信息不能为空");
        }

        if (null == stateDto.getId()) {
            throw MyErrorEnum.errorParm.getMyException("权限ID不能为空");
        }

        if (null == stateDto.getState()) {
            throw MyErrorEnum.errorParm.getMyException("权限状态不能为空");
        }

    }
}
