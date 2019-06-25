package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.dto.SysButtonQueryDto;
import cn.sq.users.core.dto.SysButtonUpdateDto;
import cn.sq.users.core.mapper.SysButtonMapper;
import cn.sq.users.core.po.SysButton;
import cn.sq.users.core.service.ISysButtonService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysButtonVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysButtonService implements ISysButtonService {

    @Resource
    private SysButtonMapper sysButtonMapper;

    @Override
    public PageBean<SysButtonVo> queryPageList(SysButtonQueryDto dto) {

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        SysButton po = new SysButton().buildSysButton(dto);

        List<SysButton> poList = this.sysButtonMapper.selectPageList(po);

        List<SysButtonVo> voList = SysButtonVo.buildSysButtonVoList(poList);

        PageBean<SysButtonVo> pageBean = new PageBean<>(voList);

        return pageBean;
    }

    @Override
    public SysButtonVo queryOne(Integer id) {

        SysButton po = this.sysButtonMapper.selectByPrimaryKey(id);

        SysButtonVo vo = SysButtonVo.buildSysButton(po);

        return vo;
    }

    @Override
    public List<SysButtonVo> queryList(SysButtonQueryDto dto) {

        SysButton po = new SysButton().buildSysButton(dto);

        List<SysButton> poList = this.sysButtonMapper.select(po);

        List<SysButtonVo> voList = SysButtonVo.buildSysButtonVoList(poList);

        return voList;
    }

    @Override
    public boolean save(SysButtonDto dto) {
        SysButton po = new SysButton().buildSysButton(dto);
        return this.sysButtonMapper.insertSelective(po) > 0;
    }

    @Override
    public boolean update(SysButtonUpdateDto dto) {
        SysButton po = new SysButton().buildSysButton(dto);
        return this.sysButtonMapper.updateByPrimaryKeyAndVersionSelective(po) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return this.sysButtonMapper.deleteByPrimaryKey(id) > 0;
    }
}
