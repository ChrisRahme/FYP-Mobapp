package fyp_mobapp_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000bH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""},
        d2 = {"Lcom/example/fyp_mobapp/MessageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/fyp_mobapp/MessageAdapter$MessageViewHolder;", "context", "Landroid/content/Context;", "messageList", "Ljava/util/ArrayList;", "Lcom/example/fyp_mobapp/Message;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "BOT_BUT_LAYOUT", "", "BOT_IMG_LAYOUT", "BOT_TXT_LAYOUT", "USER_LAYOUT", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getMessageList", "()Ljava/util/ArrayList;", "setMessageList", "(Ljava/util/ArrayList;)V", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MessageViewHolder", "app_debug"}
)
public final class MessageAdapter extends Adapter {
    private int USER_LAYOUT;
    private int BOT_TXT_LAYOUT;
    private int BOT_IMG_LAYOUT;
    private int BOT_BUT_LAYOUT;
    @NotNull
    private Context context;
    @NotNull
    private ArrayList messageList;

    @NotNull
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        View view = null;
        View var10000;
        if (viewType != this.BOT_TXT_LAYOUT && viewType != this.BOT_IMG_LAYOUT) {
            if (viewType == this.BOT_BUT_LAYOUT) {
                var10000 = LayoutInflater.from(this.context).inflate(1300086, parent, false);
                Intrinsics.checkExpressionValueIsNotNull(var10000, "LayoutInflater.from(cont…vity_main, parent, false)");
                view = var10000;
            } else {
                var10000 = LayoutInflater.from(this.context).inflate(1300094, parent, false);
                Intrinsics.checkExpressionValueIsNotNull(var10000, "LayoutInflater.from(cont…ssage_box, parent, false)");
                view = var10000;
            }
        } else {
            var10000 = LayoutInflater.from(this.context).inflate(1300052, parent, false);
            Intrinsics.checkExpressionValueIsNotNull(var10000, "LayoutInflater.from(cont…ssage_box, parent, false)");
            view = var10000;
        }

        return new MessageAdapter.MessageViewHolder(view);
    }

    // $FF: synthetic method
    // $FF: bridge method
    public ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
        return (ViewHolder)this.onCreateViewHolder(var1, var2);
    }

    public void onBindViewHolder(@NotNull MessageAdapter.MessageViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        Object var10000 = this.messageList.get(position);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "messageList[position]");
        Message message = (Message)var10000;
        Object var10001;
        TextView var10;
        ImageView var11;
        RecyclerView var12;
        if (Intrinsics.areEqual(message.getSender(), String.valueOf(this.BOT_TXT_LAYOUT))) {
            var10 = holder.getMessageView();
            Intrinsics.checkExpressionValueIsNotNull(var10, "holder.messageView");
            var10001 = message.getMessage();
            if (var10001 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }

            var10.setText((CharSequence)((String)var10001));

            try {
                var11 = holder.getImage_view();
                Intrinsics.checkExpressionValueIsNotNull(var11, "holder.image_view");
                var11.setVisibility(8);
                var12 = holder.getButton_view();
                Intrinsics.checkExpressionValueIsNotNull(var12, "holder.button_view");
                var12.setVisibility(8);
            } catch (Exception var9) {
            }
        } else if (Intrinsics.areEqual(message.getSender(), String.valueOf(this.BOT_IMG_LAYOUT))) {
            var11 = holder.getImage_view();
            if (var11 == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }

            ImageView image = var11;
            Glide.with(this.context).load(message.getMessage()).into(image);

            try {
                var10 = holder.getMessageView();
                Intrinsics.checkExpressionValueIsNotNull(var10, "holder.messageView");
                if (var10.getVisibility() == 8) {
                }

                var12 = holder.getButton_view();
                Intrinsics.checkExpressionValueIsNotNull(var12, "holder.button_view");
                var12.setVisibility(8);
            } catch (Exception var8) {
            }
        } else if (Intrinsics.areEqual(message.getSender(), String.valueOf(this.BOT_BUT_LAYOUT))) {
            try {
                var10 = holder.getMessageView();
                Intrinsics.checkExpressionValueIsNotNull(var10, "holder.messageView");
                if (var10.getVisibility() == 8) {
                }

                var11 = holder.getImage_view();
                Intrinsics.checkExpressionValueIsNotNull(var11, "holder.image_view");
                var11.setVisibility(8);
            } catch (Exception var7) {
            }
        } else {
            var10 = holder.getMessageView();
            Intrinsics.checkExpressionValueIsNotNull(var10, "holder.messageView");
            var10001 = message.getMessage();
            if (var10001 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }

            var10.setText((CharSequence)((String)var10001));

            try {
                var11 = holder.getImage_view();
                Intrinsics.checkExpressionValueIsNotNull(var11, "holder.image_view");
                var11.setVisibility(8);
            } catch (Exception var6) {
            }
        }

    }

    // $FF: synthetic method
    // $FF: bridge method
    public void onBindViewHolder(ViewHolder var1, int var2) {
        this.onBindViewHolder((MessageAdapter.MessageViewHolder)var1, var2);
    }

    public int getItemCount() {
        return this.messageList.size();
    }

    public int getItemViewType(int position) {
        super.getItemViewType(position);
        Object var10000 = this.messageList.get(position);
        Intrinsics.checkExpressionValueIsNotNull(var10000, "messageList[position]");
        Message view = (Message)var10000;
        if (Intrinsics.areEqual(view.getSender(), String.valueOf(this.BOT_TXT_LAYOUT))) {
            return this.BOT_TXT_LAYOUT;
        } else if (Intrinsics.areEqual(view.getSender(), String.valueOf(this.BOT_IMG_LAYOUT))) {
            return this.BOT_IMG_LAYOUT;
        } else {
            return Intrinsics.areEqual(view.getSender(), String.valueOf(this.BOT_BUT_LAYOUT)) ? this.BOT_BUT_LAYOUT : this.USER_LAYOUT;
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void setContext(@NotNull Context var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.context = var1;
    }

    @NotNull
    public final ArrayList getMessageList() {
        return this.messageList;
    }

    public final void setMessageList(@NotNull ArrayList var1) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
        this.messageList = var1;
    }

    public MessageAdapter(@NotNull Context context, @NotNull ArrayList messageList) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(messageList, "messageList");
        super();
        this.context = context;
        this.messageList = messageList;
        this.USER_LAYOUT = 1234;
        this.BOT_IMG_LAYOUT = 1;
        this.BOT_BUT_LAYOUT = 2;
    }

    @Metadata(
            mv = {1, 1, 18},
            bv = {1, 0, 3},
            k = 1,
            d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"},
            d2 = {"Lcom/example/fyp_mobapp/MessageAdapter$MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "button_view", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getButton_view", "()Landroidx/recyclerview/widget/RecyclerView;", "image_view", "Landroid/widget/ImageView;", "getImage_view", "()Landroid/widget/ImageView;", "messageView", "Landroid/widget/TextView;", "getMessageView", "()Landroid/widget/TextView;", "app_debug"}
    )
    public static final class MessageViewHolder extends ViewHolder {
        private final TextView messageView;
        private final ImageView image_view;
        private final RecyclerView button_view;

        public final TextView getMessageView() {
            return this.messageView;
        }

        public final ImageView getImage_view() {
            return this.image_view;
        }

        public final RecyclerView getButton_view() {
            return this.button_view;
        }

        public MessageViewHolder(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            super(view);
            this.messageView = (TextView)view.findViewById(1000106);
            this.image_view = (ImageView)view.findViewById(1000216);
            this.button_view = (RecyclerView)view.findViewById(1000114);
        }
    }
}
