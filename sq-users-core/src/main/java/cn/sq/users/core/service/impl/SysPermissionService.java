package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.mapper.SysPermissionMapper;
import cn.sq.users.core.mapper.SysPermissionResourcePkMapper;
import cn.sq.users.core.po.SysPermission;
import cn.sq.users.core.po.SysPermissionResourcePk;
import cn.sq.users.core.service.ISysPermissionService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysPermissionListVo;
import cn.sq.users.core.vo.SysPermissionResourceVo;
import cn.sq.users.core.vo.SysPermissionVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPermissionService implements ISysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private SysPermissionResourcePkMapper sysPermissionResourcePkMapper;

    @Override
    public PageBean<SysPermissionListVo> queryPageList(SysPermissionQueryDto dto) {

        PageHelper.startPage(dto.getPageNum(),dto.getPageSize());

        SysPermission po = new SysPermission().buildSysPermission(dto);

        List<SysPermission> poList = this.sysPermissionMapper.select(po);

        List<SysPermissionListVo> voList = SysPermissionListVo.buildVoList(poList);

        PageBean<SysPermissionListVo> pageBean = new PageBean<>(voList);

        return pageBean;
    }

    @Override
    public List<SysPermissionListVo> queryList(SysPermissionQueryDto dto) {

        SysPermission po = new SysPermission().buildSysPermission(dto);

        List<SysPermission> poList = this.sysPermissionMapper.select(po);

        List<SysPermissionListVo> voList = SysPermissionListVo.buildVoList(poList);

        return voList;
    }

    @Override
    public SysPermissionVo queryOne(Integer id) {

        SysPermission po = this.sysPermissionMapper.selectByPrimaryKey(id);

        SysPermissionVo vo = SysPermissionVo.buildVo(po);

        return vo;
    }

    @Override
    public boolean updateState(SysPermissionStateDto dto) {
        SysPermission po = new SysPermission().buildSysPermission(dto);
        return this.sysPermissionMapper.updateState(po)>0;
    }

    @Override
    public boolean save(SysPermissionDto dto) {
        SysPermission po = new SysPermission().buildSysPermission(dto);
        return this.sysPermissionMapper.insertSelective(po)>0;
    }

    @Override
    public boolean update(SysPermissionUpdateDto dto) {
        SysPermission po = new SysPermission().buildSysPermission(dto);
        return this.sysPermissionMapper.updateByPrimaryKeyAndVersionSelective(po)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return sysPermissionMapper.deleteByPrimaryKey(id)>0;
    }


    /*************************权限分配资源***********************************/
    @Override
    public boolean bindingResource(SysPermissionResourcePkDto dto) {
        //保存前先清空权限对应的资源类型的旧数据
        SysPermissionResourcePk po = new SysPermissionResourcePk().buildPo(dto);

        this.sysPermissionResourcePkMapper.delete(po);

        //保存权限最新绑定的资源信息

        List<SysPermissionResourcePk> poList = new SysPermissionResourcePk().buildPoList(dto);

        return this.sysPermissionResourcePkMapper.saveBatch(poList)>0;
    }

    @Override
    public List<SysPermissionResourceVo> queryPermissionHaveResource(SysPermissionResourcePkDto dto) {

        SysPermissionResourcePk po = new SysPermissionResourcePk().buildPo(dto);

        List<SysPermissionResourcePk> poList = sysPermissionResourcePkMapper.selectPermissionHaveResource(po);

        List<SysPermissionResourceVo> voList = SysPermissionResourceVo.buildVoList(poList);

        return voList;
    }
}
