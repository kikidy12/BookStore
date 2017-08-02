package kr.co.tjeit.bookstore.activitiys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.tjeit.bookstore.datas.Customer;

public class ViewCustomerInfoActivity extends AppCompatActivity {

    private Customer mCustomer;
    private TextView customerNameTxt;
    private TextView customerPhoneNumTxt;
    private TextView customerEmailTxt;
    private Button modfyCustomerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_info);
        bindViews();
        mCustomer = (Customer) getIntent().getSerializableExtra("customer");

        customerNameTxt.setText(mCustomer.Name);
        customerPhoneNumTxt.setText(mCustomer.phoneNum);
        customerEmailTxt.setText(mCustomer.e_mail);



        modfyCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewCustomerInfoActivity.this, EditCustomerInfoActivity.class);
                intent.putExtra("customer", mCustomer);
                startActivityForResult(intent, 1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            if(resultCode == RESULT_OK){
                Customer tempCustomer = (Customer) data.getSerializableExtra("newCustomer");
                customerNameTxt.setText(tempCustomer.Name);
                customerPhoneNumTxt.setText(tempCustomer.phoneNum);
                customerEmailTxt.setText(tempCustomer.e_mail);

                int orginalPositon = getIntent().getIntExtra("position", -1);

                Customer originalCustomer = CustomerListActivity.customers.get(orginalPositon);
                originalCustomer.Name = tempCustomer.Name;
                originalCustomer.e_mail = tempCustomer.e_mail;
                originalCustomer.phoneNum = tempCustomer.phoneNum;
            }
        }
    }

    private void bindViews() {
        customerNameTxt = (TextView) findViewById(R.id.customerNameTxt);
        customerPhoneNumTxt = (TextView) findViewById(R.id.customerPhoneNumTxt);
        customerEmailTxt = (TextView) findViewById(R.id.customerEmailTxt);
        modfyCustomerBtn = (Button) findViewById(R.id.modfyCustomerBtn);

    }
}
