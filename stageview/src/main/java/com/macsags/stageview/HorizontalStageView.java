package com.macsags.stageview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


import com.baoyachi.stepview.R;

import java.util.List;

public class HorizontalStageView extends LinearLayout implements HorizontalStagesViewIndicator.OnDrawIndicatorListener {
    private RelativeLayout mTextContainer;
    private RelativeLayout mImgContainer;
    private HorizontalStagesViewIndicator mStagesViewIndicator;
    private List<StageBean> mStageBeanList;
    private int mComplectingPosition;
    private int mUnComplectedTextColor = ContextCompat.getColor(getContext(), R.color.uncompleted_text_color);//定义默认未完成文字的颜色;
    private int mComplectedTextColor = ContextCompat.getColor(getContext(), android.R.color.white);//定义默认完成文字的颜色;
    //    private Drawable mUnComplectedIV ;//定义默认未完成iv背景色颜色;
//    private Drawable mComplectedIV;//定义默认完成iv背景色颜色;
    private int mUnComplectedIvs[];
    private int mComplectedIvs[];
    private int mTextSize = 14;//default textSize
    private TextView mTextView;
    private ImageView mImageView;

    public HorizontalStageView(Context context) {
        this(context, null);
    }

    public HorizontalStageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalStageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.widget_horizontal_stagesview, this);
        mStagesViewIndicator = (HorizontalStagesViewIndicator) rootView.findViewById(R.id.stages_indicator);
        mStagesViewIndicator.setOnDrawListener(this);
        mTextContainer = (RelativeLayout) rootView.findViewById(R.id.rl_text_container);
        mImgContainer = (RelativeLayout) rootView.findViewById(R.id.rl_img_container);
    }

    /**
     * 设置显示的文字
     *
     * @param StagesBeanList
     * @return
     */
    public HorizontalStageView setStageViewTexts(List<StageBean> StagesBeanList) {
        mStageBeanList = StagesBeanList;
        mStagesViewIndicator.setStageNum(mStageBeanList);
        int j = -1;
        for (int i = 0; i < StagesBeanList.size(); i++) {
            if (StagesBeanList.get(i).getState() == 1) {
                j++;
            }

        }
        mComplectingPosition = j;
        return this;
    }


    /**
     * 设置未完成文字的颜色
     *
     * @param unComplectedTextColor
     * @return
     */
    public HorizontalStageView setStageViewUnComplectedTextColor(int unComplectedTextColor) {
        mUnComplectedTextColor = unComplectedTextColor;
        return this;
    }

    /**
     * 设置完成文字的颜色
     *
     * @param complectedTextColor
     * @return
     */
    public HorizontalStageView setStageViewComplectedTextColor(int complectedTextColor) {
        this.mComplectedTextColor = complectedTextColor;
        return this;
    }

    /**
     * 设置上部未完成图片
     *
     * @param unComplectedIvs
     * @return
     */
    public HorizontalStageView setStageViewUnComplectedIv(int[] unComplectedIvs) {
        mUnComplectedIvs = unComplectedIvs;
        return this;
    }

    /**
     * 设置完成图片
     *
     * @param complectedIvs
     * @return
     */
    public HorizontalStageView setStageViewComplectedIv(int[] complectedIvs) {
        this.mComplectedIvs = complectedIvs;
        return this;
    }

    /**
     * 设置StagesViewIndicator未完成线的颜色
     *
     * @param unCompletedLineColor
     * @return
     */
    public HorizontalStageView setStagesViewIndicatorUnCompletedLineColor(int unCompletedLineColor) {
        mStagesViewIndicator.setUnCompletedLineColor(unCompletedLineColor);
        return this;
    }

    /**
     * 设置StagesViewIndicator完成线的颜色
     *
     * @param completedLineColor
     * @return
     */
    public HorizontalStageView setStagesViewIndicatorCompletedLineColor(int completedLineColor) {
        mStagesViewIndicator.setCompletedLineColor(completedLineColor);
        return this;
    }

    /**
     * 设置StagesViewIndicator默认图片
     *
     * @param defaultIcon
     */
    public HorizontalStageView setStagesViewIndicatorDefaultIcon(Drawable defaultIcon) {
        mStagesViewIndicator.setDefaultIcon(defaultIcon);
        return this;
    }

    /**
     * 设置StagesViewIndicator已完成图片
     *
     * @param completeIcon
     */
    public HorizontalStageView setStagesViewIndicatorCompleteIcon(Drawable completeIcon) {
        mStagesViewIndicator.setCompleteIcon(completeIcon);
        return this;
    }

    /**
     * 设置StagesViewIndicator正在进行中的图片
     *
     * @param attentionIcon
     */
    public HorizontalStageView setStagesViewIndicatorAttentionIcon(Drawable attentionIcon) {
        mStagesViewIndicator.setAttentionIcon(attentionIcon);
        return this;
    }

    /**
     * set textSize
     *
     * @param textSize
     * @return
     */
    public HorizontalStageView setTextSize(int textSize) {
        if (textSize > 0) {
            mTextSize = textSize;
        }
        return this;
    }

    @Override
    public void onDrawIndicator() {
//        Log.e("TAG", "onDrawIndicator: " );
        if (mTextContainer != null) {
            mTextContainer.removeAllViews();
            List<Float> complectedXPosition = mStagesViewIndicator.getCircleCenterPointPositionList();
//            List<Float> c = mStagesViewIndicator.getc
            if (mStageBeanList != null && complectedXPosition != null && complectedXPosition.size() > 0) {
                for (int i = 0; i < mStageBeanList.size(); i++) {
                    mTextView = new TextView(getContext());
                    mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTextSize);
                    mTextView.setText(mStageBeanList.get(i).getName());
                    int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    mTextView.measure(spec, spec);
                    // getMeasuredWidth
                    int measuredWidth = mTextView.getMeasuredWidth();
                    mTextView.setX(complectedXPosition.get(i) - measuredWidth / 2);
                    mTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    Log.e("TAG", "onDrawIndicator: " + mComplectingPosition + "------i" + i);
                    if (i <= mComplectingPosition) {
                        mTextView.setTypeface(null, Typeface.BOLD);
                        mTextView.setTextColor(mComplectedTextColor);
                    } else {
                        mTextView.setTextColor(mUnComplectedTextColor);
                        mTextView.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                    }

                    mTextContainer.addView(mTextView);
                }

            }
        }
        if (mImgContainer != null) {
            mImgContainer.removeAllViews();
            List<Float> complectedXPosition = mStagesViewIndicator.getCircleCenterPointPositionList();
            if (mStageBeanList != null && complectedXPosition != null && complectedXPosition.size() > 0) {
                for (int i = 0; i < mStageBeanList.size(); i++) {
                    mImageView = new ImageView(getContext());
                    int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    mImageView.measure(spec, spec);
                    // getMeasuredWidth
                    int measuredWidth = mImageView.getMeasuredWidth();
                    mImageView.setX(complectedXPosition.get(i) - mStageBeanList.get(i).getDrawableSize() / 2);
                    mImageView.setLayoutParams(new ViewGroup.LayoutParams(mStageBeanList.get(i).getDrawableSize(), mStageBeanList.get(i).getDrawableSize()));//默认长宽一样

                    if (i <= mComplectingPosition) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            mImageView.setBackgroundResource(mComplectedIvs[i]);
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            mImageView.setBackgroundResource(mUnComplectedIvs[i]);
                        }
                    }
//                    mImageView.setBackgroundResource(mStageBeanList.get(i).getStateDrawable());


                    mImgContainer.addView(mImageView);
                }

            }
        }

    }

    public void OnDrawViewCallBack(HorizontalStagesViewIndicator.OnDrawViewCallBack callback) {
        mStagesViewIndicator.setOnDrawViewCallBack(callback);
    }

}
