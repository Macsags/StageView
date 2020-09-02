package com.macsags.stageview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class TestHorizontalStageViewActivity extends AppCompatActivity {
    HorizontalStageView stageView;
   int [] a = new int[]{1,1,0,-1,-1,-1,-1,-1};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_horizontal);
        Button btn = findViewById(R.id.btn);
        stageView = findViewById(R.id.stage_view);

        stageView.OnDrawViewCallBack(new HorizontalStagesViewIndicator.OnDrawViewCallBack() {
            @Override
            public void onViewCallBack(int index) {
                Toast.makeText(TestHorizontalStageViewActivity.this, "" + index, Toast.LENGTH_SHORT).show();
            }
        });
        init(a);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a[2]=1;
                a[3]=0;
                init(a);
            }
        });
    }

    public void init(int []a) {
        List<StageBean> stagesBeanList = new ArrayList<>();
        StageBean stageBean0 = new StageBean("接单", a[0], 50);
        StageBean stageBean1 = new StageBean("打包", a[1], 50);
        StageBean stageBean2 = new StageBean("出发", a[2], 50);
        StageBean stageBean3 = new StageBean("送单", a[3], 50);
        StageBean stageBean4 = new StageBean("完成", a[4], 50);
        StageBean stageBean5 = new StageBean("支付", a[5], 50);
        StageBean stageBean6 = new StageBean("完成", a[6], 50);
        StageBean stageBean7 = new StageBean("评价", a[7], 50);
        stagesBeanList.add(stageBean0);
        stagesBeanList.add(stageBean1);
        stagesBeanList.add(stageBean2);
        stagesBeanList.add(stageBean3);
        stagesBeanList.add(stageBean4);
        stagesBeanList.add(stageBean5);
        stagesBeanList.add(stageBean6);
        stagesBeanList.add(stageBean7);

        stageView.setStageViewTexts(stagesBeanList)
                .setTextSize(16)//set textSize
                .setStagesViewIndicatorCompletedLineColor(ContextCompat.getColor(getBaseContext(), android.R.color.white))//设置stagesViewIndicator完成线的颜色
                .setStagesViewIndicatorUnCompletedLineColor(ContextCompat.getColor(getBaseContext(), R.color.uncompleted_text_color))//设置stagesViewIndicator未完成线的颜色
                .setStageViewComplectedTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.black))//设置stagesView text完成线的颜色
                .setStageViewUnComplectedTextColor(ContextCompat.getColor(getBaseContext(), R.color.uncompleted_text_color))//设置stagesView text未完成线的颜色
                .setStagesViewIndicatorCompleteIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.yiwancheng))//设置stagesViewIndicator CompleteIcon
                .setStagesViewIndicatorDefaultIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.weiwancheng))//设置stagesViewIndicator DefaultIcon
                .setStagesViewIndicatorAttentionIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.jinxingzhong))
                .setStageViewUnComplectedIv(ContextCompat.getDrawable(getBaseContext(), R.mipmap.tianchengzuo1))
                .setStageViewComplectedIv(ContextCompat.getDrawable(getBaseContext(), R.mipmap.tianchengzuo));
    }
}