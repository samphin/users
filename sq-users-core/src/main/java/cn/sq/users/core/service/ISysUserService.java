package cn.sq.users.core.service;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysSimpleRoleVo;
import cn.sq.users.core.vo.SysUserListVo;
import cn.sq.users.core.vo.SysUserVo;

import java.util.List;

public interface ISysUserService extends IBaseService<Integer, SysUserDto> {

    /**
     * 分页查询用户列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysUserListVo> queryPageList(SysUserQueryDto dto);

    /**
     * 查询用户详情
     *
     * @param id
     * @return
     */
    SysUserVo queryOne(Integer id);

    /**
     * 查询用户列表信息
     *
     * @param dto
     * @return
     */
    List<SysUserListVo> queryList(SysUserQueryDto dto);


    /**
     * 保存用户绑定的角色信息
     *
     * @param dto
     * @return
     */
    boolean bindingRoles(SysUserRolePkDto dto);

    /**
     * 查询用户已拥有的角色信息
     *
     * @param userId
     * @return
     */
    List<SysSimpleRoleVo> queryUserHaveRoles(Integer userId);

    /**
     * 查询用户未拥有的角色信息
     *
     * @param dto
     * @return
     */
    List<SysSimpleRoleVo> queryUserHaveNoRoles(SysUserRolePkQueryDto dto);

    /**
     * 修改用户信息
     *
     * @param updateDto
     * @return
     */
    boolean update(SysUserUpdateDto updateDto);

    /**
     * 修改用户密码
     *
     * @param passwordDto
     * @return
     */
    boolean updatePassword(SysUserPasswordDto passwordDto);

    /**
     * 修改用户状态
     *
     * @param stateDto
     * @return
     */
    boolean updateState(SysUserStateDto stateDto);

}
