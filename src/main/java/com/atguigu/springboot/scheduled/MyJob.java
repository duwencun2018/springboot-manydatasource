package com.atguigu.springboot.scheduled;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

@Component
@JobHandler("myJob")
public class MyJob extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("打印控制台:" + System.currentTimeMillis());
        }
        return ReturnT.SUCCESS;
    }
}
