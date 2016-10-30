package io.blackbricks.bricktemplate.ui.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import io.blackbricks.bricktemplate.R;

/**
 * Created by yegorkryndach on 30/10/16.
 */

public class MenuAdapter extends SupportAnnotatedAdapter implements MenuAdapterBinder {

    public interface MenuClickListener {
        void onMenuHelpClicked();
        void onMenuContactClicked();
    }

    enum Menu {
        HELP,
        CONTACT_US
    }

    @ViewType(layout = R.layout.item_menu,
            initMethod = false,
            views = {
                    @ViewField(id = R.id.image_icon, name = "icon", type = ImageView.class),
                    @ViewField(id = R.id.title, name = "title", type = TextView.class),
            })
    public final int menuItem = 0;

    private MenuClickListener menuClickListener;

    public MenuAdapter(Context context, MenuClickListener menuClickListener) {
        super(context);
        this.menuClickListener = menuClickListener;
    }

    @Override
    public int getItemCount() {
        return Menu.values().length;
    }

    @Override
    public void bindViewHolder(MenuAdapterHolders.MenuItemViewHolder vh, int position) {
        Menu menu = Menu.values()[position];
        switch (menu) {
            case HELP:
                vh.title.setText("help");
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        menuClickListener.onMenuHelpClicked();
                    }
                });
                break;
            case CONTACT_US:
                vh.title.setText("contact");
                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        menuClickListener.onMenuContactClicked();
                    }
                });
                break;
        }
    }
}
