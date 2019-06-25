package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysUserRolePkDto;

import java.util.ArrayList;
import java.util.List;

public class SysUserRolePk{

    private Integer userId;

    private Integer roleId;

    public SysUserRolePk() {
    }

    public SysUserRolePk(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    /**
     * 将组与角色信息转换成集合
     * @param dto
     * @return
     */
    public List<SysUserRolePk> buildSysGroupRole(SysUserRolePkDto dto){
        String[] roleIdArray = dto.getRoleIds().split(",");
        List<SysUserRolePk> sysUserRolePkList = new ArrayList<>();
        for (String roleId: roleIdArray) {
            SysUserRolePk sysUserRolePk = new SysUserRolePk(dto.getUserId(),Integer.valueOf(roleId));
            sysUserRolePkList.add(sysUserRolePk);
        }
        return sysUserRolePkList;
    }
}