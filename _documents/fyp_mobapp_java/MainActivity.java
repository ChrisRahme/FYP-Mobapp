package fyp_mobapp_java;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import fyp_mobapp_java.BotResponse.Buttons;
import fyp_mobapp_java.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(
        mv = {1, 1, 18},
        bv = {1, 0, 3},
        k = 1,
        d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006 "},
        d2 = {"Lcom/example/fyp_mobapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "BOT_BUT", "", "BOT_IMG", "BOT_TXT", "USER", "adapter", "Lcom/example/fyp_mobapp/MessageAdapter;", "button_view", "Landroidx/recyclerview/widget/RecyclerView;", "editText", "Landroid/widget/EditText;", "ip", "mainActivity", "Lcom/example/fyp_mobapp/databinding/ActivityMainBinding;", "messageList", "Ljava/util/ArrayList;", "Lcom/example/fyp_mobapp/Message;", "Lkotlin/collections/ArrayList;", "sendBtn", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "url", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "sendMessage", "message", "alternative", "ButtonRecyclerView", "app_debug"}
)
public final class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainActivity;
    private ArrayList messageList;
    private MessageAdapter adapter;
    private EditText editText;
    private FloatingActionButton sendBtn;
    private RecyclerView button_view;
    private final String ip = "194.126.17.114";
    private final String url;
    private final String USER;
    private final String BOT_TXT;
    private final String BOT_IMG;
    private final String BOT_BUT;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.messageList = new ArrayList();
        ActivityMainBinding var10001 = ActivityMainBinding.inflate(this.getLayoutInflater());
        Intrinsics.checkExpressionValueIsNotNull(var10001, "ActivityMainBinding.inflate(layoutInflater)");
        this.mainActivity = var10001;
        var10001 = this.mainActivity;
        if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        }

        this.setContentView((View)var10001.getRoot());
        MessageAdapter var5 = new MessageAdapter;
        Context var10003 = (Context)this;
        ArrayList var10004 = this.messageList;
        if (var10004 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageList");
        }

        var5.<init>(var10003, var10004);
        this.adapter = var5;
        MessageAdapter var10000 = this.adapter;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }

        var10000.setHasStableIds(true);
        ActivityMainBinding var3 = this.mainActivity;
        if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        }

        RecyclerView var4 = var3.messageList;
        Intrinsics.checkExpressionValueIsNotNull(var4, "mainActivity.messageList");
        var5 = this.adapter;
        if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }

        var4.setAdapter((Adapter)var5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context)this);
        linearLayoutManager.setOrientation(1);
        var3 = this.mainActivity;
        if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        }

        var4 = var3.messageList;
        Intrinsics.checkExpressionValueIsNotNull(var4, "mainActivity.messageList");
        var4.setLayoutManager((LayoutManager)linearLayoutManager);
        var3 = this.mainActivity;
        if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        }

        var3.sendButton.setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                EditText var10000 = MainActivity.access$getMainActivity$p(MainActivity.this).messageBox;
                Intrinsics.checkExpressionValueIsNotNull(var10000, "mainActivity.messageBox");
                String var3 = var10000.getText().toString();
                boolean var4 = false;
                if (var3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                } else {
                    String msg = StringsKt.trim((CharSequence)var3).toString();
                    if (Intrinsics.areEqual(msg, "") ^ true) {
                        MainActivity.sendMessage$default(MainActivity.this, msg, (String)null, 2, (Object)null);
                        MainActivity.access$getMainActivity$p(MainActivity.this).messageBox.setText((CharSequence)"");
                    } else {
                        Toast.makeText((Context)MainActivity.this, (CharSequence)"Please enter a message.", 0).show();
                    }

                }
            }
        }));
    }

    public final void sendMessage(@NotNull String message, @NotNull String alternative) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(alternative, "alternative");
        CharSequence var4 = (CharSequence)alternative;
        boolean var5 = false;
        boolean var6 = false;
        String displayedMessage = var4.length() == 0 ? message : alternative;
        Message userMessage = new Message(this.USER, message);
        Message userDisplayed = new Message(this.USER, displayedMessage);
        ArrayList var10000 = this.messageList;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageList");
        }

        var10000.add(userDisplayed);
        MessageAdapter var12 = this.adapter;
        if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }

        var12.notifyDataSetChanged();
        OkHttpClient okHttpClient = new OkHttpClient();
        Retrofit retrofit = (new Builder()).baseUrl(this.url).client(okHttpClient).addConverterFactory((Factory)GsonConverterFactory.create()).build();
        MessageSender messageSender = (MessageSender)retrofit.create(MessageSender.class);
        Call response = messageSender.sendMessage(userMessage);
        response.enqueue((Callback)(new Callback() {
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(response, "response");
                if (response.body() != null) {
                    Object var10000 = response.body();
                    if (var10000 == null) {
                        Intrinsics.throwNpe();
                    }

                    if (((ArrayList)var10000).size() != 0) {
                        int i = 0;
                        var10000 = response.body();
                        if (var10000 == null) {
                            Intrinsics.throwNpe();
                        }

                        for(int var4 = ((ArrayList)var10000).size(); i < var4; ++i) {
                            var10000 = response.body();
                            if (var10000 == null) {
                                Intrinsics.throwNpe();
                            }

                            var10000 = ((ArrayList)var10000).get(i);
                            Intrinsics.checkExpressionValueIsNotNull(var10000, "response.body()!![i]");
                            BotResponse messagex = (BotResponse)var10000;

                            try {
                                CharSequence var6 = (CharSequence)messagex.getText();
                                boolean var7 = false;
                                if (var6.length() > 0) {
                                    MainActivity.access$getMessageList$p(MainActivity.this).add(new Message(MainActivity.this.BOT_TXT, messagex.getText()));
                                } else {
                                    var6 = (CharSequence)messagex.getImage();
                                    var7 = false;
                                    if (var6.length() > 0) {
                                        MainActivity.access$getMessageList$p(MainActivity.this).add(new Message(MainActivity.this.BOT_IMG, messagex.getImage()));
                                    }
                                }
                            } catch (Exception var9) {
                            }

                            try {
                                if (messagex.getButtons() != null) {
                                    MainActivity.ButtonRecyclerView buttonRecyclerView = MainActivity.this.new ButtonRecyclerView((Context)MainActivity.this, messagex.getButtons());
                                    LinearLayoutManager layoutManager = new LinearLayoutManager((Context)MainActivity.this);
                                    MainActivity var13 = MainActivity.this;
                                    View var10001 = MainActivity.this.findViewById(1000114);
                                    Intrinsics.checkExpressionValueIsNotNull(var10001, "findViewById<RecyclerView>(R.id.button_list)");
                                    var13.button_view = (RecyclerView)var10001;
                                    MainActivity.access$getButton_view$p(MainActivity.this).setAdapter((Adapter)buttonRecyclerView);
                                    layoutManager.setOrientation(0);
                                    MainActivity.access$getButton_view$p(MainActivity.this).setLayoutManager((LayoutManager)layoutManager);
                                }
                            } catch (Exception var8) {
                            }

                            MainActivity.access$getAdapter$p(MainActivity.this).notifyDataSetChanged();
                        }

                        return;
                    }
                }

                String message = "Sorry, something went wrong:\nReceived empty response.";
                MainActivity.access$getMessageList$p(MainActivity.this).add(new Message(MainActivity.this.BOT_TXT, message));
                MainActivity.access$getAdapter$p(MainActivity.this).notifyDataSetChanged();
            }

            public void onFailure(@NotNull Call call, @NotNull Throwable t) {
                Intrinsics.checkParameterIsNotNull(call, "call");
                Intrinsics.checkParameterIsNotNull(t, "t");
                t.printStackTrace();
                String message = "Sorry, something went wrong:\n" + t.getMessage();
                MainActivity.access$getMessageList$p(MainActivity.this).add(new Message(MainActivity.this.BOT_TXT, message));
                MainActivity.access$getAdapter$p(MainActivity.this).notifyDataSetChanged();
            }
        }));
    }

    // $FF: synthetic method
    public static void sendMessage$default(MainActivity var0, String var1, String var2, int var3, Object var4) {
        if ((var3 & 2) != 0) {
            var2 = "";
        }

        var0.sendMessage(var1, var2);
    }

    public MainActivity() {
        this.url = "http://" + this.ip + ":/webhooks/rest/";
        this.USER = "MobileApp3";
        this.BOT_TXT = "0";
        this.BOT_IMG = "1";
        this.BOT_BUT = "2";
    }

    // $FF: synthetic method
    public static final ActivityMainBinding access$getMainActivity$p(MainActivity $this) {
        ActivityMainBinding var10000 = $this.mainActivity;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivity");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setMainActivity$p(MainActivity $this, ActivityMainBinding var1) {
        $this.mainActivity = var1;
    }

    // $FF: synthetic method
    public static final ArrayList access$getMessageList$p(MainActivity $this) {
        ArrayList var10000 = $this.messageList;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageList");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setMessageList$p(MainActivity $this, ArrayList var1) {
        $this.messageList = var1;
    }

    // $FF: synthetic method
    public static final RecyclerView access$getButton_view$p(MainActivity $this) {
        RecyclerView var10000 = $this.button_view;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("button_view");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final MessageAdapter access$getAdapter$p(MainActivity $this) {
        MessageAdapter var10000 = $this.adapter;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }

        return var10000;
    }

    // $FF: synthetic method
    public static final void access$setAdapter$p(MainActivity $this, MessageAdapter var1) {
        $this.adapter = var1;
    }

    @Metadata(
            mv = {1, 1, 18},
            bv = {1, 0, 3},
            k = 1,
            d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J \u0010\u0019\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R$\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"},
            d2 = {"Lcom/example/fyp_mobapp/MainActivity$ButtonRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/fyp_mobapp/MainActivity$ButtonRecyclerView$ButtonViewHolder;", "Lcom/example/fyp_mobapp/MainActivity;", "context", "Landroid/content/Context;", "buttons", "", "Lcom/example/fyp_mobapp/BotResponse$Buttons;", "Lcom/example/fyp_mobapp/BotResponse;", "(Lcom/example/fyp_mobapp/MainActivity;Landroid/content/Context;Ljava/util/List;)V", "getButtons", "()Ljava/util/List;", "setButtons", "(Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ButtonViewHolder", "app_debug"}
    )
    public final class ButtonRecyclerView extends Adapter {
        @NotNull
        private Context context;
        @NotNull
        private List buttons;

        @NotNull
        public MainActivity.ButtonRecyclerView.ButtonViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            View var10003 = LayoutInflater.from(this.context).inflate(1300084, parent, false);
            Intrinsics.checkExpressionValueIsNotNull(var10003, "LayoutInflater.from(cont…list_item, parent, false)");
            return new MainActivity.ButtonRecyclerView.ButtonViewHolder(var10003);
        }

        // $FF: synthetic method
        // $FF: bridge method
        public ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
            return (ViewHolder)this.onCreateViewHolder(var1, var2);
        }

        public void onBindViewHolder(@NotNull MainActivity.ButtonRecyclerView.ButtonViewHolder holder, int position) {
            Intrinsics.checkParameterIsNotNull(holder, "holder");
            final Buttons button = (Buttons)this.buttons.get(position);
            MaterialButton var10000 = holder.getButton();
            Intrinsics.checkExpressionValueIsNotNull(var10000, "holder.button");
            var10000.setText((CharSequence)button.getTitle());
            holder.getButton().setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View it) {
                    MainActivity.this.sendMessage(button.getPayload(), button.getTitle());
                }
            }));
        }

        // $FF: synthetic method
        // $FF: bridge method
        public void onBindViewHolder(ViewHolder var1, int var2) {
            this.onBindViewHolder((MainActivity.ButtonRecyclerView.ButtonViewHolder)var1, var2);
        }

        public int getItemCount() {
            this.buttons.isEmpty();
            return this.buttons.size();
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
        public final List getButtons() {
            return this.buttons;
        }

        public final void setButtons(@NotNull List var1) {
            Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
            this.buttons = var1;
        }

        public ButtonRecyclerView(@NotNull Context context, @NotNull List buttons) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(buttons, "buttons");
            super();
            this.context = context;
            this.buttons = buttons;
        }

        @Metadata(
                mv = {1, 1, 18},
                bv = {1, 0, 3},
                k = 1,
                d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"},
                d2 = {"Lcom/example/fyp_mobapp/MainActivity$ButtonRecyclerView$ButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/fyp_mobapp/MainActivity$ButtonRecyclerView;Landroid/view/View;)V", "button", "Lcom/google/android/material/button/MaterialButton;", "kotlin.jvm.PlatformType", "getButton", "()Lcom/google/android/material/button/MaterialButton;", "app_debug"}
        )
        public final class ButtonViewHolder extends ViewHolder {
            private final MaterialButton button;

            public final MaterialButton getButton() {
                return this.button;
            }

            public ButtonViewHolder(@NotNull View view) {
                Intrinsics.checkParameterIsNotNull(view, "view");
                super(view);
                this.button = (MaterialButton)view.findViewById(1000020);
            }
        }
    }
}
