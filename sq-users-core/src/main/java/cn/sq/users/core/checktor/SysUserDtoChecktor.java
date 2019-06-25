package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysUserDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysUserDtoChecktor {
    public static void check(SysUserDto sysUserDto) {
        if (null == sysUserDto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(sysUserDto.getTelephone())) {
            throw MyErrorEnum.errorParm.getMyException("手机号不能为空");
        }
        if (null == sysUserDto.getUsername()) {
            throw MyErrorEnum.errorParm.getMyException("登录名不能为空");
        }
        if (null == sysUserDto.getPassword()) {
            throw MyErrorEnum.errorParm.getMyException("登录密码不能为空");
        }
        if (null == sysUserDto.getRealName()) {
            throw MyErrorEnum.errorParm.getMyException("真实姓名不能为空");
        }
    }
}
