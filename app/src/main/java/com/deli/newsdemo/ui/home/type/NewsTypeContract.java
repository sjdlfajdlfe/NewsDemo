package com.deli.newsdemo.ui.home.type;

import com.deli.newsdemo.entity.NewsHeadlineEntity;
import com.deli.newsdemo.mvpframe.base.BaseModel;
import com.deli.newsdemo.mvpframe.base.BasePresenter;
import com.deli.newsdemo.mvpframe.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:14
 * @describe :
 */

public interface NewsTypeContract {
    interface Model extends BaseModel {

        /**
         * 获取新闻model
         *
         * @return
         */
        Observable<NewsHeadlineEntity> getNews(int startPage, int endPage);

    }
    interface View extends BaseView {
        /**
         * 清除数据并更新新闻列表
         * @param data
         */
        void clearAndRefreshData(List<NewsHeadlineEntity.T1348647853363Bean> data);

        /**
         * 更新数据并添加数据
         */
        void addAndRefreshData(List<NewsHeadlineEntity.T1348647853363Bean> data);

        /**
         * 设置加载进度条
         *
         * @param show
         */
        void setLoadingVisible(boolean show);

        /**
         * 点击banner返回内容顶部
         */
        void backToTop();
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        /**
         * 获取新闻数据
         */
        public abstract void getNews(int startPage);

        /**
         * 清空网络请求
         */
        public abstract void clearRequest();
    }
}
