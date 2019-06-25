package cn.sq.users.core.dto;

/**
 * 用户角色查询对象
 */
public class SysUserRolePkQueryDto {

    private Integer userId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}