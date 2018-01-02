package com.nowcoder.DAO;

        import com.nowcoder.model.User;
        import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDAO {
    final String TABLE_NAME = "user";
    final String SELECT_FIELDS = " id, name , password , salt , head_url ";
    final String INSERT_FIELDS = " name , password , salt , head_url ";

    @Insert({"INSERT INTO",  TABLE_NAME , "(", INSERT_FIELDS, ") VALUE(#{name}, #{password} , #{salt} , #{head_url})" })
    int addUser(User user);

    @Select({"SELECT FROM", TABLE_NAME , "WHERE id = #{id}"})
    User selectById(int id);

    @Update({"Update",  TABLE_NAME , "set password = #{password} where id = #{id})" })
    User updatePassword(User user);

    @Delete({"DELETE from", TABLE_NAME , "where id = #{id}"})
    int deleteUserById(int id);


}
