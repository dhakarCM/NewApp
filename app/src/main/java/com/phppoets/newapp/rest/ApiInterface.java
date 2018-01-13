package com.phppoets.newapp.rest;

import com.phppoets.newapp.Model.EventDetail.EventDetailResponse;
import com.phppoets.newapp.Model.Gallery.GalleriesResponse;
import com.phppoets.newapp.Model.News.NewsResponse;
import com.phppoets.newapp.Model.blog.BlogResponse;
import com.phppoets.newapp.Model.event.EventResponse;
import com.phppoets.newapp.Model.login.LoginResponse;
import com.phppoets.newapp.Model.newHome.NewHomeResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers("Accept:application/json")
//    @GET("/login")
//    Call<LoginResult> getLLogin(@Query("email") String email, @Query("password") String password);

  /*  @FormUrlEncoded
    @POST("/api/users/login.json")
    Call<LoginResponse> doLogin(@Field("email") String email, @Field("password") String password);

*/

//    @GET("/api/galleries/list.json")
//    Call<GalleryResponse> getGalleryList();
//
//    @GET("/api/items/search_item.json?")
//    Call<SearchResultResponse> getSearchResults(
//            @Query("jain_thela_admin_id") Integer jain_thela_admin_id, @Query("customer_id") Integer customer_id, @Query("item_query") String item_query
//    );

    @FormUrlEncoded
    @POST("/app/api/users/login.json")
    Call<LoginResponse> getLogin(@Field("email") String email, @Field("password") String password);

    @GET("/app/api/events/eventlist.json")
    Call<EventResponse> getEventList();

    @GET("/app/api/blogs/list.json?")
    Call<BlogResponse> getBlogList();

    @GET("/app/api/galleries/list.json")
    Call<GalleriesResponse> getGalleryList();

    @GET("/app/api/news_letters/list.json")
    Call<NewsResponse> getNewsList();

    @GET("/app/api/events/eventdetails.json?")
    Call<EventDetailResponse> getEventDetail(@Query("user_id") int user_id, @Query("event_id") int event_id);

    @GET("/app/api/users/homescreen.json")
    Call<NewHomeResponse> getSlider();


    // Call<HomeResponse> getEvents();
}