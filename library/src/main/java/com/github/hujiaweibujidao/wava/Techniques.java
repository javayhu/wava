/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.hujiaweibujidao.wava;

import com.github.hujiaweibujidao.wava.animator.BounceAnimator;
import com.github.hujiaweibujidao.wava.animator.BounceInAnimator;
import com.github.hujiaweibujidao.wava.animator.BounceInDownAnimator;
import com.github.hujiaweibujidao.wava.animator.BounceInLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.BounceInRightAnimator;
import com.github.hujiaweibujidao.wava.animator.BounceInUpAnimator;
import com.github.hujiaweibujidao.wava.animator.DropOutAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeInAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeInDownAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeInLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeInRightAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeInUpAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeOutAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeOutDownAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeOutLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeOutRightAnimator;
import com.github.hujiaweibujidao.wava.animator.FadeOutUpAnimator;
import com.github.hujiaweibujidao.wava.animator.FlashAnimator;
import com.github.hujiaweibujidao.wava.animator.FlipInXAnimator;
import com.github.hujiaweibujidao.wava.animator.FlipInYAnimator;
import com.github.hujiaweibujidao.wava.animator.FlipOutXAnimator;
import com.github.hujiaweibujidao.wava.animator.FlipOutYAnimator;
import com.github.hujiaweibujidao.wava.animator.HingeAnimator;
import com.github.hujiaweibujidao.wava.animator.LandingAnimator;
import com.github.hujiaweibujidao.wava.animator.LinearAnimator;
import com.github.hujiaweibujidao.wava.animator.PulseAnimator;
import com.github.hujiaweibujidao.wava.animator.RollInAnimator;
import com.github.hujiaweibujidao.wava.animator.RollOutAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateInAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateInDownLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateInDownRightAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateInUpLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateInUpRightAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateOutAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateOutDownLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateOutDownRightAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateOutUpLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.RotateOutUpRightAnimator;
import com.github.hujiaweibujidao.wava.animator.RubberBandAnimator;
import com.github.hujiaweibujidao.wava.animator.ShakeAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideInDownAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideInLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideInRightAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideInUpAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideOutDownAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideOutLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideOutRightAnimator;
import com.github.hujiaweibujidao.wava.animator.SlideOutUpAnimator;
import com.github.hujiaweibujidao.wava.animator.StandUpAnimator;
import com.github.hujiaweibujidao.wava.animator.SwingAnimator;
import com.github.hujiaweibujidao.wava.animator.TadaAnimator;
import com.github.hujiaweibujidao.wava.animator.TakingOffAnimator;
import com.github.hujiaweibujidao.wava.animator.WaveAnimator;
import com.github.hujiaweibujidao.wava.animator.WobbleAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomInAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomInDownAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomInLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomInRightAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomInUpAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomOutAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomOutDownAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomOutLeftAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomOutRightAnimator;
import com.github.hujiaweibujidao.wava.animator.ZoomOutUpAnimator;

/**
 * Technique是各种不同的animator效果的枚举集合类 （形象地表示为采用哪种技术来操纵悠悠球）
 */
public enum Techniques {

    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),
    Linear(LinearAnimator.class),

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),

    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);

    private Class animatorClazz;

    Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
