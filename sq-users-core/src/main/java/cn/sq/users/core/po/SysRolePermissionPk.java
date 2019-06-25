package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysRolePermissionPkDto;

import java.util.ArrayList;
import java.util.List;

public class SysRolePermissionPk{

    private Integer roleId;

    private Integer permissionId;

    public SysRolePermissionPk() {
    }

    public SysRolePermissionPk(Integer roleId, Integer permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public List<SysRolePermissionPk> buildPoList(SysRolePermissionPkDto dto){

        List<SysRolePermissionPk> poList = new ArrayList<>();

        String[] permissionIds = dto.getPermissionIds().split(",");

        for (String permissionId:permissionIds) {
            SysRolePermissionPk po = new SysRolePermissionPk(dto.getRoleId(),Integer.valueOf(permissionId));
            poList.add(po);
        }
        return poList;
    }
}