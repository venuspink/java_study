package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamTest {


    public static void main(String[] args) {
        groupByTest();
    }


    public static void groupByTest(){
        BaseBallTeamVO vo1 = new BaseBallTeamVO();
        vo1.setAge(30L);
        vo1.setTeam("HH");
        vo1.setName("김태균");
        BaseBallTeamVO vo2 = new BaseBallTeamVO();
        vo2.setAge(28L);
        vo2.setTeam("HH");
        vo2.setName("노시환");
        BaseBallTeamVO vo3 = new BaseBallTeamVO();
        vo3.setAge(30L);
        vo3.setTeam("HH");
        vo3.setName("이범호");
        BaseBallTeamVO vo4 = new BaseBallTeamVO();
        vo4.setAge(35L);
        vo4.setTeam("LG");
        vo4.setName("채은성");
        BaseBallTeamVO vo5 = new BaseBallTeamVO();
        vo5.setAge(35L);
        vo5.setTeam("LG");
        vo5.setName("봉중근");

        List<BaseBallTeamVO> list = new ArrayList<>();
        list.add(vo1);
        list.add(vo2);
        list.add(vo3);
        list.add(vo4);
        list.add(vo5);

//        Map<String, Map<Long, List<BaseBallTeamVO>>> resultMap =  list.stream().collect(groupingBy(BaseBallTeamVO::getTeam, groupingBy(BaseBallTeamVO::getAge)));
        Map<BaseBallTuple, List<BaseBallTeamVO>> resultMap = list.stream().collect(Collectors.groupingBy(o -> new BaseBallTuple(o.getTeam(), o.getAge())));

        System.out.println(resultMap);
    }
}
