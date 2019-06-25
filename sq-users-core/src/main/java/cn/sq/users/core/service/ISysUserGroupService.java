package cn.sq.users.core.service;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysSimpleRoleVo;
import cn.sq.users.core.vo.SysUserGroupPkVo;
import cn.sq.users.core.vo.SysUserGroupVo;

import java.util.List;

public interface ISysUserGroupService extends IBaseService<Integer, SysUserGroupDto> {

    /**
     * 分页查询用户组列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysUserGroupVo> queryPageList(SysUserGroupQueryDto dto);

    /**
     * 查询单个用户组信息
     *
     * @param id
     * @return
     */
    SysUserGroupVo queryOne(Integer id);

    /**
     * 修改用户组信息
     *
     * @param updateDto
     * @return
     */
    boolean update(SysUserGroupUpdateDto updateDto);


    /**
     * 给用户组设置角色
     *
     * @param dto
     * @return
     */
    boolean bindingRoles(SysGroupRolePkDto dto);

    /**
     * 查询用户组已拥有的角色信息
     *
     * @param userGroupId
     * @return
     */
    List<SysSimpleRoleVo> queryUserGroupHaveRoles(Integer userGroupId);


    /**
     * 查询用户组未拥有的角色信息
     *
     * @param dto
     * @return
     */
    List<SysSimpleRoleVo> queryUserGroupHaveNoRoles(SysUserGroupRolePkQueryDto dto);


    /**************************************************************/
    /**
     * 根据组ID，查询当前组下面所有用户信息
     *
     * @param groupId
     * @return
     */
    List<SysUserGroupPkVo> queryGroupHaveUsers(Integer groupId);

    /**
     * 根据组ID，用户姓名，查询当前组下面所有用户信息
     *
     * @param dto
     * @return
     */
    PageBean<SysUserGroupPkVo> queryGroupHaveNoUsers(SysUserGroupPkQueryDto dto);

    /**
     * 向用户组批量保存用户
     *
     * @param dto
     * @return
     */
    boolean saveBatch(SysUserGroupPkDto dto);

    /**
     * 解散用户组
     *
     * @param groupId
     * @return
     */
    boolean dismissGroup(Integer groupId);
}
