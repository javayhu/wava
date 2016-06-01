package com.github.hujiaweibujidao.wava.animator;

import android.animation.ObjectAnimator;

import com.github.hujiaweibujidao.wava.BaseViewAnimator;
import com.github.hujiaweibujidao.yava.EasingFunction;

public class LandingAnimator extends BaseViewAnimator {
    @Override
    protected void prepare() {
//        mAnimatorSet.playTogether(
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleX", 1.5f, 1f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleY", 1.5f, 1f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1f))
//        );

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTarget, "scaleX", 1.5f, 1f);
        animator1.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTarget, "scaleY", 1.5f, 1f);
        animator2.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1f);
        animator3.setInterpolator(EasingFunction.QUINT_OUT);
        mAnimatorSet.playTogether(animator1, animator2, animator3);
    }
}
