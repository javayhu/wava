package com.github.hujiaweibujidao.wava.animator;

import android.animation.ObjectAnimator;

import com.github.hujiaweibujidao.wava.BaseViewAnimator;
import com.github.hujiaweibujidao.yava.EasingFunction;

public class TakingOffAnimator extends BaseViewAnimator {
    @Override
    protected void prepare() {
//        mAnimatorSet.playTogether(
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleX", 1f, 1.5f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleY", 1f, 1.5f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "alpha", 1, 0))
//        );

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTarget, "scaleX", 1f, 1.5f);
        animator1.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTarget, "scaleY", 1f, 1.5f);
        animator2.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mTarget, "alpha", 1, 0);
        animator3.setInterpolator(EasingFunction.QUINT_OUT);

        mAnimatorSet.playTogether(animator1, animator2, animator3);
    }
}
