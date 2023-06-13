package cn.edu.hqu.cst.android.lzt.ex5;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAccount;
    private EditText editTextPassword;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAccount = findViewById(R.id.editTextAccount);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        // 初始化SharedPreferences
        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        // 检查是否已保存账户和密码
        String savedAccount = sharedPreferences.getString("account", null);
        String savedPassword = sharedPreferences.getString("password", null);

        if (savedAccount != null && savedPassword != null) {
            // 如果已保存账户和密码，则自动填充
            editTextAccount.setText(savedAccount);
            editTextPassword.setText(savedPassword);
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();

                // 保存账户和密码到SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("account", account);
                editor.putString("password", password);
                editor.apply();

            }
        });
    }
}