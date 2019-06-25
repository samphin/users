package cn.sq.users.core.service;

import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.dto.SysMenuQueryDto;
import cn.sq.users.core.dto.SysMenuUpdateDto;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysButtonListVo;
import cn.sq.users.core.vo.SysMenuListVo;
import cn.sq.users.core.vo.SysMenuVo;

import java.util.List;

public interface ISysMenuService extends IBaseService<Integer, SysMenuDto> {

    /**
     * 分页查询菜单列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysMenuListVo> queryPageList(SysMenuQueryDto dto);

    /**
     * 查询菜单详情
     *
     * @param id
     * @return
     */
    SysMenuVo queryOne(Integer id);

    /**
     * 一次性加载菜单信息
     *
     * @return
     */
    List<SysMenuListVo> queryList();

    /**
     * 查询菜单拥有的按钮信息
     *
     * @param id
     * @return
     */
    List<SysButtonListVo> queryMenuButtons(Integer id);

    /**
     * 修改菜单信息
     *
     * @param updateDto
     * @return
     */
    boolean update(SysMenuUpdateDto updateDto);

}
