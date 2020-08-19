package com.xiaoxiang.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    //创建基本线程池
    final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(50));


    //创建及执行
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task(index);
                // 周期性执行，每5秒执行一次

                scheduledExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

            }
        });
    }

    class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            Log.e("ThreadMainActivity", "index = " + i + ", endTime = " + new Date());
            i++;

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e("ThreadMainActivity", "index = " + i + ", endTime = " + new Date());*/
        }
    }

}
