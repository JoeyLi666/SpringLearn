package cn.lsc.spring_mybatis.demo.excel.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.List;

public class ExcelReadExample {
    public static void main(String[] args) {
        String fileName = "example.xlsx"; // Excel 文件路径
        PersonDataListener personDataListener = new PersonDataListener();

        EasyExcel.read(fileName, Person.class, personDataListener).sheet().doRead();

        List<Person> personList = personDataListener.getPersonList();
        for (Person person : personList) {
            System.out.println("Name: " + person.getName() + ", Age: " + person.getAge() + ", Email: " + person.getEmail());
        }
    }
}
