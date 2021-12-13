package com.example.springbootlogback.mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TestMappers {

    @Select("select * from mb_policy_info")
    List<Map> get();

}
