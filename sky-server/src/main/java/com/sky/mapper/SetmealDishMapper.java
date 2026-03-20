package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsDishIds(List<Long> dishIds);

    /**
     * 插入套餐及其与套餐相关联的餐品
     * @param setmealDishList
     */

    void insertBatch(List<SetmealDish> setmealDishList);

    /**
     * 根据套餐id查询相关菜品
     * @param id
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id=#{id}")
    List<SetmealDish> selectBySetmealId(Long id);

    /**
     * 根据套餐id删除对应菜品
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void delete(Long setmealId);

    /**
     * 根据套餐id批量删除对应菜品
     * @param setmealIds
     */
    void deleteByIds(List<Long> setmealIds);
}
