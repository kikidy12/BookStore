package kr.co.tjeit.bookstore.activitiys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button customerAdminBtn;
    private Button bookAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        bookAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookListActivity.class);
                startActivity(intent);
            }
        });

        customerAdminBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CustomerListActivity.class);
                startActivity(myIntent);
            }
        });
    }

    private void bindViews() {
        this.bookAdminBtn = (Button) findViewById(R.id.bookAdminBtn);
        this.customerAdminBtn = (Button) findViewById(R.id.customerAdminBtn);
    }
}
