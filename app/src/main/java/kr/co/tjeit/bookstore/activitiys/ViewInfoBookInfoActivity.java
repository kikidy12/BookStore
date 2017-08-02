package kr.co.tjeit.bookstore.activitiys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.tjeit.bookstore.datas.Book;


public class ViewInfoBookInfoActivity extends AppCompatActivity {

    private TextView bookTitleTxt;
    private TextView atuhorNameTxt;
    private TextView publisherNameTxt;
    private TextView costTxt;
    private Button modfyCustomerBtn;
    private Book mBook;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_info_book_info);
        bindVidws();
        mBook = (Book) getIntent().getSerializableExtra("book");
        setValues();

    }

    private  void  setValues() {
        bookTitleTxt.setText(mBook.getTitle());
        atuhorNameTxt.setText(mBook.getAuthorName());
        publisherNameTxt.setText(mBook.getPublisherName());
        costTxt.setText(mBook.getCost() + "");
        imgView.setImageResource(mBook.getBookImgId());
    }

    private void bindVidws() {
        this.modfyCustomerBtn = (Button) findViewById(R.id.modfyCustomerBtn);
        this.costTxt = (TextView) findViewById(R.id.costTxt);
        this.publisherNameTxt = (TextView) findViewById(R.id.publisherNameTxt);
        this.atuhorNameTxt = (TextView) findViewById(R.id.atuhorNameTxt);
        this.bookTitleTxt = (TextView) findViewById(R.id.bookTitleTxt);
        this.imgView = (ImageView) findViewById(R.id.imgView);
    }
}
