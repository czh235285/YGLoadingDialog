package com.czh.library;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/1.
 */

public class LoadingDialog extends Dialog {
    /**
     * 存放三个小球的集合
     */
    private List<ImageView> views = new ArrayList<>();
    /**
     * 同时播放动画的对象
     */
    private AnimatorSet animatorSet;

    public LoadingDialog(Context context) {
        super(context,R.style.YgDialog);
    }

    @Override
    public void show() {
        super.show();
        startAnimator();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        animatorSet.cancel();
    }

    private void startAnimator() {
        /**动画组合->让左右同时执行**/
        animatorSet = new AnimatorSet();
        animatorSet.play(startAnimator1()).with(startAnimator2()).with(startAnimator3());
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baidu_progress_bar);
        ImageView iv_blue = (ImageView) findViewById(R.id.iv_blue);
        ImageView iv_yellow = (ImageView) findViewById(R.id.iv_yellow);
        ImageView iv_red = (ImageView) findViewById(R.id.iv_red);
        views.add(iv_yellow);
        views.add(iv_red);
        views.add(iv_blue);
    }

    private ObjectAnimator startAnimator1() {
        /**对象的不同属性组合**/
        PropertyValuesHolder objectAnimatorTranslation = PropertyValuesHolder.ofFloat("translationX", -50, -100, -50, 0, 50, 100, 50, 0, -50);
        PropertyValuesHolder objectAnimatorScale = PropertyValuesHolder.ofFloat("scaleX", 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f, 1, 0.5f);
        PropertyValuesHolder objectAnimatorScaleY = PropertyValuesHolder.ofFloat("scaleY", 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f, 1, 0.5f);
        /**同时操作对象的两个属性动画**/
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(views.get(0), objectAnimatorTranslation, objectAnimatorScale, objectAnimatorScaleY);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        return objectAnimator;

    }

    private ObjectAnimator startAnimator2() {
        /**对象的不同属性组合**/
        PropertyValuesHolder objectAnimatorTranslation = PropertyValuesHolder.ofFloat("translationX", 0, 50, 100, 50, 0, -50, -100, -50, 0);
        PropertyValuesHolder objectAnimatorScale = PropertyValuesHolder.ofFloat("scaleX", 1, 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f, 1);
        PropertyValuesHolder objectAnimatorScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f, 1);
        /**同时操作对象的两个属性动画**/
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(views.get(1), objectAnimatorTranslation, objectAnimatorScale, objectAnimatorScaleY);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        return objectAnimator;

    }

    private ObjectAnimator startAnimator3() {
        /**对象的不同属性组合**/
        PropertyValuesHolder objectAnimatorTranslation = PropertyValuesHolder.ofFloat("translationX", 50, 0, -50, -100, -50, 0, 50, 100, 50);
        PropertyValuesHolder objectAnimatorScale = PropertyValuesHolder.ofFloat("scaleX", 1.5f, 1f, 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f);
        PropertyValuesHolder objectAnimatorScaleY = PropertyValuesHolder.ofFloat("scaleY", 1.5f, 1f, 0.5f, 1, 1.5f, 1, 0.5f, 1, 1.5f);
        /**同时操作对象的两个属性动画**/
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(views.get(2), objectAnimatorTranslation, objectAnimatorScale, objectAnimatorScaleY);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        return objectAnimator;
    }
}
