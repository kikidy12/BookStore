package kr.co.tjeit.bookstore.activitiys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import kr.co.tjeit.bookstore.datas.Customer;

public class CustomerListActivity extends AppCompatActivity {

    // 1. 리스트뷰 맴버변수 => find~
    // 2. 리스트뷰에 뿌려줄 데이터 ArrayList생성
    // 3. ArrayList에 데이터 채워넣기
    // 4. ArrayAtapter => 초기화
    // 5. 리스트뷰.setAdapter();
    // ==> 여기까지가, 데이터를 리스트뷰에 출력하는 방법
    // 6. 리스트뷰를 눌렸을 때 이벤트 처리
    // => listView.setOnItemClickListener();
    private ImageButton addCustomerImgBtn;
    private ListView customerListView;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayAdapter<Customer> customerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        bindView();
        customers.clear();
        customers.add(new Customer("고동윤", "010-1111-1111","adsasd@asd.com"));
        customers.add(new Customer("권성민", "010-2222-2222", "kikidy12@naver.com"));
        customers.add(new Customer("김현철", "010-3333-3333", "kikidy13@gmail.com"));

        customerAdapter = new ArrayAdapter<Customer>(CustomerListActivity.this, android.R.layout.simple_list_item_1, customers);
        customerListView.setAdapter(customerAdapter);

        customerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(CustomerListActivity.this, ViewCustomerInfoActivity.class);
                myIntent.putExtra("customer", customers.get(position));
                myIntent.putExtra("position", position);
                startActivity(myIntent);
            }
        });

        customerListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(CustomerListActivity.this);
                myBuilder.setTitle("삭제확인");
                myBuilder.setMessage("정말 삭제하시겠습니까?");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(CustomerListActivity.this, "삭제 준비중입니다.", Toast.LENGTH_SHORT).show();
                        customers.remove(position);
                        customerAdapter.notifyDataSetChanged();
                    }
                });
                myBuilder.setNegativeButton("Cancle", null);
                myBuilder.setNeutralButton("다시보지 않기", null);
                myBuilder.setIcon(R.mipmap.ic_launcher_round);
                myBuilder.show();
                return true;
            }
        });
        addCustomerImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(CustomerListActivity.this, "추후 구현 예정", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CustomerListActivity.this, EditCustomerInfoActivity.class);
                startActivityForResult(intent, 1000);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        customerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1000){
            Log.d("KS", "사용자 객체가 돌아옴");

            if(resultCode == RESULT_OK){
                Customer tempCustomer = (Customer) data.getSerializableExtra("newCustomer");
                Log.d("새고객이름", tempCustomer.Name);

                customers.add(tempCustomer);
                customerAdapter.notifyDataSetChanged();
            }
        }
    }

    private void bindView() {
        customerListView = (ListView) findViewById(R.id.customerListView);
        addCustomerImgBtn = (ImageButton) findViewById(R.id.addCustomerImgBtn);
    }

}
