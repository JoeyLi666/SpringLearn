package cn.lsc.springboot_mybatis_plus;

import cn.lsc.springboot_mybatis_plus.dao.ClubPo;
import cn.lsc.springboot_mybatis_plus.extension.impl.ClubPoServiceImpl;
import cn.lsc.springboot_mybatis_plus.mapper.ClubMapper;
import cn.lsc.springboot_mybatis_plus.utlis.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    public void testSelect() {
//        System.out.println("--------selectAll method test-------");
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);
//    }
//
//    @Test
//    public void testInsert() {
//        User user = new User();
//        user.setName("小李");
//        user.setAge(22);
//        user.setEmail("111111115@qq.com");
//        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
//        System.out.println(insert);//受影响行数
//        System.out.println(user);//id会自动回填
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//    }
//
//    @Test
//    public void testUpdate() {
//        User user = new User();
//        user.setId(5L);
//        user.setName("id:5,修改过后");
//
//        int i = userMapper.updateById(user);
//        System.out.println(i);
//    }
//
//    @Test
//    void contextLoads() {
//    }

    @Autowired
    ClubMapper clubMapper;
    String id = "fbef9d1c-db25-4fd2-92fb-badb7b169d73";

    @Test
    public void testInsert() {
        QueryWrapper<ClubPo> queryWrapper = new QueryWrapper();
        queryWrapper.ge("id", id);
        int delete = clubMapper.delete(queryWrapper);
        if (delete == 1) {
            System.out.println(delete);
        }
        ClubPo clubPo = new ClubPo();
        clubPo.setClubId(id);
        clubPo.setName("Test1");
        clubPo.setMoney(100D);
        clubPo.setNickName("test1");
        clubPo.setBirthday(DateUtil.formatByDateTimeFormatter(new Date()));

        int insert = clubMapper.upsert(clubPo);
        if (insert == 1) {
            ClubPo clubPo1 = clubMapper.selectById(id);
            System.out.println(clubPo1.toString());
        }
    }

    @Test
    public void testUpdate() {

        ClubPo clubPo = new ClubPo();
        clubPo.setClubId(id);
        clubPo.setName("Test1_update");
        clubPo.setMoney(99D);
        clubPo.setNickName("test1");

        int update = clubMapper.updateById(clubPo);
        if (update == 1) {
            ClubPo clubPo1 = clubMapper.selectById(id);
            System.out.println(clubPo1.toString());
        }
    }

    @Test
    public void testMyServiceImpl() {
        String[] nameArr = {"xiaoming", "xiaohong", "xiaolan", "xiaohua", "xiaomei"};
        String[] nickArr = {"Tom", "Tony", "Lily", "Marry", "Jerry"};
        ArrayList<ClubPo> clubPos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ClubPo clubPo = new ClubPo();
//            clubPo.setId(UUID.randomUUID().toString());
            clubPo.setClubId(i + "");
            clubPo.setName(nameArr[i]);
            clubPo.setMoney(10.0 * (i + 1));
            clubPo.setNickName(nickArr[i]);
            clubPo.setBirthday(DateUtil.formatByDateTimeFormatter(new Date()));
            clubPos.add(clubPo);
        }
        ClubPoServiceImpl clubPoService = new ClubPoServiceImpl();
        clubPoService.saveOrUpdateBatch(clubPos,2);
    }
}
