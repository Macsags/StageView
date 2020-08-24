package com.macsags.stageview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class TestHorizontalStageViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_horizontal);
        HorizontalStageView stageView = findViewById(R.id.stage_view);
        List<StageBean> stepsBeanList = new ArrayList<>();
        StageBean stepBean0 = new StageBean("接单", 1, R.mipmap.shuipingzuo, 50);
        StageBean stepBean1 = new StageBean("打包", 1, R.mipmap.shuipingzuo, 50);
        StageBean stepBean2 = new StageBean("出发", 0, R.mipmap.shuipingzuo1, 50);
        StageBean stepBean3 = new StageBean("送单", -1, R.mipmap.shuipingzuo1, 50);
        StageBean stepBean4 = new StageBean("完成", -1, R.mipmap.shuipingzuo1, 50);
        StageBean stepBean5 = new StageBean("支付", -1, R.mipmap.shuipingzuo1, 50);
        StageBean stepBean6 = new StageBean("完成", -1, R.mipmap.shuipingzuo1, 50);
        StageBean stepBean7 = new StageBean("评价", -1, R.mipmap.shuipingzuo1, 50);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);
        stepsBeanList.add(stepBean3);
        stepsBeanList.add(stepBean4);
        stepsBeanList.add(stepBean5);
        stepsBeanList.add(stepBean6);
        stepsBeanList.add(stepBean7);

        stageView.setStepViewTexts(stepsBeanList)
                .setTextSize(16)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(getBaseContext(), android.R.color.white))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(getBaseContext(), R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(getBaseContext(), android.R.color.white))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(getBaseContext(), R.color.uncompleted_text_color))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.yiwancheng))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.weiwancheng))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(getBaseContext(), R.drawable.jinxingzhong));//设置StepsViewIndicator AttentionIcon

    }
}