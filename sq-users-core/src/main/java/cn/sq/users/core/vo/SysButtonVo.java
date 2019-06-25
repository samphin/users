package cn.sq.users.core.vo;

import cn.sq.users.core.dto.SysButtonDto;
import cn.sq.users.core.po.BasePo;
import cn.sq.users.core.po.SysButton;
import cn.sq.users.core.util.Data2LongSerizlizer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

public class SysButtonVo{

    private Integer id;

    private String name;

    private String icon;

    private Integer menuId;

    private Boolean enabled;

    private String requestType;

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
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    //转换Po-->Vo
    public static SysButtonVo buildSysButton(SysButton sysButton){
        SysButtonVo vo = new SysButtonVo();
        BeanUtils.copyProperties(sysButton,vo);
        vo.setId(sysButton.getId());
        vo.setVersion(sysButton.getVersion());
        return vo;
    }

    //转List<Po>-->List<Vo>
    public static List<SysButtonVo> buildSysButtonVoList(List<SysButton> sysButtons){
        List<SysButtonVo> sysButtonVoList = Lists.transform(sysButtons, new Function<SysButton, SysButtonVo>() {
            @Override
            public SysButtonVo apply(SysButton sysButton) {
                return buildSysButton(sysButton);
            }
        });
        return sysButtonVoList;
    }

}