package cn.sq.users.core.service;

import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.dto.SysButtonQueryDto;
import cn.sq.users.core.dto.SysButtonUpdateDto;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysButtonVo;

import java.util.List;

public interface ISysButtonService extends IBaseService<Integer, SysButtonDto> {

    /**
     * 分页查询按钮列表信息
     *
     * @param dto
     * @return
     */
    PageBean<SysButtonVo> queryPageList(SysButtonQueryDto dto);

    /**
     * 查询按钮详情
     *
     * @param id
     * @return
     */
    SysButtonVo queryOne(Integer id);

    /**
     * 查询按钮列表信息
     *
     * @param dto
     * @return
     */
    List<SysButtonVo> queryList(SysButtonQueryDto dto);

    /**
     * 修改按钮信息
     * @param updateDto
     * @return
     */
    boolean update(SysButtonUpdateDto updateDto);

}
