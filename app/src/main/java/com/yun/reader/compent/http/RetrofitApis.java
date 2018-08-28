package com.yun.reader.compent.http;

import com.yun.reader.common.http.response.ResultResponse;
import com.yun.reader.product.book.manager.BookDetailBean;
import com.yun.reader.product.book.manager.PromotionBookBean;
import com.yun.reader.product.login.module.bean.LoginAuto;
import com.yun.reader.product.reader.manager.module.DownloadFileResponse;
import com.yun.reader.product.setting.module.bean.Subscription;

import java.util.List;

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
    @POST(value = "user/login")
    Observable<ResultResponse<LoginAuto>> login(@Body Object obj);

    //    @POST(value = "app/conf")
//    Observable<ResultResponse<AppConfResponse>> appConf(@Body Object obj);
//
//    @POST(value = "app/conf")
//    Call<ResponseBody> appConfInService(@Body Object obj);
//
//    @POST(value = "book/autoBuyList")
//    Observable<ResultResponse<List<BookResponse>>> autoBuyList();
//
//    @POST(value = "book/detail")
//    Observable<ResultResponse<BookDetailResponse>> bookDetail(@Body Object obj);
//
    @POST(value = "book/info")
    Observable<ResultResponse<BookDetailBean>> bookInfo(@Body Object obj);

    //
//    @POST(value = "book/info")
//    Observable<ResultResponse<List<BookResponse>>> bookInfoArray(@Body Object obj);
//
    @POST(value = "/book/promotionBooks")
    Observable<ResultResponse<List<PromotionBookBean>>> bookPromotionBooks();
//
//    @POST(value = "/book/searchSuggestions")
//    Observable<ResultResponse<List<SearchSuggest>>> bookSearchSuggest(@Body Object obj);
//
//    @POST(value = "book/cancelAutoBuy")
//    Observable<ResultResponse<String>> cancelAutoBuy(@Body Object obj);
//
//    @POST(value = "/book/chapterFeedback")
//    Observable<ResultResponse<String>> chapterFeedback(@Body Object obj);
//
//    @POST(value = "user/checkMobileNum")
//    Observable<ResultResponse<CheckMobileNumResponse>> checkMobileNum(@Body Object obj);
//
//    @POST(value= "app/checkUpdate")
//    Observable<ResultResponse<AppUpdateResponse>> checkUpdate();
//
//    @POST(value = "shelf/add")
//    Observable<ResultResponse<String>> cloudAdd(@Body Object obj);
//
//    @POST(a = "shelf/delete")
//    Observable<ResultResponse<String>> cloudDelete(@Body Object obj);
//
//    @POST(value = "shelf/sync")
//    Observable<ResultResponse<List<BookResponse>>> cloudSync(@Body Object obj);
//
//    @POST(value = "book/comment")
//    Observable<ResultResponse<Object>> comment(@Body Object obj);

    @POST(value = "book/downloadChaptersList")
    Observable<ResultResponse<DownloadFileResponse>> downloadChapterList(@Body Object obj);

    @POST(value = "book/downloadChapters")
    Observable<ResultResponse<DownloadFileResponse>> downloadChapters(@Body Object obj);
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
//    Observable<ResultResponse<LoginAuto>> edit(@Body Object obj);
//
//    @POST(value = "app/feedback")
//    Observable<ResultResponse<String>> feedback(@Body Object obj);
//
//    @POST(value= "app/listFeedbacks")
//    Observable<ResultResponse<List<FeedBackResponse>>> feedbackList(@Body Object obj);
//
//    @POST(value = "app/font")
//    Observable<ResultResponse<List<FontResponse>>> fontList();
//
//    @POST(value = "/book/comments")
//    Observable<ResultResponse<List<CommentListResponse>>> getBookCommentList(@Body Object obj);
//
//    @POST(value = "user/messages")
//    Observable<ResultResponse<List<MsgResponse>>> getMessageList(@Body Object obj);
//
//    @POST(value = "shelf/suggestList")
//    Observable<ResultResponse<List<ShelfSuggestResponse>>> getShelfSuggest();
//
//    @POST(value = "user/imageCode")
//    Observable<ResultResponse<String>> imageCode(@Body Object obj);
//
//    @POST(value = "user/loginAuto")
//    Observable<ResultResponse<LoginAuto>> login(@Body Object obj);

    //    @POST(value = "book/orderInfo")
//    Observable<ResultResponse<OrderInfoResponse>> orderInfo(@Body Object obj);
//
//    @POST(value = "book/pay")
//    Observable<ResultResponse<String>> payOrder(@Body Object obj);
//
//    @POST(value = "pocket/auto")
//    Observable<ResultResponse<Pocket2ZhulangResponse>> pocket2zhulang(@Body Object obj);
//
//    @POST(value= "user/event")
//    Observable<ResultResponse<String>> postCommentEvent(@Body Object obj);
//
//    @POST(value= "book/praiseComment ")
//    Observable<ResultResponse<String>> praiseComment(@Body Object obj);
//
//    @POST(value= "app/promotion")
//    Observable<ResultResponse<BookResponse>> promotion();
//
//    @POST(value = "/book/purchasedChapters")
//    Observable<ResultResponse<HashMap<String, String>>> purchasedChapters(@Body Object obj);
//
//    @POST(value= "push/binding")
//    Observable<ResultResponse<String>> pushBinding(@Body Object obj);
//
//    @POST(value= "book/recommendBooks")
//    Observable<ResultResponse<List<BookResponse>>> recommendBooks(@Body Object obj);
//
//    @POST(value = "book/reward ")
//    Observable<ResultResponse<String>> reward(@Body Object obj);
//
//    @POST(value = "book/sameAuthor")
//    Observable<ResultResponse<List<BookResponse>>> sameAuthor(@Body Object obj);
//
//    @POST(value = "book/searchSuggest")
//    Observable<ResultResponse<List<BookResponse>>> searchSuggest(@Body Object obj);
//
//    @POST(value = "book/sendFlowers")
//    Observable<ResultResponse<String>> sendFlowers(@Body Object obj);
//
//    @POST(value = "shelf/checkUpdate")
//    Observable<ResultResponse<List<BookResponse>>> shelfCheckUpdate(@Body Object obj);
//
//    @POST(value = "user/smsCode")
//    Observable<ResultResponse<String>> smsCode(@Body Object obj);
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
    @POST(value = "user/conf")
    Observable<ResultResponse<List<Subscription>>> userConf(@Body Object obj);

//    @POST(value= "user/event")
//    Observable<ResultResponse<String>> userEvent(@Body Object obj);
//
//    @POST(value = "CheckIn/sign")
//    Observable<ResultResponse<SignResponse>> userSign();
}
