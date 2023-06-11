package cn.lsc.spring_mybatis.demo.service;

import cn.lsc.spring_mybatis.demo.pojo.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class TestService {

    private final Validator validator;

    @Autowired
    public TestService(Validator validator) {
        this.validator = validator;
    }

    public Map<String,Object> getTestMap(@Valid TestDao dao){
        Set<ConstraintViolation<TestDao>> violations = validator.validate(dao);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name",dao.getName());
        stringStringHashMap.put("text",dao.getText());
        stringStringHashMap.put("Time",new Date().toString());
        return stringStringHashMap;
    };
}
