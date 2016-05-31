package com.github.hujiaweibujidao.wava.animator;

import android.view.View;

import com.github.hujiaweibujidao.wava.BaseViewAnimator;

public class DropOutAnimator extends BaseViewAnimator {
    @Override
    protected void prepare() {
//        int distance = mTarget.getTop() + mTarget.getHeight();
//        mAnimatorSet.playTogether(
//                ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1),
//                Glider.glide(Skill.BounceEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "translationY", -distance, 0))
//        );
    }
}
