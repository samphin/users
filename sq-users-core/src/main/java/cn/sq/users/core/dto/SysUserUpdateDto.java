package cn.sq.users.core.dto;

public class SysUserUpdateDto extends SysUserDto {

    private Integer id;

    private int version = 1;//默认数据版本号为1

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
