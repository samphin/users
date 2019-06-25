package cn.sq.users.core.checktor;

import cn.sq.users.core.dto.SysUserDto;
import cn.sq.users.core.dto.SysUserPasswordDto;
import cn.sq.users.core.exception.MyErrorEnum;
import org.springframework.util.StringUtils;

public class SysUserPasswordDtoChecktor {
    public static void check(SysUserPasswordDto dto) {
        if (null == dto) {
            throw MyErrorEnum.errorParm.getMyException();
        }
        if (StringUtils.isEmpty(dto.getOldPassword())) {
            throw MyErrorEnum.errorParm.getMyException("旧密码不能为空");
        }
        if (StringUtils.isEmpty(dto.getNewPassword())) {
            throw MyErrorEnum.errorParm.getMyException("新密码不能为空");
        }

        if (dto.getOldPassword().equals(dto.getNewPassword())) {
            throw MyErrorEnum.errorParm.getMyException("新旧密码不可以相同");
        }
    }
}
