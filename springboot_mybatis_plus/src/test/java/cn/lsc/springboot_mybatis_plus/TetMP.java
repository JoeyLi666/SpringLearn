package cn.lsc.springboot_mybatis_plus;

import cn.lsc.springboot_mybatis_plus.dao.ClubPo;
import cn.lsc.springboot_mybatis_plus.mapper.ClubMapper;
import cn.lsc.springboot_mybatis_plus.utlis.DateUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

//import java.util.UUID;
//
@SpringBootTest
public class TetMP {
    private Logger logger = LoggerFactory.getLogger(TetMP.class);
//
    @Autowired
ClubMapper clubMapper;
//
    @Test
    public void test3() {
        String[] nameArr = {"xiaoming", "xiaohong", "xiaolan", "xiaohua", "xiaomei"};
        String[] nickArr = {"Tom", "Tony", "Lily", "Marry", "Jerry"};
        for (int i = 0; i < 5; i++) {
            ClubPo clubPo = new ClubPo();
//            clubPo.setId(UUID.randomUUID().toString());
            clubPo.setClubId(i + "");
            clubPo.setName(nameArr[i]);
            clubPo.setMoney(9999.0 * (i + 1));
            clubPo.setNickName(nickArr[i]);
            clubPo.setBirthday(DateUtil.formatByDateTimeFormatter(new Date()));
            clubMapper.insert(clubPo);
        }

//        ClubPo clubPo = clubMapper.selectById(1);
//        logger.info("按id查询:" + clubPo);
//
//        List<ClubPo> clubPos = clubMapper.selectBatchIds(Arrays.asList(1, 2, 3));
//        logger.info("按id批量查询:" + clubPos);

    }
//
//    @Test
//    public void test1() {
//        ClubPo clubPo = new ClubPo();
////            clubPo.setId(UUID.randomUUID().toString());
//        clubPo.setId("0");
//        clubPo.setName("xiaoming");
//        clubPo.setMoney(0.0);
//        clubPo.setNickName("Tom");
//        clubPo.setBirthday(new Date());
//        clubPo.setCreateTime(new Date());
//        clubPo.setUpdateTime(new Date());
//        clubMapper.upsert(clubPo);
//    }
//
//    @Test
//    public void test4() {
//        List<ClubPo> allUser = clubMapper.getAllUser();
//        System.out.println("result:");
//        for (ClubPo clubPo : allUser) {
//            System.out.println(clubPo.toString());
//        }
//    }
}
