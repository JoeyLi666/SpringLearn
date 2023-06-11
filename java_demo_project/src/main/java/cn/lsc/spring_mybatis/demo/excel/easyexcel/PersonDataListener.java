package cn.lsc.spring_mybatis.demo.excel.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

public class PersonDataListener extends AnalysisEventListener<Person> {
    private List<Person> personList = new ArrayList<>();

    @Override
    public void invoke(Person person, AnalysisContext analysisContext) {
        personList.add(person);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 在这里可以处理读取到的所有数据
    }

    public List<Person> getPersonList() {
        return personList;
    }
}
