package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysButton;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SysButtonListVo {

    private Integer id;

    private String name;

    private Integer menuId;

    private String requestType;

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

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    //转换Po-->Vo
    public static SysButtonListVo buildSysButton(SysButton sysButton){
        SysButtonListVo vo = new SysButtonListVo();
        BeanUtils.copyProperties(sysButton,vo);
        vo.setId(sysButton.getId());
        return vo;
    }

    //转List<Po>-->List<Vo>
    public static List<SysButtonListVo> buildSysButtonVoList(List<SysButton> sysButtons){
        List<SysButtonListVo> sysButtonVoList = Lists.transform(sysButtons, new Function<SysButton, SysButtonListVo>() {
            @Override
            public SysButtonListVo apply(SysButton sysButton) {
                return buildSysButton(sysButton);
            }
        });
        return sysButtonVoList;
    }

}