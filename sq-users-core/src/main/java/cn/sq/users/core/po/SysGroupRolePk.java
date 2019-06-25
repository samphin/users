package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysGroupRolePkDto;

import java.util.ArrayList;
import java.util.List;

public class SysGroupRolePk{

    private Integer groupId;

    private Integer roleId;

    public SysGroupRolePk() {
    }

    public SysGroupRolePk(Integer groupId, Integer roleId) {
        this.groupId = groupId;
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
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
    public List<SysGroupRolePk> buildSysGroupRole(SysGroupRolePkDto dto){
        String[] roleIdArray = dto.getRoleIds().split(",");
        List<SysGroupRolePk> sysGroupRolePkList = new ArrayList<>();
        for (String roleId: roleIdArray) {
            SysGroupRolePk sysGroupRolePk = new SysGroupRolePk(dto.getGroupId(),Integer.valueOf(roleId));
            sysGroupRolePkList.add(sysGroupRolePk);
        }
        return sysGroupRolePkList;
    }
}