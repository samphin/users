package cn.sq.users.core.mapper;

import cn.sq.users.core.po.SysPermissionResourcePk;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysPermissionResourcePkMapper extends Mapper<SysPermissionResourcePk> {

    /**
     * 给权限分配资源
     *
     * @param rolePermissionPkList
     * @return
     */
    int saveBatch(List<SysPermissionResourcePk> rolePermissionPkList);

    /**
     * 查询权限已拥有的资源信息
     *
     * @param po
     * @return
     */
    List<SysPermissionResourcePk> selectPermissionHaveResource(SysPermissionResourcePk po);

}