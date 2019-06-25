package cn.sq.users.core.service.impl;

import cn.sq.users.core.dto.*;
import cn.sq.users.core.mapper.*;
import cn.sq.users.core.po.*;
import cn.sq.users.core.service.ISysUserGroupService;
import cn.sq.users.core.vo.PageBean;
import cn.sq.users.core.vo.SysSimpleRoleVo;
import cn.sq.users.core.vo.SysUserGroupPkVo;
import cn.sq.users.core.vo.SysUserGroupVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserGroupService implements ISysUserGroupService {

    @Resource
    private SysUserGroupMapper sysGroupMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserGroupPkMapper sysUserGroupPkMapper;

    @Resource
    private SysGroupRolePkMapper sysGroupRolePkMapper;

    @Resource
    private SysRoleMapper roleMapper;

    public boolean save(SysUserGroupDto dto) {
        SysUserGroup sysGroup = new SysUserGroup().buildSysGroup(dto);
        boolean bl = sysGroupMapper.insertSelective(sysGroup) > 0;
        return bl;
    }

    public boolean update(SysUserGroupUpdateDto dto) {

        SysUserGroup sysGroup = new SysUserGroup().buildSysGroup(dto);

        return sysGroupMapper.updateByPrimaryKeyAndVersionSelective(sysGroup) > 0;
    }

    public boolean delete(Integer groupId) {
        return sysGroupMapper.deleteByPrimaryKey(groupId) > 0;
    }

    /**
     * 分页查询用户组列表信息
     *
     * @param dto
     * @return
     */
    @Override
    public PageBean<SysUserGroupVo> queryPageList(SysUserGroupQueryDto dto) {

        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        SysUserGroup po = new SysUserGroup().buildSysGroup(dto);

        List<SysUserGroup> poList = this.sysGroupMapper.selectPageList(po);

        List<SysUserGroupVo> voList = SysUserGroupVo.buildVoList(poList);

        return new PageBean<SysUserGroupVo>(voList);
    }

    /**
     * 查询单个用户组信息
     *
     * @param id
     * @return
     */
    @Override
    public SysUserGroupVo queryOne(Integer id) {

        SysUserGroup group = this.sysGroupMapper.selectByPrimaryKey(id);

        return SysUserGroupVo.buildVo(group);
    }

    @Override
    public boolean bindingRoles(SysGroupRolePkDto dto) {

        List<SysGroupRolePk> sysGroupRolePkList = new SysGroupRolePk().buildSysGroupRole(dto);

        //根据用户ID，先清除之前绑定的关联信息
        SysGroupRolePk sysGroupRolePk = new SysGroupRolePk();
        sysGroupRolePk.setGroupId(dto.getGroupId());
        sysGroupRolePkMapper.delete(sysGroupRolePk);

        //保存组与角色关联信息
        return this.sysGroupRolePkMapper.saveBatch(sysGroupRolePkList) > 0;
    }

    /**
     * 查询组角色：已拥有的+未拥有的
     *
     * @param userGroupId
     * @return
     */
    @Override
    public List<SysSimpleRoleVo> queryUserGroupHaveRoles(Integer userGroupId) {
        List<SysRole> roleList = this.roleMapper.selectUserGroupHaveRoles(userGroupId);

        List<SysSimpleRoleVo> sysGroupRoleVoList = SysSimpleRoleVo.buildSysGroupRoleVoList(roleList);

        return sysGroupRoleVoList;
    }

    /**
     * 查询组未拥有的角色
     *
     * @param dto
     * @return
     */
    @Override
    public List<SysSimpleRoleVo> queryUserGroupHaveNoRoles(SysUserGroupRolePkQueryDto dto) {
        List<SysRole> roleList = this.roleMapper.selectUserGroupHaveNoRoles(dto.getGroupId(), dto.getName());

        List<SysSimpleRoleVo> sysGroupRoleVoList = SysSimpleRoleVo.buildSysGroupRoleVoList(roleList);

        return sysGroupRoleVoList;
    }

    /*********************************************************/
    @Override
    public List<SysUserGroupPkVo> queryGroupHaveUsers(Integer groupId) {

        List<SysUser> poList = this.sysUserMapper.selectGroupHaveUsers(groupId);

        List<SysUserGroupPkVo> voList = SysUserGroupPkVo.buildSysUserGroupVoList(poList);

        return voList;
    }

    @Override
    public PageBean<SysUserGroupPkVo> queryGroupHaveNoUsers(SysUserGroupPkQueryDto dto) {

        //开启分页
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());

        //返回查询结果
        List<SysUser> poList = this.sysUserMapper.selectGroupHaveNoUsers(dto.getGroupId(), dto.getRealName());

        //将poList转换成voList
        List<SysUserGroupPkVo> voList = SysUserGroupPkVo.buildSysUserGroupVoList(poList);

        //封装查询结果到PageBean
        PageBean<SysUserGroupPkVo> pageBean = new PageBean<SysUserGroupPkVo>(voList);

        return pageBean;
    }

    @Override
    public boolean  saveBatch(SysUserGroupPkDto dto) {

        //保存前，先清空组，然后将最新的用户保存进去。防止出现重复数据。
        dismissGroup(dto.getGroupId());

        List<SysUserGroupPk> userGroups = new SysUserGroupPk().buildSysUserGroup(dto);

        boolean res = sysUserGroupPkMapper.saveBatch(userGroups) > 0;

        return res;
    }

    @Override
    public boolean dismissGroup(Integer groupId) {

        boolean res = sysUserGroupPkMapper.dismissGroup(groupId) > 0;
        return res;
    }
}
