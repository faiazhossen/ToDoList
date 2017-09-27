// Generated code from Butter Knife. Do not modify!
package com.example.faiaz.todolist.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.faiaz.todolist.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target, View source) {
    this.target = target;

    target.mPhoneNumber = Utils.findRequiredViewAsType(source, R.id.field_phone_number, "field 'mPhoneNumber'", EditText.class);
    target.mVerification = Utils.findRequiredViewAsType(source, R.id.field_verification_code, "field 'mVerification'", EditText.class);
    target.mStartButton = Utils.findRequiredViewAsType(source, R.id.button_start_verification, "field 'mStartButton'", Button.class);
    target.mVerifyPhone = Utils.findRequiredViewAsType(source, R.id.button_verify_phone, "field 'mVerifyPhone'", Button.class);
    target.login_text = Utils.findRequiredViewAsType(source, R.id.login_text, "field 'login_text'", TextView.class);
    target.singup_text = Utils.findRequiredViewAsType(source, R.id.signup_text, "field 'singup_text'", TextView.class);
    target.user_email = Utils.findRequiredViewAsType(source, R.id.user_email, "field 'user_email'", EditText.class);
    target.user_password = Utils.findRequiredViewAsType(source, R.id.user_password, "field 'user_password'", EditText.class);
    target.user_email_reg = Utils.findRequiredViewAsType(source, R.id.user_email_reg, "field 'user_email_reg'", EditText.class);
    target.user_password_reg = Utils.findRequiredViewAsType(source, R.id.user_password_reg, "field 'user_password_reg'", EditText.class);
    target.verifyLayout = Utils.findRequiredViewAsType(source, R.id.layout_verify, "field 'verifyLayout'", LinearLayout.class);
    target.btn_reg = Utils.findRequiredViewAsType(source, R.id.btn_reg, "field 'btn_reg'", Button.class);
    target.btn_login = Utils.findRequiredViewAsType(source, R.id.btn_login, "field 'btn_login'", Button.class);
    target.user_password_reg_confirm = Utils.findRequiredViewAsType(source, R.id.user_password_reg_confirm, "field 'user_password_reg_confirm'", EditText.class);
    target.user_login = Utils.findRequiredViewAsType(source, R.id.user_login, "field 'user_login'", LinearLayout.class);
    target.user_reg = Utils.findRequiredViewAsType(source, R.id.user_reg, "field 'user_reg'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPhoneNumber = null;
    target.mVerification = null;
    target.mStartButton = null;
    target.mVerifyPhone = null;
    target.login_text = null;
    target.singup_text = null;
    target.user_email = null;
    target.user_password = null;
    target.user_email_reg = null;
    target.user_password_reg = null;
    target.verifyLayout = null;
    target.btn_reg = null;
    target.btn_login = null;
    target.user_password_reg_confirm = null;
    target.user_login = null;
    target.user_reg = null;
  }
}
