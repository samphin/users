package cn.sq.users.core.vo;

import cn.sq.users.core.po.SysUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserListVo {

    private Integer id;

    private String username;

    private String realName;

    private Integer sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String telephone;

    private String idCard;

    private Integer state;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public static List<SysUserListVo> buildSysUserVoList(List<SysUser> sysUserList){
        if(CollectionUtils.isEmpty(sysUserList)){
            return null;
        }
        List<SysUserListVo> sysUserVoList = Lists.transform(sysUserList,new Function<SysUser,SysUserListVo>(){
            @Override
            public SysUserListVo apply(@Nullable SysUser sysUser) {
                SysUserListVo vo = new SysUserListVo();
                BeanUtils.copyProperties(sysUser,vo);
                vo.setId(sysUser.getId());
                return vo;
            }
        });
        return sysUserVoList;
    }
}
