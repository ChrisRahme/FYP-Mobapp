package fyp_mobapp_java;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0004\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"},
        d2 = {"Lcom/example/fyp_mobapp/Message;", "", "sender", "", "message", "(Ljava/lang/String;Ljava/lang/Object;)V", "getMessage", "()Ljava/lang/Object;", "setMessage", "(Ljava/lang/Object;)V", "getSender", "()Ljava/lang/String;", "setSender", "(Ljava/lang/String;)V", "app_debug"}
)
public final class Message {
    @NotNull
    private String sender;
    @NotNull
    private Object message;

    @NotNull
    public final String getSender() {
        return this.sender;
    }

    public final void setSender(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.sender = var1;
    }

    @NotNull
    public final Object getMessage() {
        return this.message;
    }

    public final void setMessage(@NotNull Object var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.message = var1;
    }

    public Message(@NotNull String sender, @NotNull Object message) {
        Intrinsics.checkParameterIsNotNull(sender, "sender");
        Intrinsics.checkParameterIsNotNull(message, "message");
        super();
        this.sender = sender;
        this.message = message;
    }

    // $FF: synthetic method
    public Message(String var1, Object var2, int var3, DefaultConstructorMarker var4) {
        if ((var3 & 1) != 0) {
            var1 = "MobileApp";
        }

        this(var1, var2);
    }
}
