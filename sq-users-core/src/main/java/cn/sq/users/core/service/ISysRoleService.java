package cn.sq.users.core.service;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysPermissionListVo;
import cn.sq.users.core.vo.SysRoleVo;

import java.util.List;

public interface ISysRoleService extends IBaseService<Integer, SysRoleDto> {

    /**
     * 分页查询角色列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysRoleVo> queryPageList(SysRoleQueryDto dto);

    /**
     * 查询角色详情
     *
     * @param id
     * @return
     */
    SysRoleVo queryOne(Integer id);

    /**
     * 修改角色信息
     *
     * @param updateDto
     * @return
     */
    boolean update(SysRoleUpdateDto updateDto);

    /**
     * 查询角色列表信息
     *
     * @param dto
     * @return
     */
    List<SysRoleVo> queryList(SysRoleQueryDto dto);


    /**
     * 保存用户绑定的角色信息
     *
     * @param dto
     * @return
     */
    boolean bindingPermissions(SysRolePermissionPkDto dto);

    /**
     * 查询角色拥有的权限
     *
     * @param roleId
     * @return
     */
    List<SysPermissionListVo> queryRoleHavePermissions(Integer roleId);

    /**
     * 查询角色未拥有的权限
     *
     * @param dto
     * @return
     */
    List<SysPermissionListVo> queryRoleHaveNoPermissions(SysRolePermissionPkQueryDto dto);

}
