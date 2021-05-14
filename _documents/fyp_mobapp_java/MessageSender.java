package fyp_mobapp_java;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006\t"},
        d2 = {"Lcom/example/fyp_mobapp/MessageSender;", "", "sendMessage", "Lretrofit2/Call;", "Ljava/util/ArrayList;", "Lcom/example/fyp_mobapp/BotResponse;", "Lkotlin/collections/ArrayList;", "userMessage", "Lcom/example/fyp_mobapp/Message;", "app_debug"}
)
public interface MessageSender {
    @POST("webhook")
    @NotNull
    Call sendMessage(@Body @NotNull Message var1);
}
