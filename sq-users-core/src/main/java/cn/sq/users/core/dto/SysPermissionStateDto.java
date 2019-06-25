package cn.sq.users.core.dto;

/**
 * 方便权限--->启用与禁用等操作
 */
public class SysPermissionStateDto{

    private Integer id;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}