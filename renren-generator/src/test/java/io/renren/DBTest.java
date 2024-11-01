package io.renren;

import io.renren.service.SysGeneratorService;
import io.renren.utils.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {

    @Autowired
    SysGeneratorService sysGeneratorService;

    @Test
    public void connectTest() {
        Map<String, Object> params = new HashMap<>();
        params.put("page", "1");   // 假设当前页码为1
        params.put("limit", "10"); // 假设每页显示10条数据

        Query query = new Query(params);

        sysGeneratorService.queryList(query);
    }
}
