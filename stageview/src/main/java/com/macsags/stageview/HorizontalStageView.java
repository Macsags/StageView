package com.macsags.stageview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
    private HorizontalStagesViewIndicator mStepsViewIndicator;
    private List<StageBean> mStepBeanList;
    private int mComplectingPosition;
    private int mUnComplectedTextColor = ContextCompat.getColor(getContext(), R.color.uncompleted_text_color);//定义默认未完成文字的颜色;
    private int mComplectedTextColor = ContextCompat.getColor(getContext(), android.R.color.white);//定义默认完成文字的颜色;
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
        mStepsViewIndicator = (HorizontalStagesViewIndicator) rootView.findViewById(R.id.steps_indicator);
        mStepsViewIndicator.setOnDrawListener(this);
        mTextContainer = (RelativeLayout) rootView.findViewById(R.id.rl_text_container);
        mImgContainer = (RelativeLayout) rootView.findViewById(R.id.rl_img_container);
    }

    /**
     * 设置显示的文字
     *
     * @param stepsBeanList
     * @return
     */
    public HorizontalStageView setStepViewTexts(List<StageBean> stepsBeanList) {
        mStepBeanList = stepsBeanList;
        mStepsViewIndicator.setStepNum(mStepBeanList);
        return this;
    }


    /**
     * 设置未完成文字的颜色
     *
     * @param unComplectedTextColor
     * @return
     */
    public HorizontalStageView setStepViewUnComplectedTextColor(int unComplectedTextColor) {
        mUnComplectedTextColor = unComplectedTextColor;
        return this;
    }

    /**
     * 设置完成文字的颜色
     *
     * @param complectedTextColor
     * @return
     */
    public HorizontalStageView setStepViewComplectedTextColor(int complectedTextColor) {
        this.mComplectedTextColor = complectedTextColor;
        return this;
    }

    /**
     * 设置StepsViewIndicator未完成线的颜色
     *
     * @param unCompletedLineColor
     * @return
     */
    public HorizontalStageView setStepsViewIndicatorUnCompletedLineColor(int unCompletedLineColor) {
        mStepsViewIndicator.setUnCompletedLineColor(unCompletedLineColor);
        return this;
    }

    /**
     * 设置StepsViewIndicator完成线的颜色
     *
     * @param completedLineColor
     * @return
     */
    public HorizontalStageView setStepsViewIndicatorCompletedLineColor(int completedLineColor) {
        mStepsViewIndicator.setCompletedLineColor(completedLineColor);
        return this;
    }

    /**
     * 设置StepsViewIndicator默认图片
     *
     * @param defaultIcon
     */
    public HorizontalStageView setStepsViewIndicatorDefaultIcon(Drawable defaultIcon) {
        mStepsViewIndicator.setDefaultIcon(defaultIcon);
        return this;
    }

    /**
     * 设置StepsViewIndicator已完成图片
     *
     * @param completeIcon
     */
    public HorizontalStageView setStepsViewIndicatorCompleteIcon(Drawable completeIcon) {
        mStepsViewIndicator.setCompleteIcon(completeIcon);
        return this;
    }

    /**
     * 设置StepsViewIndicator正在进行中的图片
     *
     * @param attentionIcon
     */
    public HorizontalStageView setStepsViewIndicatorAttentionIcon(Drawable attentionIcon) {
        mStepsViewIndicator.setAttentionIcon(attentionIcon);
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
        if (mTextContainer != null) {
            mTextContainer.removeAllViews();
            List<Float> complectedXPosition = mStepsViewIndicator.getCircleCenterPointPositionList();
//            List<Float> c = mStepsViewIndicator.getc
            if (mStepBeanList != null && complectedXPosition != null && complectedXPosition.size() > 0) {
                for (int i = 0; i < mStepBeanList.size(); i++) {
                    mTextView = new TextView(getContext());
                    mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTextSize);
                    mTextView.setText(mStepBeanList.get(i).getName());
                    int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    mTextView.measure(spec, spec);
                    // getMeasuredWidth
                    int measuredWidth = mTextView.getMeasuredWidth();
                    mTextView.setX(complectedXPosition.get(i) - measuredWidth / 2);
                    mTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                    if (i <= mComplectingPosition) {
                        mTextView.setTypeface(null, Typeface.BOLD);
                        mTextView.setTextColor(mComplectedTextColor);
                    } else {
                        mTextView.setTextColor(mUnComplectedTextColor);
                    }

                    mTextContainer.addView(mTextView);
                }

            }
        }
        if (mImgContainer != null) {
            mImgContainer.removeAllViews();
            List<Float> complectedXPosition = mStepsViewIndicator.getCircleCenterPointPositionList();
            if (mStepBeanList != null && complectedXPosition != null && complectedXPosition.size() > 0) {
                for (int i = 0; i < mStepBeanList.size(); i++) {
                    mImageView = new ImageView(getContext());
                    int spec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
                    mImageView.measure(spec, spec);
                    // getMeasuredWidth
                    int measuredWidth = mImageView.getMeasuredWidth();
                    mImageView.setX(complectedXPosition.get(i) - mStepBeanList.get(i).getDrawableSize() / 2);
                    mImageView.setLayoutParams(new ViewGroup.LayoutParams( mStepBeanList.get(i).getDrawableSize(),  mStepBeanList.get(i).getDrawableSize()));//默认长宽一样

                    mImageView.setBackgroundResource(mStepBeanList.get(i).getStateDrawable());

                    mImgContainer.addView(mImageView);
                }

            }
        }

    }

}
