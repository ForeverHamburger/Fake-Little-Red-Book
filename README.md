# Fake Little Red Book（小奶书）

## 首页

根布局是DrawerLayout，内部是ViewPager2 + TabLayout。

![72724f9cf6c1d08ca667 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162232943.gif)

## 购物页面

使用CoordinatorLayout作为根布局，更多功能的弹窗是BottomSheetDialogFragment

![6d57f80eb695e92fc39f -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162233089.gif)





## 消息页面

没啥好说的，简单的RecyclerView，值得注意的是外层嵌套了NestedScrollView，禁用了内层RecyclerView的滑动，同时监听NestedScrollView的滑动，做了一个吸顶效果。

![0a342240cc86fd463896 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162230693.gif)



## 我的页面

整体采用DrawerLayout，内部嵌套约束布局，顶部导航栏使用ToolBar，并且随NestedScrollView改变颜色和透明度。底部为ViewPager2 + TabLayout + Fragment。

![a0515499860ce8dc2693 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162233622.gif)







## 笔记详情页面

笔记图片展示使用TabLayout，底部评论为RecyclerView。

![a93d6becf78d29eea853 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162232243.gif)







## 商品详情页

使用Banner轮播图作为商品图片展示工具。

顶部是导航栏（这里直接用图片代替了）与TabLayout。

整体主要界面是NestedScrollView，监听滑动的距离，同时与TabLayout联动，当点击Tab时，滑动到固定位置，当滑动到某些位置时，也会改变Tab的选项。

![0ecd205b2d43c151f144 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162235706.gif)



## 短视频界面

短视频使用ViewPager2 + ExoPlayer播放器，实现类似于抖音的短视频播放功能。

视频的item使用CoordinatorLayout作为根布局，评论是BottomSheetDialogFragment。

![fde43b2a00d631cb7640 -small-original](https://gitee.com/ForeverHamburger/picgo_imgs1/raw/master/202411162228812.gif)