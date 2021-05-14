package fyp_mobapp_java;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0016B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007¢\u0006\u0002\u0010\tR$\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0017"},
        d2 = {"Lcom/example/fyp_mobapp/BotResponse;", "", "recipient", "", "text", "image", "buttons", "", "Lcom/example/fyp_mobapp/BotResponse$Buttons;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "getRecipient", "setRecipient", "getText", "setText", "Buttons", "app_debug"}
)
public final class BotResponse {
    @NotNull
    private String recipient;
    @NotNull
    private String text;
    @NotNull
    private String image;
    @NotNull
    private List buttons;

    @NotNull
    public final String getRecipient() {
        return this.recipient;
    }

    public final void setRecipient(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.recipient = var1;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void setText(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.text = var1;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    public final void setImage(@NotNull String var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.image = var1;
    }

    @NotNull
    public final List getButtons() {
        return this.buttons;
    }

    public final void setButtons(@NotNull List var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.buttons = var1;
    }

    public BotResponse(@NotNull String recipient, @NotNull String text, @NotNull String image, @NotNull List buttons) {
        Intrinsics.checkParameterIsNotNull(recipient, "recipient");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(image, "image");
        Intrinsics.checkParameterIsNotNull(buttons, "buttons");
        super();
        this.recipient = recipient;
        this.text = text;
        this.image = image;
        this.buttons = buttons;
    }

    // $FF: synthetic method
    public BotResponse(String var1, String var2, String var3, List var4, int var5, DefaultConstructorMarker var6) {
        if ((var5 & 1) != 0) {
            var1 = "1234";
        }

        if ((var5 & 2) != 0) {
            var2 = "";
        }

        if ((var5 & 4) != 0) {
            var3 = "";
        }

        this(var1, var2, var3, var4);
    }

    @Metadata(
            mv = {1, 1, 18},
            bv = {1, 0, 3},
            k = 1,
            d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"},
            d2 = {"Lcom/example/fyp_mobapp/BotResponse$Buttons;", "", "payload", "", "title", "(Lcom/example/fyp_mobapp/BotResponse;Ljava/lang/String;Ljava/lang/String;)V", "getPayload", "()Ljava/lang/String;", "setPayload", "(Ljava/lang/String;)V", "getTitle", "setTitle", "app_debug"}
    )
    public final class Buttons {
        @NotNull
        private String payload;
        @NotNull
        private String title;

        @NotNull
        public final String getPayload() {
            return this.payload;
        }

        public final void setPayload(@NotNull String var1) {
            Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
            this.payload = var1;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(@NotNull String var1) {
            Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
            this.title = var1;
        }

        public Buttons(@NotNull String payload, @NotNull String title) {
            Intrinsics.checkParameterIsNotNull(payload, "payload");
            Intrinsics.checkParameterIsNotNull(title, "title");
            super();
            this.payload = payload;
            this.title = title;
        }

        // $FF: synthetic method
        public Buttons(String var2, String var3, int var4, DefaultConstructorMarker var5) {
            if ((var4 & 2) != 0) {
                var3 = "Button";
            }

            this(var2, var3);
        }
    }
}
