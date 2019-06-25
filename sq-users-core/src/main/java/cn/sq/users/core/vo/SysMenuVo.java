package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysMenu;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SysMenuVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private String url;

    private String icon;

    private Integer sort;

    private Integer level;

    private Boolean leaf;

    private Boolean enabled;

    private String description;

    private Integer version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static SysMenuVo buildSysMenu(SysMenu sysMenu){
        SysMenuVo vo = new SysMenuVo();
        BeanUtils.copyProperties(sysMenu,vo);
        vo.setId(sysMenu.getId());
        return vo;
    }
}