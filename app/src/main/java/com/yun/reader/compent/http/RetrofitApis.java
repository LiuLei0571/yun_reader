package com.yun.reader.compent.http;

import com.yun.reader.common.http.response.BaseResponse;
import com.yun.reader.product.user.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 用途：.
 *
 * @author ：Created by liulei.
 * @date 2018/4/25 .
 * 邮箱:liulei@getui.com.
 */


public interface RetrofitApis {
    @POST(value = "user/account")
    Observable<BaseResponse<LoginResponse>> account();

//    @POST(value = "app/conf")
//    Observable<BaseResponse<AppConfResponse>> appConf(@Body Object obj);
//
//    @POST(value = "app/conf")
//    Call<ResponseBody> appConfInService(@Body Object obj);
//
//    @POST(value = "book/autoBuyList")
//    Observable<BaseResponse<List<BookResponse>>> autoBuyList();
//
//    @POST(value = "book/detail")
//    Observable<BaseResponse<BookDetailResponse>> bookDetail(@Body Object obj);
//
//    @POST(value= "book/info")
//    Observable<BaseResponse<BookResponse>> bookInfo(@Body Object obj);
//
//    @POST(value = "book/info")
//    Observable<BaseResponse<List<BookResponse>>> bookInfoArray(@Body Object obj);
//
//    @POST(value = "/book/promotionBooks")
//    Observable<BaseResponse<List<BookResponse>>> bookPromotionBooks();
//
//    @POST(value = "/book/searchSuggestions")
//    Observable<BaseResponse<List<SearchSuggest>>> bookSearchSuggest(@Body Object obj);
//
//    @POST(value = "book/cancelAutoBuy")
//    Observable<BaseResponse<String>> cancelAutoBuy(@Body Object obj);
//
//    @POST(value = "/book/chapterFeedback")
//    Observable<BaseResponse<String>> chapterFeedback(@Body Object obj);
//
//    @POST(value = "user/checkMobileNum")
//    Observable<BaseResponse<CheckMobileNumResponse>> checkMobileNum(@Body Object obj);
//
//    @POST(value= "app/checkUpdate")
//    Observable<BaseResponse<AppUpdateResponse>> checkUpdate();
//
//    @POST(value = "shelf/add")
//    Observable<BaseResponse<String>> cloudAdd(@Body Object obj);
//
//    @POST(a = "shelf/delete")
//    Observable<BaseResponse<String>> cloudDelete(@Body Object obj);
//
//    @POST(value = "shelf/sync")
//    Observable<BaseResponse<List<BookResponse>>> cloudSync(@Body Object obj);
//
//    @POST(value = "book/comment")
//    Observable<BaseResponse<Object>> comment(@Body Object obj);
//
//    @POST(value = "book/downloadChaptersList")
//    Observable<DownloadFileResponse> downloadChapterList(@Body Object obj);
//
//    @POST(value = "book/downloadChapters")
//    Observable<DownloadFileResponse> downloadChapters(@Body Object obj);
//
//    @C3815f
//    Observable<DownloadFileResponse> downloadCover(@C3710w String str);
//
//    @POST(value = "book/downloadChapters")
//    C3834b<ResponseBody> downloadEnableChapters(@Body Object obj);
//
//    @C3815f
//    C3834b<ResponseBody> downloadFile(@C3710w String str);
//
//    @POST(value = "user/edit")
//    Observable<BaseResponse<LoginResponse>> edit(@Body Object obj);
//
//    @POST(value = "app/feedback")
//    Observable<BaseResponse<String>> feedback(@Body Object obj);
//
//    @POST(value= "app/listFeedbacks")
//    Observable<BaseResponse<List<FeedBackResponse>>> feedbackList(@Body Object obj);
//
//    @POST(value = "app/font")
//    Observable<BaseResponse<List<FontResponse>>> fontList();
//
//    @POST(value = "/book/comments")
//    Observable<BaseResponse<List<CommentListResponse>>> getBookCommentList(@Body Object obj);
//
//    @POST(value = "user/messages")
//    Observable<BaseResponse<List<MsgResponse>>> getMessageList(@Body Object obj);
//
//    @POST(value = "shelf/suggestList")
//    Observable<BaseResponse<List<ShelfSuggestResponse>>> getShelfSuggest();
//
//    @POST(value = "user/imageCode")
//    Observable<BaseResponse<String>> imageCode(@Body Object obj);
//
    @POST(value = "user/login")
    Observable<BaseResponse<LoginResponse>> login(@Body Object obj);

//    @POST(value = "book/orderInfo")
//    Observable<BaseResponse<OrderInfoResponse>> orderInfo(@Body Object obj);
//
//    @POST(value = "book/pay")
//    Observable<BaseResponse<String>> payOrder(@Body Object obj);
//
//    @POST(value = "pocket/auto")
//    Observable<BaseResponse<Pocket2ZhulangResponse>> pocket2zhulang(@Body Object obj);
//
//    @POST(value= "user/event")
//    Observable<BaseResponse<String>> postCommentEvent(@Body Object obj);
//
//    @POST(value= "book/praiseComment ")
//    Observable<BaseResponse<String>> praiseComment(@Body Object obj);
//
//    @POST(value= "app/promotion")
//    Observable<BaseResponse<BookResponse>> promotion();
//
//    @POST(value = "/book/purchasedChapters")
//    Observable<BaseResponse<HashMap<String, String>>> purchasedChapters(@Body Object obj);
//
//    @POST(value= "push/binding")
//    Observable<BaseResponse<String>> pushBinding(@Body Object obj);
//
//    @POST(value= "book/recommendBooks")
//    Observable<BaseResponse<List<BookResponse>>> recommendBooks(@Body Object obj);
//
//    @POST(value = "book/reward ")
//    Observable<BaseResponse<String>> reward(@Body Object obj);
//
//    @POST(value = "book/sameAuthor")
//    Observable<BaseResponse<List<BookResponse>>> sameAuthor(@Body Object obj);
//
//    @POST(value = "book/searchSuggest")
//    Observable<BaseResponse<List<BookResponse>>> searchSuggest(@Body Object obj);
//
//    @POST(value = "book/sendFlowers")
//    Observable<BaseResponse<String>> sendFlowers(@Body Object obj);
//
//    @POST(value = "shelf/checkUpdate")
//    Observable<BaseResponse<List<BookResponse>>> shelfCheckUpdate(@Body Object obj);
//
//    @POST(value = "user/smsCode")
//    Observable<BaseResponse<String>> smsCode(@Body Object obj);
//
//    @HEAD(value= {"Accept-Encoding: gzip, deflate"})
//    @POST
//    @Multipart
//    Call<ResponseBody> uploadLog(@C3710w String str, @C3704q Part part);
//
//    @HEAD(a = {"Accept-Encoding: gzip, deflate"})
//    @POST(value = "https://app1.zhulang.com/app/trace")
//    @Multipart
//    Call<ResponseBody> uploadRunTimeLog(@C3704q Part part);
//
//    @C3815f(a = "http://app1.zhulang.com/a.html")
//    Observable<ResponseBody> uploadSSLException(@Path(value = , encoded = true) Map<String, String> map);
//
//    @POST(value = "user/conf")
//    Observable<BaseResponse<UserConfResponse>> userConf(@Body Object obj);
//
//    @POST(value= "user/event")
//    Observable<BaseResponse<String>> userEvent(@Body Object obj);
//
//    @POST(value = "CheckIn/sign")
//    Observable<BaseResponse<SignResponse>> userSign();
}
