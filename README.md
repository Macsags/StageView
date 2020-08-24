# StageView
在此感谢stepview给的灵感

简介：
-------
stageView/stepView 仿外卖配送进度，阶段进度，实时进度等等</br>
****
示例：
-------
![](https://github.com/Macsags/StageView/blob/master/stageview.png)

[图片地址](https://github.com/Macsags/StageView/blob/master/stageview.png)
</br>
****
日志
-------
2020/8/24
* 第一次上传
****
如何使用How to：
-------
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

```
allprojects { 
		repositories { 
			... 
			maven { url 'https://www.jitpack.io' } 
		} 
	}  		
```

Step 2. Add the dependency<br> 

```
allprojects { 
	dependencies {
	          implementation 'com.github.Macsags:StageView:1.0.0'
	      } 
	} 
```	
****
使用方法：
-------
```
    XML里加自定义view
    <com.macsags.stageview.HorizontalStageView
       android:id="@+id/stage_view"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"/>

    Activity里
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

```
****
请关注
-------
  [我的博客](https://blog.csdn.net/qq_32368129)
  
