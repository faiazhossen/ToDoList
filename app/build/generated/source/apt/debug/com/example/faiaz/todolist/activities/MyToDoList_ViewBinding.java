// Generated code from Butter Knife. Do not modify!
package com.example.faiaz.todolist.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.example.faiaz.todolist.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyToDoList_ViewBinding implements Unbinder {
  private MyToDoList target;

  private View view2131558551;

  @UiThread
  public MyToDoList_ViewBinding(MyToDoList target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyToDoList_ViewBinding(final MyToDoList target, View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.lv_todo, "field 'listView'", ListView.class);
    target.editText = Utils.findRequiredViewAsType(source, R.id.et_add_text, "field 'editText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_add, "field 'btn_add' and method 'addItem'");
    target.btn_add = Utils.castView(view, R.id.btn_add, "field 'btn_add'", Button.class);
    view2131558551 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addItem(p0);
      }
    });
    target.et_time = Utils.findRequiredViewAsType(source, R.id.et_time, "field 'et_time'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyToDoList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.editText = null;
    target.btn_add = null;
    target.et_time = null;

    view2131558551.setOnClickListener(null);
    view2131558551 = null;
  }
}
