package cn.sq.users.core.service;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysPermissionListVo;
import cn.sq.users.core.vo.SysPermissionResourceVo;
import cn.sq.users.core.vo.SysPermissionVo;

import java.util.List;

public interface ISysPermissionService extends IBaseService<Integer, SysPermissionDto> {

    /**
     * 分页查询权限列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysPermissionListVo> queryPageList(SysPermissionQueryDto dto);

    /**
     * 查询权限列表信息
     *
     * @param dto
     * @return
     */
    List<SysPermissionListVo> queryList(SysPermissionQueryDto dto);

    /**
     * 查询权限详情
     *
     * @param id
     * @return
     */
    SysPermissionVo queryOne(Integer id);

    /**
     * 用户快速启用、禁用权限
     *
     * @param dto
     * @return
     */
    boolean updateState(SysPermissionStateDto dto);

    /**
     * 修改权限信息
     *
     * @param updateDto
     * @return
     */
    boolean update(SysPermissionUpdateDto updateDto);


    /*************************权限分配资源***********************************/

    boolean bindingResource(SysPermissionResourcePkDto dto);

    /**
     * 查询权限拥有的资源信息
     *
     * @param dto
     * @return
     */
    List<SysPermissionResourceVo> queryPermissionHaveResource(SysPermissionResourcePkDto dto);
}
