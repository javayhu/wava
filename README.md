[中文说明](README-CN.md) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-wava-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/3663)

### wava

> Wow, Android View Animation! (capital letter of each word forms `WAVA`)

I wanna build another fancy Android animation library, but I was still thinking how to do that. 🐈

[daimajia](https://github.com/daimajia) has built an amazing library named [AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations), it's really really awesome.

Currently wava is just a library based on AndroidViewAnimations with many updates. Since it has changed a lot from the latest release of AndroidViewAnimations (although I tried to keep the API as same as before), I think better make another one than pulling requests.

Later I will try my best to add other fancy new features to wava, star it if you have any interest. 😜

[When Math Meets Animation(1)](https://javayhu.github.io/blog/2016-05-26-when-math-meets-android-animation-1)    
[When Math Meets Animation(2)](https://javayhu.github.io/blog/2016-05-27-When-Math-meets-Android-Animation-2)     
[When Math Meets Animation(3)](https://javayhu.github.io/blog/2016-05-28-When-Math-meets-Android-Animation-3)     

### Sample

![img](wava.gif)

### Usage

It's almost the same.

```java
YoYo.with(technique).duration(1200)
    .interpolate(new AccelerateDecelerateInterpolator())
    .listen(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationCancel(Animator animation) {
                Toast.makeText(MainActivity.this, "canceled", Toast.LENGTH_SHORT).show();
        }
    })
    .playOn(mTarget);
```

### Setup

1.add this in your `build.gradle` file in root project

```
allprojects {
    repositories {
        ...
        maven { url "https://www.jitpack.io" }
    }
}
```

2.add the following dependency

```
dependencies {
    compile 'com.github.hujiaweibujidao:wava:1.0.0'
}
```

### Changes 

The following are main changes from [AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations):

1.removed deprecated [NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids).

New applications should use `minSdkVersion="14"` or higher which has access to the platform animation APIs.

For example, animation reset no longer needs `ViewHelper`

```java
public void reset() {
    mTarget.setAlpha(1);
    mTarget.setScaleX(1);
    mTarget.setScaleY(1);
    mTarget.setTranslationX(0);
    mTarget.setTranslationY(0);
    mTarget.setRotation(0);
    mTarget.setRotationX(0);
    mTarget.setRotationY(0);
    mTarget.setPivotX(mTarget.getMeasuredWidth() / 2.0f);
    mTarget.setPivotY(mTarget.getMeasuredHeight() / 2.0f);
}
```

2.simplified the core `YoYo` class (including `Builder` and `YoYoString`) while keeping the original API.

```java
public static class Builder {

    private static final int DEFAULT_REPEAT = 1;//动画默认只播放一次
    private static final long DEFAULT_DELAY = 0;//动画默认没有启动延时
    private static final boolean DEFAULT_RESET = false;//动画结束默认不恢复原状
    private static final long DEFAULT_DURATION = 1000;//动画时间间隔默认是1秒

    private View target;//作用的view
    private long delay = DEFAULT_DELAY;//动画启动延迟
    private long duration = DEFAULT_DURATION;//动画持续时长
    private int repeat = DEFAULT_REPEAT;//动画重复次数
    private boolean reset = DEFAULT_RESET;//动画结束之后是否恢复到原来的状态，true表示恢复
    private BaseViewAnimator animator;//animator类
    private Interpolator interpolator;//interpolator 时间插值类
    private List<Animator.AnimatorListener> listeners = new ArrayList<Animator.AnimatorListener>();//动画的监听器

    //两个构造函数都将使得animator成为一个非空对象
    private Builder(Techniques technique) {
        this.animator = technique.getAnimator();
    }

    private Builder(BaseViewAnimator animator) {
        this.animator = animator;
    }

    public Builder duration(long duration) {
        this.duration = duration;
        return this;
    }

    public Builder delay(long delay) {
        this.delay = delay;
        return this;
    }

    public Builder interpolate(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public Builder listen(AnimatorListenerAdapter listener) {
        this.listeners.add(listener);
        return this;
    }

    public Builder reset(boolean reset) {
        this.reset = reset;
        return this;
    }

    public Builder repeat(int count) {
        this.repeat = count;
        return this;
    }

    //调用play表示动画正式开始，返回结果是可以控制动画的对象YoYoString
    public YoYoString playOn(View target) {
        this.target = target;
        start();
        return new YoYoString(this.animator);
    }

    //builder内部的start方法，将animatorset启动
    private void start() {
        animator.setTarget(target).setDuration(duration).setInterpolator(interpolator)
                .setStartDelay(delay).setRest(reset).setRepeat(repeat);

        if (listeners.size() > 0) {
            animator.addAllListeners(listeners);
        }

        animator.start();
    }
}
```

3.added supports to animation replay and animation reset after animation ends.

```java
public void start() {
    reset();
    prepare();
    if (mRepeat != 0) {
        for (Animator animator : mAnimatorSet.getChildAnimations()) {
            ((ValueAnimator) animator).setRepeatCount(mRepeat > 0 ? mRepeat - 1 : mRepeat);//区别无穷次
            //((ValueAnimator) animator).setRepeatMode(ValueAnimator.REVERSE);
        }
    }
    if (mRest) {
        mAnimatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                reset();
            }
        });
    }
    mAnimatorSet.start();
}
```

4.replaced the original dependency [`AndroidEasingFunctions`](https://github.com/daimajia/AnimationEasingFunctions) with my another library [`yava`](https://github.com/hujiaweibujidao/yava).

```java
public class LandingAnimator extends BaseViewAnimator {
    @Override
    protected void prepare() {
      //before
//        mAnimatorSet.playTogether(
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleX", 1.5f, 1f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "scaleY", 1.5f, 1f)),
//                Glider.glide(Skill.QuintEaseOut, mAnimatorSet.getDuration(), ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1f))
//        );

        //after
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTarget, "scaleX", 1.5f, 1f);
        animator1.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTarget, "scaleY", 1.5f, 1f);
        animator2.setInterpolator(EasingFunction.QUINT_OUT);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mTarget, "alpha", 0, 1f);
        animator3.setInterpolator(EasingFunction.QUINT_OUT);
        mAnimatorSet.playTogether(animator1, animator2, animator3);
    }
}
```

5.simplified all the `ViewAnimator` with easy access way to `mAnimatorSet` and `mTarget`.

```java
public class BounceAnimator extends BaseViewAnimator {
    @Override
    public void prepare() {
        mAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(mTarget, "translationY", 0, 0, -30, 0, -15, 0, 0)
        );
    }
}
```

6.modified the effect visualization code while keeping it same as before.

### License

```
The MIT License (MIT)

Copyright (c) 2016 Hujiawei

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

