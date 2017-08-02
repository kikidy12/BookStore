package kr.co.tjeit.bookstore.activitiys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.tjeit.bookstore.datas.Book;


public class BookListActivity extends AppCompatActivity {

    private TextView activityTitleTxt;
    private ImageButton addImgBtn;
    private ListView bookListView;
    public static ArrayList<Book> books = new ArrayList<Book>();
    ArrayAdapter<Book> booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        bindViews();
        addBookList();

        booksAdapter = new ArrayAdapter<Book>(BookListActivity.this, android.R.layout.simple_list_item_1, books);
        bookListView.setAdapter(booksAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(BookListActivity.this, ViewInfoBookInfoActivity.class);
                myIntent.putExtra("book", books.get(position));
                startActivity(myIntent);
            }
        });

        bookListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(BookListActivity.this);
                myBuilder.setTitle("삭제");
                myBuilder.setMessage("삭제하시겠습니까?");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(BookListActivity.this, "삭제기능은 준비중입니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                myBuilder.setNegativeButton("Cancle", null);
                myBuilder.show();
                return true;
            }
        });

    }

    private void addBookList() {
        books.clear();
        books.add(new Book("의학의 법칙들", "싯다르타 무케르지", "문학동네", 1500, R.drawable.book_a));
        books.add(new Book("여자의 독서", "김진애", "가산북스", 2000, R.drawable.book_b));
        books.add(new Book("기억 독서법", "기성준", "북씽크", 1500, R.drawable.book_c));
        books.add(new Book("인간의 위대한 여정", "배철현", "21세기북스", 1000, R.drawable.book_d));
    }

    private void bindViews() {
        this.bookListView = (ListView) findViewById(R.id.bookListView);
        this.addImgBtn = (ImageButton) findViewById(R.id.addImgBtn2);
        this.activityTitleTxt = (TextView) findViewById(R.id.activityTitleTxt);
    }
}
