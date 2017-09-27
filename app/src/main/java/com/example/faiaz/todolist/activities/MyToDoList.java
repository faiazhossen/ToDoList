package com.example.faiaz.todolist.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.faiaz.todolist.R;
import com.example.faiaz.todolist.adapter.CustomListAdapter;
import com.example.faiaz.todolist.model.Items;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyToDoList extends AppCompatActivity {
    @BindView(R.id.lv_todo)
    ListView listView;
    @BindView(R.id.et_add_text)
    EditText editText;
    @BindView(R.id.btn_add)
    Button btn_add;
    @BindView(R.id.et_time)
    EditText et_time;

    private ArrayList<Items> itemList = new ArrayList<>();
    private DatabaseReference databaseReference;
    CustomListAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_to_do_list);
        ButterKnife.bind(this);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        customAdapter = new CustomListAdapter(this, itemList);
        listView.setAdapter(customAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                itemList.clear();
                getAllData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @OnClick(R.id.btn_add)
    public void addItem(View view) {
        String name = editText.getText().toString();
        String time = et_time.getText().toString();

        if (name.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please enter the name of the task",
                    Toast.LENGTH_SHORT).show();

        } else {
            Items item = new Items(name, time);
            databaseReference.push().setValue(item);
            editText.setText("");
            et_time.setText("");

        }
    }

    private void getAllData(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Items item = ds.getValue(Items.class);
            Log.d("DATA_VALUE ", item.getTaskName());
            itemList.add(item);

            customAdapter.notifyDataSetChanged();
        }
    }
}