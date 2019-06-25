package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysUserGroup;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class SysUserGroupVo {

    private Integer id;

    private String name;

    private String description;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 将po对象转换成vo对象
     *
     * @param sysGroup
     * @return
     */
    public static SysUserGroupVo buildVo(SysUserGroup sysGroup) {
        SysUserGroupVo vo = new SysUserGroupVo();
        BeanUtils.copyProperties(sysGroup, vo);
        vo.setId(sysGroup.getId());
        return vo;
    }

    /**
     * 将po集合转换成vo集合
     *
     * @param sysGroupList
     * @return
     */
    public static List<SysUserGroupVo> buildVoList(List<SysUserGroup> sysGroupList) {
        if (CollectionUtils.isEmpty(sysGroupList)) {
            return null;
        }
        List<SysUserGroupVo> sysUserVoList = Lists.transform(sysGroupList, new Function<SysUserGroup, SysUserGroupVo>() {
            @Override
            public SysUserGroupVo apply(@Nullable SysUserGroup sysGroup) {
                return buildVo(sysGroup);
            }
        });
        return sysUserVoList;
    }
}
