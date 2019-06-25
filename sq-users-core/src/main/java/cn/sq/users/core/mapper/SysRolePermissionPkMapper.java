package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysRolePermissionPk;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRolePermissionPkMapper extends Mapper<SysRolePermissionPk> {

    /**
     * 给角色分配权限
     *
     * @param rolePermissionPkList
     * @return
     */
    int saveBatch(List<SysRolePermissionPk> rolePermissionPkList);
}