package com.macsags.stageview;

public class StageBean {
    public static final int STEP_UNDO = -1;//未完成  undo step
    public static final int STEP_CURRENT = 0;//正在进行 current step
    public static final int STEP_COMPLETED = 1;//已完成 completed step

    private String name;

    public StageBean(String name, int state, int drawableSize) {
        this.name = name;
        this.state = state;
        this.drawableSize = drawableSize;
    }

    private int state;

    public int getStateDrawable() {
        return stateDrawable;
    }

    public void setStateDrawable(int stateDrawable) {
        this.stateDrawable = stateDrawable;
    }

    private int stateDrawable;

    private int drawableIdCurrent;//正在进行的iconId
    private int drawableIdUndo;//未完成的iconId
    private int drawableIdCompleted;//已完成的iconId

    public int getDrawableSize() {
        return drawableSize;
    }

    public void setDrawableSize(int drawableSize) {
        this.drawableSize = drawableSize;
    }

    private int drawableSize;

    public int getDrawableIdCurrent() {
        return drawableIdCurrent;
    }

    public void setDrawableIdCurrent(int drawableIdCurrent) {
        this.drawableIdCurrent = drawableIdCurrent;
    }

    public int getDrawableIdUndo() {
        return drawableIdUndo;
    }

    public void setDrawableIdUndo(int drawableIdUndo) {
        this.drawableIdUndo = drawableIdUndo;
    }

    public int getDrawableIdCompleted() {
        return drawableIdCompleted;
    }

    public void setDrawableIdCompleted(int drawableIdCompleted) {
        this.drawableIdCompleted = drawableIdCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public StageBean() {
    }

    public StageBean(String name, int state) {
        this.name = name;
        this.state = state;
    }

    public StageBean(String name, int state, int drawableIdCurrent, int drawableIdUndo, int drawableIdCompleted, int drawableSize) {
        this.name = name;
        this.state = state;
        this.drawableIdCurrent = drawableIdCurrent;
        this.drawableIdUndo = drawableIdUndo;
        this.drawableIdCompleted = drawableIdCompleted;
        this.drawableSize = drawableSize;
    }
}
