package cn.sq.users.core.vo;

import java.util.List;

/**
 * 返回用户登录成功后的信息
 */
public class SysUserLoginSuccessVo {

    private Integer id;

    private String username;

    private String realName;

    private List<SysMenuListVo> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<SysMenuListVo> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenuListVo> menus) {
        this.menus = menus;
    }
}
