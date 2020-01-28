// Generated code from Butter Knife. Do not modify!
package com.example.jobtest.UI;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.jobtest.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.home = Utils.findRequiredViewAsType(source, R.id.home, "field 'home'", ImageView.class);
    target.search = Utils.findRequiredViewAsType(source, R.id.search, "field 'search'", ImageView.class);
    target.profile = Utils.findRequiredViewAsType(source, R.id.profile, "field 'profile'", ImageView.class);
    target.cup = Utils.findRequiredViewAsType(source, R.id.cup, "field 'cup'", ImageView.class);
    target.fab_1 = Utils.findRequiredViewAsType(source, R.id.fab_1, "field 'fab_1'", FloatingActionButton.class);
    target.fab_2 = Utils.findRequiredViewAsType(source, R.id.fab_2, "field 'fab_2'", FloatingActionButton.class);
    target.fab_3 = Utils.findRequiredViewAsType(source, R.id.fab_3, "field 'fab_3'", FloatingActionButton.class);
    target.fab_4 = Utils.findRequiredViewAsType(source, R.id.fab_4, "field 'fab_4'", FloatingActionButton.class);
    target.bellman = Utils.findRequiredViewAsType(source, R.id.fab, "field 'bellman'", ImageView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.rv_parent, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.home = null;
    target.search = null;
    target.profile = null;
    target.cup = null;
    target.fab_1 = null;
    target.fab_2 = null;
    target.fab_3 = null;
    target.fab_4 = null;
    target.bellman = null;
    target.recyclerView = null;
  }
}
