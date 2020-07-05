package com.impl;
import com.mapper.dormMapper;
import com.mapper.errorMapper;
import com.mapper.itemmapper;
import com.mapper.mapperOne;
import com.pojo.*;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class itemImpl
{
 private static final  int emperature_THRESHOLD=30;
 private static final double shuiwei_THRESHOLD=2;
    @Autowired
    private itemmapper itemmapperOne;
       @Autowired
       private com.mapper.mapperOne mapperone;

       @Autowired
       private com.mapper.errorMapper errormapper;
@Autowired
private com.mapper.dormMapper dormMapper;


    public Map<String,Object> getStatus()
    {

        Map<String,Object> map=new HashMap<>();

        item itemOne=itemmapperOne.selectByPrimaryKey();



        if(itemOne!=null)
        {
            if(Double.parseDouble(itemOne.getItemShuiwei())>=shuiwei_THRESHOLD)
            {
                String s= "  复旦二F202 可能发生漏水！ 当前水位为"+itemOne.getItemShuiwei()+"  验证码：2500  ";

                dorm dorm = new dorm();
                dorm.setDormBelongto(itemOne.getItemId());
                dorm.setDormMessgae(s);
                dorm.setDormGmtcreate(String.valueOf(System.currentTimeMillis()).substring(0,10));

                dormMapper.insertDorm(dorm);
                error error = new error();
                error.setErrorBelongto(dorm.getDormBelongto());
                error.setErrorDorm(dorm.getDormId());


                errormapper.insertError(error);
                map.put("ycu_error", 1);
                map.put("ycu_message",itemOne.getItemHumidity()+","+itemOne.getItemEmperature()+","+itemOne.getIetmPotency()+","+itemOne.getItemShuiwei()+","+itemOne.getItemYudi()+","+itemOne.getItemMen()+","+itemOne.getItemDeng());

                ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "103343", "4ae28a90-d1ed-4963-ba94-6d9c4cf9f1e2");
                List<user> list=mapperone.getAllusers(1);
                list.stream().forEach((user userOne)->{
                    try {
                        String result = client.send(userOne.getUserTelephone(),s,"dfee_dfdw_xdfd_dfdfd");
                        System.out.println(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            else if(Double.parseDouble(itemOne.getItemEmperature())>=emperature_THRESHOLD)
            {

                String s= "  复旦二F202宿舍温度异常  可能发生火灾了！当前温度为"+itemOne.getItemEmperature()+"°C  验证码：2500  ";

                dorm dorm = new dorm();
                dorm.setDormBelongto(itemOne.getItemId());
                dorm.setDormGmtcreate(String.valueOf(System.currentTimeMillis()).substring(0,10));
                dorm.setDormMessgae(s);
                dormMapper.insertDorm(dorm);
                error error = new error();
                error.setErrorDorm(dorm.getDormId());
                error.setErrorBelongto(dorm.getDormBelongto());
                errormapper.insertError(error);
                map.put("ycu_error", 1);
                map.put("ycu_message",itemOne.getItemHumidity()+","+itemOne.getItemEmperature()+","+itemOne.getIetmPotency()+","+itemOne.getItemShuiwei()+","+itemOne.getItemYudi()+","+itemOne.getItemMen()+","+itemOne.getItemDeng());

                                ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "103343", "4ae28a90-d1ed-4963-ba94-6d9c4cf9f1e2");
                List<user> list=mapperone.getAllusers(1);
                    list.stream().forEach((user userOne)->{
                        try {
                            String result = client.send(userOne.getUserTelephone(),s,"dfee_dfdw_xdfd_dfdfd");
                            System.out.println(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                });
            }
            else{
            map.put("ycu_error", 0);
                map.put("ycu_message",itemOne.getItemHumidity()+","+itemOne.getItemEmperature()+","+itemOne.getIetmPotency()+","+itemOne.getItemShuiwei()+","+itemOne.getItemYudi()+","+itemOne.getItemMen()+","+itemOne.getItemDeng());
        }
        }
        else
        {
            map.put("ycu_error", 1);
            map.put("ycu_message", "服务器连接失败！");
        }
        return  map;


    }
}
