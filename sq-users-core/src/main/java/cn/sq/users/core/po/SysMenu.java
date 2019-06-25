package cn.sq.users.core.po;

import cn.sq.users.core.dto.SysMenuDto;
import cn.sq.users.core.dto.SysMenuQueryDto;
import cn.sq.users.core.dto.SysMenuUpdateDto;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SysMenu extends BaseOperatorPo<Integer> {

    private Integer parentId;

    private String name;

    private String url;

    private String icon;

    private Integer sort;

    private Integer level;

    private Boolean leaf;

    private Boolean enabled;

    private String description;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    //保存：转换Dto-->Po
    public SysMenu buildSysMenu(SysMenuDto dto) {
        BeanUtils.copyProperties(dto, this);
        this.setCreateTime(new Date());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //修改：转换Dto-->Po
    public SysMenu buildSysMenu(SysMenuUpdateDto dto) {
        BeanUtils.copyProperties(dto, this);
        this.setId(dto.getId());
        this.setLastUpdateTime(new Date());
        return this;
    }

    //转换Dto-->Po
    public SysMenu buildSysMenu(SysMenuQueryDto sysMenuQueryDto) {
        BeanUtils.copyProperties(sysMenuQueryDto, this);
        return this;
    }
}