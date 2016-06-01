### wava

> Wow, Android View Animation!

我想写一个很好用的Android动画制作库，具体如何做目前还在思考中 🐈

目前做的最好的Android动画库项目是[@代码家](https://github.com/daimajia)的[AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations)，这个项目真的非常棒，`wava`项目目前只是参考这个项目对其代码进行调整和改进，后期将添加更多功能和改进吧。

主要修改和改进的地方：

1.去掉了过时的nineoldandroids库；

2.大幅度精简了核心类`YoYo`以及`BaseViewAnimator`内部的代码；

3.增加了动画重复播放、动画结束时恢复等功能的接口调用；

4.将原来依赖的`AndroidEasingFunctions`替换成[`yava`](https://github.com/hujiaweibujidao/yava)；

5.其他的小的改动，例如简化了`ViewAnimator`内部的调用代码；

6.复制了原有的动画演示代码，略有修改，但是保证了效果如初。

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

