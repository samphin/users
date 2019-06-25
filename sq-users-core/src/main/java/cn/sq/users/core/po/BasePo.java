package cn.sq.users.core.po;


import javax.persistence.Id;
import java.io.Serializable;

public class BasePo<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -7141570524683041372L;

    @Id
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
