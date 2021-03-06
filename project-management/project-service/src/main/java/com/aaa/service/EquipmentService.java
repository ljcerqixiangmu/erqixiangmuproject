package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.EquipmentMapper;
import com.aaa.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService extends BaseService<Equipment> {
    @Autowired
    private EquipmentMapper equipmentMapper;

    //获取仪器信息
    public List<Equipment> selectEquipment(Long userId){

        try {
            //判断userID是否为空
            if (!"".equals(userId)){
                //不为空就根据userid 查询
                List<Equipment> equipmentList = equipmentMapper.selectEquipment(userId);
                //判断查询结果是否为空
                if (null != equipmentList && !"".equals(equipmentList)){
                    //不为空返回查询结果
                    return equipmentList;
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
