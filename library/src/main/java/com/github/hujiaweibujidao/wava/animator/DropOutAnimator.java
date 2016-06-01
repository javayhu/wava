package com.github.hujiaweibujidao.wava.animator;

import android.animation.ObjectAnimator;

import com.github.hujiaweibujidao.wava.BaseViewAnimator;
import com.github.hujiaweibujidao.yava.EasingFunction;

public class DropOutAnimator extends BaseViewAnimator {
    @Override
    protected void prepare() {
        int distance = mTarget.getTop() + mTarget.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTarget, "translationY", -distance, 0);
        animator.setInterpolator(EasingFunction.BOUNCE_OUT);
        mAnimatorSet.playTogether(ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1), animator);
    }
}
