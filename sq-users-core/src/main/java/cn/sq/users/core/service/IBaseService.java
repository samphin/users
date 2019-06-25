package cn.sq.users.core.service;

/**
 * 定义常用CRUD方法
 */
public interface IBaseService<PK, D> {

    /**
     * 保存
     *
     * @param dto
     * @return
     */
    boolean save(D dto);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean delete(PK id);

}
